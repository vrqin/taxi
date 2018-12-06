package com.alipay.api.internal.util.codec;

public abstract interface BinaryEncoder extends Encoder {
    public abstract byte[] encode(byte[] paramArrayOfByte) throws EncoderException;
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.codec.BinaryEncoder
 * JD-Core Version:    0.6.0
 */