/*   */
package com.alipay.api.internal.util.json;

/*   */
/*   */ public class ExceptionErrorListener extends BufferErrorListener
        /*   */ {
    /*   */
    public void error(String type, int col)
    /*   */ {
        /* 6 */
        super.error(type, col);
        /* 7 */
        throw new IllegalArgumentException(this.buffer.toString());
        /*   */
    }
    /*   */
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.json.ExceptionErrorListener
 * JD-Core Version:    0.6.0
 */