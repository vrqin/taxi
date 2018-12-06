package com.speedtalk.codec;

import com.speedtalk.protocol.constants.LengthConstants;
import com.speedtalk.protocol.tscobjs.TscObjParser;
import com.speedtalk.utils.ExcepPrinter;
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
    private int parameterLength = -1;

    public PhoenixDecoder() {
        this.charset = Charset.defaultCharset();
    }

    public PhoenixDecoder(Charset charset) {
        this.charset = charset;
    }

    public static int getParameterLength(byte[] data) {
        if (data == null || data.length == 0) {
            return -1;
        }
        int length = 0;
        for (int i = data.length - 1; i >= 0; i--) {
            length = ((data[i] & 0xff) << (i * 8)) + length;
        }
        return length;
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

        Context ctx = getContext(session);
        ctx.append(buffer);
        IoBuffer buf = ctx.getBuffer();
        buf.flip();
        buf.shrink();
        buf.order(ByteOrder.LITTLE_ENDIAN);
        //		cnsleLog.debug("receive data:" + StringUtils.buff2HexAsciiString(buf.array()) + ",pos=" + buf.position()
        //				+ ",buf.limit=" + buf.limit());
        int head = 0;
        int foot = 0;
        byte[] src = null;
        byte[] integrity = null;
        while (buf.remaining() >= LengthConstants.MESSAGE_LEAST) {
            buf.mark();
            src = new byte[buf.limit() - buf.position()];
            buf.get(src);
            buf.reset();
            head = findHead(src, HEAD_ONE, HEAD_TWO);
            if (head != -1) {
                foot = findFoot(src, TAIL_ONE, TAIL_TWO, head, parameterLength);
                if (foot != -1) {
                    if (foot > head) {
                        if (head != 0) {
                            byte[] garbage = new byte[head];
                            buf.get(garbage);
                        }
                        integrity = new byte[foot + 2 - head];
                        buf.get(integrity);
                        try {
                            out.write(TscObjParser.getInstance().parse(integrity));
                        } catch (Exception e) {
                            ExcepPrinter.print(e);
                        }
                    } else {
                        buf.position(head);
                    }
                } else {
                    break;
                }
            } else {
                foot = findFlag(src, HEAD_ONE, HEAD_TWO);
                if (foot != -1) {
                    buf.position(foot + 2);
                } else {
                    buf.clear();
                    return;
                }
            }
        }
        if (buf.hasRemaining()) {
            buf.compact();
        } else {
            buf.clear();
        }
    }

    public int findFlag(byte[] src, byte target1, byte target2) {
        int index = 0;
        while (index < src.length) {
            index = findChar(src, target1, index);
            if (index == -1 || index == (src.length - 1)) {
                return -1;
            }
            if (src[index + 1] == target2) {
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }

    public int findHead(byte[] src, byte target1, byte target2) {
        int index = 0;
        while (index < src.length) {
            index = findChar(src, target1, index);
            if (index == -1 || index == (src.length - 1)) {
                return -1;
            }
            if (src[index + 1] == target2) {
                if (src.length >= index + 3) {
                    parameterLength = getParameterLength(new byte[]{src[index + 2], src[index + 3]});
                }
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }

    public int findFoot(byte[] src, byte target1, byte target2, int head, int parameterLength) {
        int index = 0;
        while (index < src.length) {
            index = findChar(src, target1, index);
            if (index == -1 || index == (src.length - 1)) {
                return -1;
            }
            if (src[index + 1] == target2) {
                if (index - head < parameterLength + 32) {
                    index++;
                } else {
                    return index;
                }
            } else {
                index++;
            }
        }
        return -1;
    }

    public int findChar(byte[] src, byte target, int index) {
        if (index >= src.length) {
            return -1;
        }
        for (int i = index; i < src.length; i++) {
            if (src[i] == target)
                return i;
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
