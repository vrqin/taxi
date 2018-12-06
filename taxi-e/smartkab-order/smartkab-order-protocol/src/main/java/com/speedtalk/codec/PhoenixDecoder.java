package com.speedtalk.codec;

import com.speedtalk.protocol.constants.LengthConstants;
import com.speedtalk.protocol.tscobjs.TscObjParser;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.AttributeKey;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import java.nio.ByteOrder;
import java.nio.charset.Charset;

public class PhoenixDecoder implements ProtocolDecoder {
    private static final byte HEAD_ONE = (byte) 0xAA;
    private static final byte HEAD_TWO = (byte) 0x7F;
    private static final byte TAIL_ONE = (byte) 0x0D;
    private static final byte TAIL_TWO = (byte) 0x0A;
    private final AttributeKey CONTEXT = new AttributeKey(getClass(), "context");
    private final Charset charset;

    public PhoenixDecoder() {
        this.charset = Charset.defaultCharset();
    }

    public PhoenixDecoder(Charset charset) {
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

    public void decode(IoSession session, IoBuffer ioBuffer, ProtocolDecoderOutput out) throws Exception {

        // 先获取上次的处理上下文，其中可能有未处理完的数据
        Context ctx = getContext(session);
        // 先把当前buffer中的数据追加到Context的buffer当中
        ctx.append(ioBuffer);
        // 把position指向0位置，把limit指向原来的position位置
        IoBuffer buffer = ctx.getBuffer();
        buffer.flip();
        buffer.shrink();
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        int head = 0;
        byte[] temp = null, cmd = null, garbage = null;
        while (buffer.remaining() >= LengthConstants.MESSAGE_LEAST) {
            int dataLen = buffer.remaining();
            buffer.mark();
            temp = new byte[dataLen];
            buffer.get(temp);
            buffer.reset();
            head = findFlag(temp, HEAD_ONE, HEAD_TWO); // 找头
            if (head == -1) // 找不到头
            {
                buffer.clear();
                return;
            } else if (head != 0) {
                garbage = new byte[head];
                buffer.get(garbage);
                continue;
            }

            buffer.mark();
            buffer.position(buffer.limit() - dataLen + 2);
            int para_len = buffer.getShort();
            buffer.reset();

            int audio_len = para_len + 23;
            if (dataLen < audio_len)
                break;

            if (temp[audio_len - 2] == TAIL_ONE && temp[audio_len - 1] == TAIL_TWO) {
                cmd = new byte[audio_len];
                buffer.get(cmd);
                out.write(TscObjParser.getInstance().parse(cmd));
                continue;
            }

            int standrad_len = para_len + 34;
            if (dataLen < standrad_len)
                break;

            if (temp[standrad_len - 2] == TAIL_ONE && temp[standrad_len - 1] == TAIL_TWO) {
                cmd = new byte[standrad_len];
                buffer.get(cmd);
                out.write(TscObjParser.getInstance().parse(cmd));
                continue;
            }
            buffer.get(temp, 0, 2);
            break;
        }
        if (buffer.hasRemaining())
            buffer.compact();
        else
            buffer.clear();
    }

    public int findFlag(byte[] src, byte target1, byte target2) {
        int len = src.length;
        for (int i = 0; i < len; i++) {
            try {
                if (src[i] == target1)
                    if (src[i + 1] == target2)
                        return i;
            } catch (Exception e) {
            }
        }
        return -1;
    }

    public void dispose(IoSession session) throws Exception {
        Context ctx = (Context) session.getAttribute(CONTEXT);
        if (ctx != null) {
            session.removeAttribute(CONTEXT);
        }
    }

    public void finishDecode(IoSession arg0, ProtocolDecoderOutput arg1) throws Exception {
    }

    private class Context {
        private IoBuffer buf;

        private Context() {
            buf = IoBuffer.allocate(128).setAutoExpand(true);
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
