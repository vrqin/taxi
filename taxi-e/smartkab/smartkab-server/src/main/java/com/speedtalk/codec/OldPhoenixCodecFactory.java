package com.speedtalk.codec;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

import java.nio.charset.Charset;

public class OldPhoenixCodecFactory implements ProtocolCodecFactory {
    private final OldPhoenixDecoder decoder;
    private final Encoder encoder;

    public OldPhoenixCodecFactory() {
        this(Charset.defaultCharset());
    }

    public OldPhoenixCodecFactory(Charset charset) {
        decoder = new OldPhoenixDecoder(charset);
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
