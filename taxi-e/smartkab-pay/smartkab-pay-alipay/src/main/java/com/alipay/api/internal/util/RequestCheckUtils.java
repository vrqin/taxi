package com.alipay.api.internal.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.FileItem;

import java.io.IOException;

public class RequestCheckUtils {
    public static final String ERROR_CODE_ARGUMENTS_MISS = "40001";
    public static final String ERROR_CODE_ARGUMENTS_INVALID = "40002";

    public static void checkNotEmpty(Object value, String fieldName) throws AlipayApiException {
        /* 13 */
        if (value == null) {
            /* 14 */
            throw new AlipayApiException("40001", "client-error:Missing Required Arguments:" + fieldName + "");
        }

        /* 17 */
        if (((value instanceof String)) &&
                /* 18 */       (((String) value).trim().length() == 0))
            /* 19 */
            throw new AlipayApiException("40001", "client-error:Missing Required Arguments:" + fieldName + "");
    }

    public static void checkMaxLength(String value, int maxLength, String fieldName) throws AlipayApiException {
        /* 27 */
        if ((value != null) &&
                /* 28 */       (value.length() > maxLength))
            /* 29 */
            throw new AlipayApiException("40002", "client-error:Invalid Arguments:the length of " + fieldName + " can not be larger than " + maxLength + ".");
    }

    public static void checkMaxLength(FileItem fileItem, int maxLength, String fieldName) throws AlipayApiException {
        try {
            /* 39 */
            if ((fileItem != null) && (fileItem.getContent() != null)) {
                /* 41 */
                if (fileItem.getContent().length > maxLength) {
                    /* 42 */
                    throw new AlipayApiException("40002", "client-error:Invalid Arguments:the length of " + fieldName + " can not be larger than " + maxLength + ".");
                }
            }
        } catch (IOException e) {
            /* 48 */
            throw new RuntimeException(e);
        }
    }

    public static void checkMaxListSize(String value, int maxSize, String fieldName) throws AlipayApiException {
        /* 54 */
        if (value != null) {
            /* 55 */
            String[] list = value.split(",");
            /* 56 */
            if ((list != null) && (list.length > maxSize))
                /* 57 */
                throw new AlipayApiException("40002", "client-error:Invalid Arguments:the listsize(the string split by \",\") of " + fieldName + " must be less than " + maxSize + ".");
        }
    }

    public static void checkMaxValue(Long value, long maxValue, String fieldName) throws AlipayApiException {
        /* 66 */
        if ((value != null) &&
                /* 67 */       (value.longValue() > maxValue))
            /* 68 */
            throw new AlipayApiException("40002", "client-error:Invalid Arguments:the value of " + fieldName + " can not be larger than " + maxValue + ".");
    }

    public static void checkMinValue(Long value, long minValue, String fieldName) throws AlipayApiException {
        /* 77 */
        if ((value != null) &&
                /* 78 */       (value.longValue() < minValue))
            /* 79 */
            throw new AlipayApiException("40002", "client-error:Invalid Arguments:the value of " + fieldName + " can not be less than " + minValue + ".");
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.RequestCheckUtils
 * JD-Core Version:    0.6.0
 */