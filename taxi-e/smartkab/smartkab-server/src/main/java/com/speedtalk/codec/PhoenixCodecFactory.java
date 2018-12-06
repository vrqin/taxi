package com.speedtalk.codec;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

import java.nio.charset.Charset;

public class PhoenixCodecFactory implements ProtocolCodecFactory {
    private final PhoenixDecoder decoder;
    private final Encoder encoder;

    public PhoenixCodecFactory() {
        this(Charset.defaultCharset());
    }

    public PhoenixCodecFactory(Charset charset) {
        decoder = new PhoenixDecoder(charset);
        encoder = new Encoder(charset);
    }

    @Override
    public ProtocolDecoder getDecoder(IoSession arg0) throws Exception {
        return decoder;
    }

    @Override
    public ProtocolEncoder getEncoder(IoSession arg0) throws Exception {
        return encoder;
    }
}
