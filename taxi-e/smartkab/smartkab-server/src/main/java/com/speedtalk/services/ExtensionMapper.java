/**
 * ExtensionMapper.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */


package com.speedtalk.services;

/**
 * ExtensionMapper class
 */
@SuppressWarnings({"unchecked", "unused"})

public class ExtensionMapper {

    public static Object getTypeObject(String namespaceURI, String typeName, javax.xml.stream.XMLStreamReader reader)
            throws Exception {


        if ("http://datas.speedtalk.com/xsd".equals(namespaceURI) && "CallInfo".equals(typeName)) {

            return com.speedtalk.datas.xsd.CallInfo.Factory.parse(reader);


        }


        if ("http://datas.speedtalk.com/xsd".equals(namespaceURI) && "GrpInfo".equals(typeName)) {

            return com.speedtalk.datas.xsd.GrpInfo.Factory.parse(reader);


        }


        if ("http://datas.speedtalk.com/xsd".equals(namespaceURI) && "Result".equals(typeName)) {

            return com.speedtalk.datas.xsd.Result.Factory.parse(reader);


        }


        if ("http://datas.speedtalk.com/xsd".equals(namespaceURI) && "CallData".equals(typeName)) {

            return com.speedtalk.datas.xsd.CallData.Factory.parse(reader);


        }


        if ("http://datas.speedtalk.com/xsd".equals(namespaceURI) && "Gps".equals(typeName)) {

            return com.speedtalk.datas.xsd.Gps.Factory.parse(reader);


        }


        if ("http://datas.speedtalk.com/xsd".equals(namespaceURI) && "MsInfoExt".equals(typeName)) {

            return com.speedtalk.datas.xsd.MsInfoExt.Factory.parse(reader);


        }


        throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
    }

}
    