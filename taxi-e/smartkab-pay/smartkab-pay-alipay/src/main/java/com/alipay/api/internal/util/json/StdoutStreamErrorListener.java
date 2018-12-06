/*   */
package com.alipay.api.internal.util.json;
/*   */
/*   */

/*   */
/*   */ public class StdoutStreamErrorListener extends BufferErrorListener
        /*   */ {
    /*   */
    public void end()
    /*   */ {
        /* 6 */
        System.out.print(this.buffer.toString());
        /*   */
    }
    /*   */
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.json.StdoutStreamErrorListener
 * JD-Core Version:    0.6.0
 */