package com.speedtalk.codec;

import com.speedtalk.KabConstants;
import com.speedtalk.StartUp;
import com.speedtalk.oldprotol.AdapterFactory;
import com.speedtalk.oldprotol.ProtolAdapter;
import com.speedtalk.oldprotol.mess.Mess;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.utils.StringUtils;
import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import java.nio.charset.Charset;
import java.util.List;

public class Encoder implements ProtocolEncoder {
    private final Charset charset;

    public Encoder() {
        this.charset = Charset.defaultCharset();
    }

    public Encoder(Charset charset) {
        this.charset = charset;
    }

    @Override
    public void dispose(IoSession arg0) throws Exception {
    }

    @Override
    public void encode(IoSession session, Object arg1, ProtocolEncoderOutput out) throws Exception {
        try {
            List<byte[]> list = null;
            if (LoadXmlConfig.getConfigHash()
                    .get("protocol")
                    .equals(KabConstants.OLD_PROTOCOL) && arg1 instanceof TSCObject) {
                ProtolAdapter adapter = AdapterFactory.getInstance().getAdapter((TSCObject) arg1);
                List<Mess> messList = adapter.adapt((TSCObject) arg1);
                for (Mess mess : messList) {
                    StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + ":" + ((TSCObject) arg1).toString() + "--" + mess
                            .toString());
                    list = mess.objToBytes();
                    for (byte[] bs : list) {
                        try {
                            out.write(IoBuffer.wrap(bs));
                            StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + ",data:" + StringUtils.bytesToHexStr(bs));
                        } catch (Exception e) {
                            ExcepPrinter.print(e);
                        }
                    }
                }
            } else {
                if (arg1 instanceof TSCObject)
                    list = ((TSCObject) arg1).objToBytes();
                else
                    list = ((Mess) arg1).objToBytes();
                for (byte[] bs : list) {
                    try {
                        out.write(IoBuffer.wrap(bs));
                        StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + ",data:" + StringUtils.bytesToHexStr(bs));
                    } catch (Exception e) {
                        ExcepPrinter.print(e);
                    }
                }
            }
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }
}
