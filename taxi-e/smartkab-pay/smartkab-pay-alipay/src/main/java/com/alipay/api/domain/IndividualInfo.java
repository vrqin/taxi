package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class IndividualInfo extends AlipayObject {
    private static final long serialVersionUID = 1747115185143656211L;

    @ApiField("date_of_birth")
    private String dateOfBirth;

    @ApiField("id_number")
    private String idNumber;

    @ApiField("name")
    private String name;

    @ApiField("nationality")
    private String nationality;

    @ApiField("residential_address")
    private String residentialAddress;

    @ApiField("type")
    private String type;

    public String getDateOfBirth() {
        /* 53 */
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        /* 56 */
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdNumber() {
        /* 60 */
        return this.idNumber;
    }

    public void setIdNumber(String idNumber) {
        /* 63 */
        this.idNumber = idNumber;
    }

    public String getName() {
        /* 67 */
        return this.name;
    }

    public void setName(String name) {
        /* 70 */
        this.name = name;
    }

    public String getNationality() {
        /* 74 */
        return this.nationality;
    }

    public void setNationality(String nationality) {
        /* 77 */
        this.nationality = nationality;
    }

    public String getResidentialAddress() {
        /* 81 */
        return this.residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        /* 84 */
        this.residentialAddress = residentialAddress;
    }

    public String getType() {
        /* 88 */
        return this.type;
    }

    public void setType(String type) {
        /* 91 */
        this.type = type;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.IndividualInfo
 * JD-Core Version:    0.6.0
 */