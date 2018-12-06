package com.alipay.api.internal.parser.xml;


import com.alipay.api.*;
import com.alipay.api.internal.mapping.Converter;
import com.alipay.api.internal.mapping.Converters;
import com.alipay.api.internal.mapping.Reader;
import com.alipay.api.internal.util.AlipayEncrypt;
import com.alipay.api.internal.util.StringUtils;
import com.alipay.api.internal.util.XmlUtils;
import org.w3c.dom.Element;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class XmlConverter implements Converter {

    public <T extends AlipayResponse> T toResponse(String rsp, Class<T> clazz) throws AlipayApiException {
        /*  35 */
        Element root = XmlUtils.getRootElementFromString(rsp);
        /*  36 */
        return (AlipayResponse) getModelFromXML(root, clazz);

    }


    private <T> T getModelFromXML(Element element, Class<T> clazz) throws AlipayApiException {
        /*  40 */
        if (element == null) {
            /*  41 */
            return null;

        }
        /*  43 */
        return Converters.convert(clazz, new Reader(element) {

            public boolean hasReturnField(Object name) {
                /*  45 */
                Element childE = XmlUtils.getChildElement(this.val$element, (String) name);
                /*  46 */
                return childE != null;

            }


            public Object getPrimitiveObject(Object name) {
                /*  50 */
                return XmlUtils.getElementValue(this.val$element, (String) name);

            }


            public Object getObject(Object name, Class<?> type) throws AlipayApiException {
                /*  54 */
                Element childE = XmlUtils.getChildElement(this.val$element, (String) name);
                /*  55 */
                if (childE != null) {
                    /*  56 */
                    return XmlConverter.this.getModelFromXML(childE, type);

                }
                /*  58 */
                return null;

            }


            public List<?> getListObjects(Object listName, Object itemName, Class<?> subType)
                    throws AlipayApiException {
                /*  64 */
                List list = null;
                /*  65 */
                Element listE = XmlUtils.getChildElement(this.val$element, (String) listName);

                /*  67 */
                if (listE != null) {
                    /*  68 */
                    list = new ArrayList();
                    /*  69 */
                    List itemEs = XmlUtils.getChildElements(listE, (String) itemName);
                    /*  70 */
                    for (Element itemE : itemEs) {
                        /*  71 */
                        Object obj = null;
                        /*  72 */
                        String value = XmlUtils.getElementValue(itemE);

                        /*  74 */
                        if (String.class.isAssignableFrom(subType)) {
                            /*  75 */
                            obj = value;
                            /*  76 */
                        } else if (Long.class.isAssignableFrom(subType)) {
                            /*  77 */
                            obj = Long.valueOf(value);
                            /*  78 */
                        } else if (Integer.class.isAssignableFrom(subType)) {
                            /*  79 */
                            obj = Integer.valueOf(value);
                            /*  80 */
                        } else if (Boolean.class.isAssignableFrom(subType)) {
                            /*  81 */
                            obj = Boolean.valueOf(value);
                            /*  82 */
                        } else if (Date.class.isAssignableFrom(subType)) {
                            /*  83 */
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                            try {
                                /*  86 */
                                obj = format.parse(value);

                            } catch (ParseException e) {
                                /*  88 */
                                throw new AlipayApiException(e);

                            }

                        } else {
                            /*  91 */
                            obj = XmlConverter.this.getModelFromXML(itemE, subType);

                        }
                        /*  93 */
                        if (obj != null)
                            /*  94 */
                            list.add(obj);

                    }

                }
                /*  97 */
                return list;

            }

        });

    }


    public SignItem getSignItem(AlipayRequest<?> request, String responseBody) throws AlipayApiException {
        /* 109 */
        if (StringUtils.isEmpty(responseBody)) {
            /* 111 */
            return null;

        }

        /* 114 */
        SignItem signItem = new SignItem();

        /* 117 */
        String sign = getSign(responseBody);
        /* 118 */
        signItem.setSign(sign);

        /* 121 */
        String signSourceData = getSignSourceData(request, responseBody);
        /* 122 */
        signItem.setSignSourceDate(signSourceData);

        /* 124 */
        return signItem;

    }


    private String getSignSourceData(AlipayRequest<?> request, String body) {
        /* 136 */
        String rootNode = request.getApiMethodName().replace('.', '_') + "_response";

        /* 138 */
        String errorRootNode = "error_response";

        /* 140 */
        int indexOfRootNode = body.indexOf(rootNode);
        /* 141 */
        int indexOfErrorRoot = body.indexOf(errorRootNode);

        /* 144 */
        if (indexOfRootNode > 0) {
            /* 146 */
            return parseSignSourceData(body, rootNode, indexOfRootNode);

        }
        /* 148 */
        if (indexOfErrorRoot > 0) {
            /* 150 */
            return parseSignSourceData(body, errorRootNode, indexOfErrorRoot);

        }
        /* 152 */
        return null;

    }


    private String getSign(String body) {
        /* 164 */
        String signNodeName = "<sign>";
        /* 165 */
        String signEndNodeName = "</sign>";

        /* 167 */
        int indexOfSignNode = body.indexOf(signNodeName);
        /* 168 */
        int indexOfSignEndNode = body.indexOf(signEndNodeName);

        /* 170 */
        if ((indexOfSignNode < 0) || (indexOfSignEndNode < 0)) {
            /* 171 */
            return null;

        }

        /* 175 */
        return body.substring(indexOfSignNode + signNodeName.length(), indexOfSignEndNode);

    }


    private String parseSignSourceData(String body, String rootNode, int indexOfRootNode) {
        /* 189 */
        int signDataStartIndex = indexOfRootNode + rootNode.length() + 1;
        /* 190 */
        int indexOfSign = body.indexOf("<sign");

        /* 192 */
        if (indexOfSign < 0) {
            /* 194 */
            return null;

        }

        /* 198 */
        int signDataEndIndex = indexOfSign;

        /* 200 */
        return body.substring(signDataStartIndex, signDataEndIndex);

    }


    public String encryptSourceData(AlipayRequest<?> request, String body, String format, String encryptType, String encryptKey, String charset)
            throws AlipayApiException {
        /* 210 */
        ResponseParseItem respSignSourceData = getXMLSignSourceData(request, body);

        /* 212 */
        String bodyIndexContent = body.substring(0, respSignSourceData.getStartIndex());
        /* 213 */
        String bodyEndContent = body.substring(respSignSourceData.getEndIndex());

        /* 215 */
        return bodyIndexContent + AlipayEncrypt.decryptContent(respSignSourceData.getEncryptContent(), encryptType, encryptKey, charset) + bodyEndContent;

    }


    private ResponseParseItem getXMLSignSourceData(AlipayRequest<?> request, String body) {
        /* 229 */
        String rootNode = request.getApiMethodName().replace('.', '_') + "_response";

        /* 231 */
        String errorRootNode = "error_response";

        /* 233 */
        int indexOfRootNode = body.indexOf(rootNode);
        /* 234 */
        int indexOfErrorRoot = body.indexOf(errorRootNode);

        /* 236 */
        if (indexOfRootNode > 0) {
            /* 238 */
            return parseXMLSignSourceData(body, rootNode, indexOfRootNode);

        }
        /* 240 */
        if (indexOfErrorRoot > 0) {
            /* 242 */
            return parseXMLSignSourceData(body, errorRootNode, indexOfErrorRoot);

        }
        /* 244 */
        return null;

    }


    private ResponseParseItem parseXMLSignSourceData(String body, String rootNode, int indexOfRootNode) {
        /* 259 */
        int signDataStartIndex = indexOfRootNode + rootNode.length() + 1;

        /* 261 */
        String xmlStartNode = "<response_encrypted>";
        /* 262 */
        String xmlEndNode = "</response_encrypted>";

        /* 264 */
        int indexOfSign = body.indexOf(xmlEndNode);

        /* 266 */
        if (indexOfSign < 0) {
            /* 268 */
            return new ResponseParseItem(0, 0, "");

        }

        /* 271 */
        int signDataEndIndex = indexOfSign + xmlEndNode.length();

        /* 274 */
        String encryptBizContent = body.substring(signDataStartIndex, signDataEndIndex);

        /* 276 */
        String bizContent = encryptBizContent.substring(xmlStartNode.length(), encryptBizContent.length() - xmlEndNode.length());

        /* 279 */
        return new ResponseParseItem(signDataStartIndex, signDataEndIndex, bizContent);

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.parser.xml.XmlConverter
 * JD-Core Version:    0.6.0
 */