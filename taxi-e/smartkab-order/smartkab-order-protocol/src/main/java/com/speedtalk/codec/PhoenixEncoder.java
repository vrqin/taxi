package com.speedtalk.codec;

import com.speedtalk.protocol.TSCObject;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import java.nio.charset.Charset;
import java.util.List;

public class PhoenixEncoder implements ProtocolEncoder {
    private final Charset charset;

    public PhoenixEncoder() {
        this.charset = Charset.defaultCharset();
    }

    public PhoenixEncoder(Charset charset) {
        this.charset = charset;
    }

    @Override
    public void dispose(IoSession arg0) throws Exception {
    }

    @Override
    public void encode(IoSession session, Object arg1, ProtocolEncoderOutput out) throws Exception {
        try {
            TSCObject tscObj = (TSCObject) arg1;
            List<byte[]> list = tscObj.objToBytes();
            IoBuffer resp = null;
            byte[] temp = null;
            for (byte[] bs : list) {
                resp = IoBuffer.wrap(bs);
                if (resp != null) {
                    out.write(resp);
                    out.flush();
                    // if (ParamConstants.isDetail()) {
                    //     temp = new byte[bs.length];
                    //     System.arraycopy(bs, 0, temp, 0, bs.length);
                    // } else {
                    // }
                }

            }
        } catch (Exception e) {
            throw e;
        }
    }
}
