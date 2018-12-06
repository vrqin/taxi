package com.alipay.api.internal.mapping;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.util.StringUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class Converters {

    /*  35 */   private static final Set<String> baseFields = new HashSet();

    /*  37 */   private static final Set<String> excludeFields = new HashSet();

    /*  40 */   private static final Set<String> overideFields = new HashSet();
    /*  33 */   public static boolean isCheckJsonType = false;


    static {
        /*  43 */
        baseFields.add("code");
        /*  44 */
        baseFields.add("msg");
        /*  45 */
        baseFields.add("subCode");
        /*  46 */
        baseFields.add("subMsg");
        /*  47 */
        baseFields.add("body");
        /*  48 */
        baseFields.add("params");
        /*  49 */
        baseFields.add("success");

        /*  53 */
        excludeFields.add("errorCode");

        /*  59 */
        overideFields.add("code");
        /*  60 */
        overideFields.add("msg");

    }


    public static <T> T convert(Class<T> clazz, Reader reader) throws AlipayApiException {
        /*  76 */
        Object rsp = null;

        try {
            /*  79 */
            rsp = clazz.newInstance();
            /*  80 */
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            /*  81 */
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();

            /*  83 */
            boolean isResponseClazz = AlipayResponse.class.isAssignableFrom(clazz);

            String itemName;

            String listName;
            /*  85 */
            for (PropertyDescriptor pd : pds) {
                /*  86 */
                Method writeMethod = pd.getWriteMethod();
                /*  87 */
                if (writeMethod == null) {

                    continue;

                }
                /*  91 */
                itemName = pd.getName();
                /*  92 */
                listName = null;

                /*  95 */
                if ((isResponseClazz) && (excludeFields.contains(itemName))) {

                    continue;

                }

                /* 100 */
                List alipayFieldMethods = new ArrayList();

                /* 102 */
                if ((baseFields.contains(itemName)) && (isResponseClazz)) {
                    /* 104 */
                    Field field = AlipayResponse.class.getDeclaredField(itemName);

                    /* 106 */
                    AlipayFieldMethod alipayFieldMethod = new AlipayFieldMethod();
                    /* 107 */
                    alipayFieldMethod.setField(field);

                    /* 110 */
                    if (writeMethod.getDeclaringClass().getName().contains("AlipayResponse")) {
                        /* 112 */
                        alipayFieldMethod.setMethod(writeMethod);

                    } else {
                        /* 115 */
                        writeMethod = tryGetSetMethod(AlipayResponse.class, field, writeMethod.getName());

                        /* 117 */
                        if (writeMethod == null) {

                            continue;

                        }
                        /* 121 */
                        alipayFieldMethod.setMethod(writeMethod);

                    }
                    /* 123 */
                    alipayFieldMethods.add(alipayFieldMethod);

                    /* 126 */
                    if (overideFields.contains(itemName)) {
                        /* 128 */
                        field = tryGetFieldWithoutExp(clazz, itemName);

                        /* 130 */
                        if (field != null) {
                            /* 132 */
                            writeMethod = tryGetSetMethod(clazz, field, writeMethod.getName());
                            /* 133 */
                            if (writeMethod == null) {

                                continue;

                            }
                            /* 136 */
                            alipayFieldMethod = new AlipayFieldMethod();
                            /* 137 */
                            alipayFieldMethod.setField(field);
                            /* 138 */
                            alipayFieldMethod.setMethod(writeMethod);
                            /* 139 */
                            alipayFieldMethods.add(alipayFieldMethod);

                        }

                    }

                } else {
                    /* 145 */
                    Field field = clazz.getDeclaredField(itemName);

                    /* 147 */
                    AlipayFieldMethod alipayFieldMethod = new AlipayFieldMethod();
                    /* 148 */
                    alipayFieldMethod.setField(field);
                    /* 149 */
                    alipayFieldMethod.setMethod(writeMethod);
                    /* 150 */
                    alipayFieldMethods.add(alipayFieldMethod);

                }

                /* 154 */
                for (AlipayFieldMethod alipayFieldMethod : alipayFieldMethods) {
                    /* 156 */
                    Field field = alipayFieldMethod.getField();
                    /* 157 */
                    Method method = alipayFieldMethod.getMethod();

                    /* 159 */
                    ApiField jsonField = (ApiField) field.getAnnotation(ApiField.class);
                    /* 160 */
                    if (jsonField != null) {
                        /* 161 */
                        itemName = jsonField.value();

                    }
                    /* 163 */
                    ApiListField jsonListField = (ApiListField) field.getAnnotation(ApiListField.class);
                    /* 164 */
                    if (jsonListField != null) {
                        /* 165 */
                        listName = jsonListField.value();

                    }

                    /* 168 */
                    if ((!reader.hasReturnField(itemName)) && (
                            /* 169 */             (listName == null) || (!reader.hasReturnField(listName)))) {

                        continue;

                    }

                    /* 174 */
                    Class typeClass = field.getType();

                    /* 176 */
                    if (String.class.isAssignableFrom(typeClass)) {
                        /* 177 */
                        Object value = reader.getPrimitiveObject(itemName);
                        /* 178 */
                        if ((value instanceof String)) {
                            /* 179 */
                            method.invoke(rsp, new Object[]{value.toString()});

                        } else {
                            /* 181 */
                            if ((isCheckJsonType) && (value != null)) {
                                /* 182 */
                                throw new AlipayApiException(itemName + " is not a String");

                            }
                            /* 184 */
                            if (value != null)
                                /* 185 */
                                method.invoke(rsp, new Object[]{value.toString()});

                            else
                                /* 187 */                 method.invoke(rsp, new Object[]{""});

                        }

                    }
                    /* 190 */
                    else if (Long.class.isAssignableFrom(typeClass)) {
                        /* 191 */
                        Object value = reader.getPrimitiveObject(itemName);
                        /* 192 */
                        if ((value instanceof Long)) {
                            /* 193 */
                            method.invoke(rsp, new Object[]{(Long) value});

                        } else {
                            /* 195 */
                            if ((isCheckJsonType) && (value != null)) {
                                /* 196 */
                                throw new AlipayApiException(itemName + " is not a Number(Long)");

                            }
                            /* 198 */
                            if (StringUtils.isNumeric(value))
                                /* 199 */
                                method.invoke(rsp, new Object[]{Long.valueOf(value.toString())});

                        }

                    }
                    /* 202 */
                    else if (Integer.class.isAssignableFrom(typeClass)) {
                        /* 203 */
                        Object value = reader.getPrimitiveObject(itemName);
                        /* 204 */
                        if ((value instanceof Integer)) {
                            /* 205 */
                            method.invoke(rsp, new Object[]{(Integer) value});

                        } else {
                            /* 207 */
                            if ((isCheckJsonType) && (value != null)) {
                                /* 208 */
                                throw new AlipayApiException(itemName + " is not a Number(Integer)");

                            }
                            /* 210 */
                            if (StringUtils.isNumeric(value))
                                /* 211 */
                                method.invoke(rsp, new Object[]{Integer.valueOf(value.toString())});

                        }

                    }
                    /* 214 */
                    else if (Boolean.class.isAssignableFrom(typeClass)) {
                        /* 215 */
                        Object value = reader.getPrimitiveObject(itemName);
                        /* 216 */
                        if ((value instanceof Boolean)) {
                            /* 217 */
                            method.invoke(rsp, new Object[]{(Boolean) value});

                        } else {
                            /* 219 */
                            if ((isCheckJsonType) && (value != null)) {
                                /* 220 */
                                throw new AlipayApiException(itemName + " is not a Boolean");

                            }
                            /* 222 */
                            if (value != null)
                                /* 223 */
                                method.invoke(rsp, new Object[]{Boolean.valueOf(value.toString())});

                        }

                    }
                    /* 226 */
                    else if (Double.class.isAssignableFrom(typeClass)) {
                        /* 227 */
                        Object value = reader.getPrimitiveObject(itemName);
                        /* 228 */
                        if ((value instanceof Double)) {
                            /* 229 */
                            method.invoke(rsp, new Object[]{(Double) value});

                        }
                        /* 231 */
                        else if ((isCheckJsonType) && (value != null)) {
                            /* 232 */
                            throw new AlipayApiException(itemName + " is not a Double");

                        }

                    }
                    /* 235 */
                    else if (Number.class.isAssignableFrom(typeClass)) {
                        /* 236 */
                        Object value = reader.getPrimitiveObject(itemName);
                        /* 237 */
                        if ((value instanceof Number)) {
                            /* 238 */
                            method.invoke(rsp, new Object[]{(Number) value});

                        }
                        /* 240 */
                        else if ((isCheckJsonType) && (value != null)) {
                            /* 241 */
                            throw new AlipayApiException(itemName + " is not a Number");

                        }

                    }
                    /* 244 */
                    else if (Date.class.isAssignableFrom(typeClass)) {
                        /* 245 */
                        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        /* 246 */
                        format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                        /* 247 */
                        Object value = reader.getPrimitiveObject(itemName);
                        /* 248 */
                        if ((value instanceof String))
                            /* 249 */
                            method.invoke(rsp, new Object[]{format.parse(value.toString())});

                    }
                    /* 251 */
                    else if (List.class.isAssignableFrom(typeClass)) {
                        /* 252 */
                        Type fieldType = field.getGenericType();
                        /* 253 */
                        if ((fieldType instanceof ParameterizedType)) {
                            /* 254 */
                            ParameterizedType paramType = (ParameterizedType) fieldType;
                            /* 255 */
                            Type[] genericTypes = paramType.getActualTypeArguments();
                            /* 256 */
                            if ((genericTypes != null) && (genericTypes.length > 0) &&
                                    /* 257 */                 ((genericTypes[0] instanceof Class))) {
                                /* 258 */
                                Class subType = (Class) genericTypes[0];
                                /* 259 */
                                List listObjs = reader.getListObjects(listName, itemName, subType);

                                /* 261 */
                                if (listObjs != null)
                                    /* 262 */
                                    method.invoke(rsp, new Object[]{listObjs});

                            }

                        }

                    } else {
                        /* 268 */
                        Object obj = reader.getObject(itemName, typeClass);
                        /* 269 */
                        if (obj != null)
                            /* 270 */
                            method.invoke(rsp, new Object[]{obj});

                    }

                }

            }

        } catch (Exception e) {
            /* 277 */
            throw new AlipayApiException(e);

        }

        /* 280 */
        return rsp;

    }


    private static Field tryGetFieldWithoutExp(Class<?> clazz, String itemName) {

        try {
            /* 296 */
            return clazz.getDeclaredField(itemName);

        } catch (Exception e) {

        }
        /* 299 */
        return null;

    }


    private static <T> Method tryGetSetMethod(Class<T> clazz, Field field, String methodName) {

        try {
            /* 313 */
            return clazz.getDeclaredMethod(methodName, new Class[]{field.getType()});

        } catch (Exception e) {

        }
        /* 316 */
        return null;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.mapping.Converters
 * JD-Core Version:    0.6.0
 */