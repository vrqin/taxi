package com.alipay.api.internal.parser.json;


import com.alipay.api.*;
import com.alipay.api.internal.mapping.Converter;
import com.alipay.api.internal.mapping.Converters;
import com.alipay.api.internal.mapping.Reader;
import com.alipay.api.internal.util.AlipayEncrypt;
import com.alipay.api.internal.util.StringUtils;
import com.alipay.api.internal.util.json.ExceptionErrorListener;
import com.alipay.api.internal.util.json.JSONReader;
import com.alipay.api.internal.util.json.JSONValidatingReader;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class JsonConverter implements Converter {

    public <T extends AlipayResponse> T toResponse(String rsp, Class<T> clazz) throws AlipayApiException {
        /*  37 */
        JSONReader reader = new JSONValidatingReader(new ExceptionErrorListener());
        /*  38 */
        Object rootObj = reader.read(rsp);

        Iterator i$;
        /*  39 */
        if ((rootObj instanceof Map)) {
            /*  40 */
            Map rootJson = (Map) rootObj;
            /*  41 */
            Collection values = rootJson.values();
            /*  42 */
            for (i$ = values.iterator(); i$.hasNext(); ) {
                Object rspObj = i$.next();
                /*  43 */
                if ((rspObj instanceof Map)) {
                    /*  44 */
                    Map rspJson = (Map) rspObj;
                    /*  45 */
                    return (AlipayResponse) fromJson(rspJson, clazz);

                }

            }

        }
        /*  49 */
        return null;

    }


    public <T> T fromJson(Map<?, ?> json, Class<T> clazz) throws AlipayApiException {
        /*  62 */
        return Converters.convert(clazz, new Reader(json) {

            public boolean hasReturnField(Object name) {
                /*  64 */
                return this.val$json.containsKey(name);

            }


            public Object getPrimitiveObject(Object name) {
                /*  68 */
                return this.val$json.get(name);

            }


            public Object getObject(Object name, Class<?> type) throws AlipayApiException {
                /*  72 */
                Object tmp = this.val$json.get(name);
                /*  73 */
                if ((tmp instanceof Map)) {
                    /*  74 */
                    Map map = (Map) tmp;
                    /*  75 */
                    return JsonConverter.this.fromJson(map, type);

                }
                /*  77 */
                return null;

            }


            public List<?> getListObjects(Object listName, Object itemName, Class<?> subType)
                    throws AlipayApiException {
                /*  83 */
                List listObjs = null;

                /*  85 */
                Object listTmp = this.val$json.get(listName);
                /*  86 */
                if ((listTmp instanceof Map)) {
                    /*  87 */
                    Map jsonMap = (Map) listTmp;
                    /*  88 */
                    Object itemTmp = jsonMap.get(itemName);
                    /*  89 */
                    if ((itemTmp == null) && (listName != null)) {
                        /*  90 */
                        String listNameStr = listName.toString();
                        /*  91 */
                        itemTmp = jsonMap.get(listNameStr.substring(0, listNameStr.length() - 1));

                    }
                    /*  93 */
                    if ((itemTmp instanceof List))
                        /*  94 */
                        listObjs = getListObjectsInner(subType, itemTmp);

                }
                /*  96 */
                else if ((listTmp instanceof List)) {
                    /*  97 */
                    listObjs = getListObjectsInner(subType, listTmp);

                }

                /* 100 */
                return listObjs;

            }


            private List<Object> getListObjectsInner(Class<?> subType, Object itemTmp) throws AlipayApiException {
                /* 106 */
                List listObjs = new ArrayList();
                /* 107 */
                List tmpList = (List) itemTmp;
                /* 108 */
                for (Iterator i$ = tmpList.iterator(); i$.hasNext(); ) {
                    Object subTmp = i$.next();
                    /* 109 */
                    Object obj = null;
                    /* 110 */
                    if (String.class.isAssignableFrom(subType)) {
                        /* 111 */
                        obj = subTmp;
                        /* 112 */
                    } else if (Long.class.isAssignableFrom(subType)) {
                        /* 113 */
                        obj = subTmp;
                        /* 114 */
                    } else if (Integer.class.isAssignableFrom(subType)) {
                        /* 115 */
                        obj = subTmp;
                        /* 116 */
                    } else if (Boolean.class.isAssignableFrom(subType)) {
                        /* 117 */
                        obj = subTmp;
                        /* 118 */
                    } else if (Date.class.isAssignableFrom(subType)) {
                        /* 119 */
                        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                        try {
                            /* 121 */
                            obj = format.parse(String.valueOf(subTmp));

                        } catch (ParseException e) {
                            /* 123 */
                            throw new AlipayApiException(e);

                        }
                        /* 125 */
                    } else if ((subTmp instanceof Map)) {
                        /* 126 */
                        Map subMap = (Map) subTmp;
                        /* 127 */
                        obj = JsonConverter.this.fromJson(subMap, subType);

                    }

                    /* 130 */
                    if (obj != null) {
                        /* 131 */
                        listObjs.add(obj);

                    }

                }
                /* 134 */
                return listObjs;

            }

        });

    }


    public SignItem getSignItem(AlipayRequest<?> request, String responseBody) throws AlipayApiException {
        /* 147 */
        if (StringUtils.isEmpty(responseBody)) {
            /* 149 */
            return null;

        }

        /* 152 */
        SignItem signItem = new SignItem();

        /* 155 */
        String sign = getSign(responseBody);
        /* 156 */
        signItem.setSign(sign);

        /* 159 */
        String signSourceData = getSignSourceData(request, responseBody);
        /* 160 */
        signItem.setSignSourceDate(signSourceData);

        /* 162 */
        return signItem;

    }


    private String getSignSourceData(AlipayRequest<?> request, String body) {
        /* 174 */
        String rootNode = request.getApiMethodName().replace('.', '_') + "_response";

        /* 176 */
        String errorRootNode = "error_response";

        /* 178 */
        int indexOfRootNode = body.indexOf(rootNode);
        /* 179 */
        int indexOfErrorRoot = body.indexOf(errorRootNode);

        /* 182 */
        if (indexOfRootNode > 0) {
            /* 184 */
            return parseSignSourceData(body, rootNode, indexOfRootNode);

        }

        /* 187 */
        if (indexOfErrorRoot > 0) {
            /* 189 */
            return parseSignSourceData(body, errorRootNode, indexOfErrorRoot);

        }
        /* 191 */
        return null;

    }


    private String parseSignSourceData(String body, String rootNode, int indexOfRootNode) {
        /* 207 */
        int signDataStartIndex = indexOfRootNode + rootNode.length() + 2;
        /* 208 */
        int indexOfSign = body.indexOf("\"sign\"");

        /* 210 */
        if (indexOfSign < 0) {
            /* 212 */
            return null;

        }

        /* 216 */
        int signDataEndIndex = indexOfSign - 1;

        /* 218 */
        return body.substring(signDataStartIndex, signDataEndIndex);

    }


    private String getSign(String body) {
        /* 229 */
        JSONReader reader = new JSONValidatingReader(new ExceptionErrorListener());
        /* 230 */
        Object rootObj = reader.read(body);
        /* 231 */
        Map rootJson = (Map) rootObj;

        /* 233 */
        return (String) rootJson.get("sign");

    }


    public String encryptSourceData(AlipayRequest<?> request, String body, String format, String encryptType, String encryptKey, String charset)
            throws AlipayApiException {
        /* 243 */
        ResponseParseItem respSignSourceData = getJSONSignSourceData(request, body);

        /* 245 */
        String bodyIndexContent = body.substring(0, respSignSourceData.getStartIndex());
        /* 246 */
        String bodyEndContent = body.substring(respSignSourceData.getEndIndex());

        /* 248 */
        return bodyIndexContent + AlipayEncrypt.decryptContent(respSignSourceData.getEncryptContent(), encryptType, encryptKey, charset) + bodyEndContent;

    }


    private ResponseParseItem getJSONSignSourceData(AlipayRequest<?> request, String body) {
        /* 263 */
        String rootNode = request.getApiMethodName().replace('.', '_') + "_response";

        /* 265 */
        String errorRootNode = "error_response";

        /* 267 */
        int indexOfRootNode = body.indexOf(rootNode);
        /* 268 */
        int indexOfErrorRoot = body.indexOf(errorRootNode);

        /* 270 */
        if (indexOfRootNode > 0) {
            /* 272 */
            return parseJSONSignSourceData(body, rootNode, indexOfRootNode);

        }
        /* 274 */
        if (indexOfErrorRoot > 0) {
            /* 276 */
            return parseJSONSignSourceData(body, errorRootNode, indexOfErrorRoot);

        }
        /* 278 */
        return null;

    }


    private ResponseParseItem parseJSONSignSourceData(String body, String rootNode, int indexOfRootNode) {
        /* 293 */
        int signDataStartIndex = indexOfRootNode + rootNode.length() + 2;
        /* 294 */
        int indexOfSign = body.indexOf("\"sign\"");

        /* 296 */
        if (indexOfSign < 0) {
            /* 298 */
            indexOfSign = body.length();

        }

        /* 301 */
        int signDataEndIndex = indexOfSign - 1;

        /* 303 */
        String encryptContent = body.substring(signDataStartIndex + 1, signDataEndIndex - 1);

        /* 305 */
        return new ResponseParseItem(signDataStartIndex, signDataEndIndex, encryptContent);

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.parser.json.JsonConverter
 * JD-Core Version:    0.6.0
 */