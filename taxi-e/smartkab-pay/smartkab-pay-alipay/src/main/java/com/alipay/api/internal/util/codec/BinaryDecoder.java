package com.alipay.api.internal.util.codec;

public abstract interface BinaryDecoder extends Decoder {
    public abstract byte[] decode(byte[] paramArrayOfByte) throws DecoderException;
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.codec.BinaryDecoder
 * JD-Core Version:    0.6.0
 */