package com.speedtalk.codec;

import com.speedtalk.KabConstants;
import com.speedtalk.StartUp;
import com.speedtalk.oldprotol.MessParser;
import com.speedtalk.oldprotol.OptionConstants;
import com.speedtalk.oldprotol.mess.Position;
import com.speedtalk.protocol.utils.StringUtils;
import com.speedtalk.utils.ExcepPrinter;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.AttributeKey;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import java.nio.ByteOrder;
import java.nio.charset.Charset;

public class OldPhoenixDecoder implements ProtocolDecoder {
    private final AttributeKey CONTEXT = new AttributeKey(getClass(), "context");
    private final Charset charset;

    public OldPhoenixDecoder() {
        this.charset = Charset.defaultCharset();
    }

    public OldPhoenixDecoder(Charset charset) {
        this.charset = charset;
    }

    private Context getContext(IoSession session) {
        Context ctx;
        ctx = (Context) session.getAttribute(CONTEXT);
        if (ctx == null) {
            ctx = new Context();
            session.setAttribute(CONTEXT, ctx);
        }
        return ctx;
    }

    public void decode(IoSession session, IoBuffer buffer, ProtocolDecoderOutput out) throws Exception {
        StartUp.LOG.debug(KabConstants.getOldLogPrefix() + ",decode:" + StringUtils.bytesToHexStr(buffer.array()));
        Context ctx = getContext(session);
        ctx.append(buffer);
        IoBuffer buf = ctx.getBuffer();
        buf.flip();
        buf.shrink();
        buf.order(ByteOrder.LITTLE_ENDIAN);
        // cnsleLog.debug("receive data:" +
        // StringUtils.buff2HexAsciiString(buf.array()) + ",pos=" +
        // buf.position()
        // + ",buf.limit=" + buf.limit());
        byte[] integrity = null;
        byte[] msId = new byte[12];
        int totalLen = 0;
        while (buf.remaining() > OptionConstants.HEAD_LEN - 1) {
            buf.mark();
            /**
             * AA 55 AA 55 开头的协议数据
             */
            if (buf.get() == OptionConstants.HEAD[0] && buf.get() == OptionConstants.HEAD[1] && buf.get() == OptionConstants.HEAD[2] && buf
                    .get() == OptionConstants.HEAD[3]) {
                buf.get();
                buf.get(msId);

                int low = buf.get();
                int middle = buf.get();
                int hight = buf.get();
                int len = (hight << 16) + (middle << 8) + low;
                if (buf.remaining() > len) {
                    byte commId = buf.get();
                    buf.reset();
                    integrity = new byte[22 + len];
                    buf.get(integrity);
                    StartUp.LOG.debug("AA 55...-->len:" + len + ",commID:" + String.format("%02X", commId) + ",Data:" + StringUtils
                            .bytesToHexStr(integrity));
                    if (commId == OptionConstants.GPS) {
                        try {
                            out.write(new Position(integrity));
                            //							StartUp.LOG.debug(KabConstants.getOldLogPrefix() + StringUtils.bytesToHexStr(integrity));
                        } catch (Exception e) {
                            ExcepPrinter.print(e);
                        }
                    }
                } else {
                    buf.reset();
                    break;
                }
            } else {
                buf.reset();
                totalLen = buf.getInt();
                if (buf.remaining() > totalLen - 4 - 1) {
                    //					StartUp.LOG.debug(KabConstants.getOldLogPrefix() + ",totalLen:" + totalLen + "," + buf.position());
                    buf.reset();
                    integrity = new byte[totalLen];
                    buf.get(integrity);
                    try {
                        out.write(MessParser.getInstance().parse(integrity));
                        //						StartUp.LOG.debug(KabConstants.getOldLogPrefix() + StringUtils.bytesToHexStr(integrity));
                    } catch (Exception e) {
                        ExcepPrinter.print(e);
                    }
                } else {
                    //					StartUp.LOG.debug(KabConstants.getOldLogPrefix() + ",totalLen:" + totalLen + "," + buf.position());
                    buf.reset();
                    break;
                }
            }
        }
        if (buf.hasRemaining())
            buf.compact();
        else
            buf.clear();
    }

    public void dispose(IoSession session) throws Exception {
        Context ctx = (Context) session.getAttribute(CONTEXT);
        if (ctx != null)
            session.removeAttribute(CONTEXT);
    }

    public void finishDecode(IoSession arg0, ProtocolDecoderOutput arg1) throws Exception {
    }

    private class Context {
        private IoBuffer buf;

        private Context() {
            buf = IoBuffer.allocate(64).setAutoExpand(true);
            buf.setAutoShrink(true);
        }

        public IoBuffer getBuffer() {
            return buf;
        }

        public void append(IoBuffer in) {
            getBuffer().put(in);
        }
    }
}
