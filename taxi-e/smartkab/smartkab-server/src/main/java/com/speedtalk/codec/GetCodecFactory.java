package com.speedtalk.codec;

import com.speedtalk.KabConstants;
import com.speedtalk.utils.LoadXmlConfig;
import org.apache.mina.filter.codec.ProtocolCodecFactory;

import java.nio.charset.Charset;

public class GetCodecFactory {
    private static GetCodecFactory instance;

    private GetCodecFactory() {
    }

    public static GetCodecFactory getInstance() {
        if (null == instance)
            instance = new GetCodecFactory();
        return instance;
    }

    public ProtocolCodecFactory getCodecFactory(String charsetName) {
        try {
            if (LoadXmlConfig.getConfigHash().get("protocol").equals(KabConstants.OLD_PROTOCOL))
                return new OldPhoenixCodecFactory(Charset.forName(charsetName));
            else
                return new PhoenixCodecFactory(Charset.forName(charsetName));
        } catch (Exception e) {
            return null;
        }
    }
}
