package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class ShopInfo extends AlipayObject {
    private static final long serialVersionUID = 4821863859479645167L;

    @ApiField("shop_name")
    private String shopName;

    @ApiListField("shop_scene_pic")
    @ApiField("string")
    private List<String> shopScenePic;

    @ApiField("shop_sign_board_pic")
    private String shopSignBoardPic;

    public String getShopName() {
        /* 39 */
        return this.shopName;
    }

    public void setShopName(String shopName) {
        /* 42 */
        this.shopName = shopName;
    }

    public List<String> getShopScenePic() {
        /* 46 */
        return this.shopScenePic;
    }

    public void setShopScenePic(List<String> shopScenePic) {
        /* 49 */
        this.shopScenePic = shopScenePic;
    }

    public String getShopSignBoardPic() {
        /* 53 */
        return this.shopSignBoardPic;
    }

    public void setShopSignBoardPic(String shopSignBoardPic) {
        /* 56 */
        this.shopSignBoardPic = shopSignBoardPic;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ShopInfo
 * JD-Core Version:    0.6.0
 */