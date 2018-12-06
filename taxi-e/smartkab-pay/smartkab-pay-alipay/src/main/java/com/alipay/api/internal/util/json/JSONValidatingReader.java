package com.alipay.api.internal.util.json;

public class JSONValidatingReader extends JSONReader {
    /*  4 */   public static final Object INVALID = new Object();
    private JSONValidator validator;

    public JSONValidatingReader(JSONValidator validator) {
        /*  8 */
        this.validator = validator;
    }

    public JSONValidatingReader(JSONErrorListener listener) {
        /* 12 */
        this(new JSONValidator(listener));
    }

    public JSONValidatingReader() {
        /* 16 */
        this(new StdoutStreamErrorListener());
    }

    public Object read(String string) {
        /* 20 */
        if (!this.validator.validate(string))
            return INVALID;
        /* 21 */
        return super.read(string);
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.json.JSONValidatingReader
 * JD-Core Version:    0.6.0
 */