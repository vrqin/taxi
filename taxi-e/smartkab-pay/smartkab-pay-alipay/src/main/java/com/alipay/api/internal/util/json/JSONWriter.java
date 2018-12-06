package com.alipay.api.internal.util.json;


import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.util.AlipayLogger;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.CharacterIterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.*;
import java.util.Map.Entry;


public class JSONWriter {
    /* 299 */   static char[] hex = "0123456789ABCDEF".toCharArray();
    /*  28 */   private StringBuilder buf = new StringBuilder();
    /*  29 */   private Stack<Object> calls = new Stack();
    /*  30 */   private boolean emitClassName = true;
    private DateFormat format;


    public JSONWriter(boolean emitClassName) {
        /*  34 */
        this.emitClassName = emitClassName;

    }


    public JSONWriter() {
        /*  38 */
        this(false);

    }


    public JSONWriter(DateFormat format) {
        /*  42 */
        this(false);
        /*  43 */
        this.format = format;

    }


    public String write(Object object) {
        /*  47 */
        return write(object, false);

    }


    public String write(Object object, boolean isApiModel) {
        /*  51 */
        this.buf.setLength(0);
        /*  52 */
        value(object, isApiModel);
        /*  53 */
        return this.buf.toString();

    }


    public String write(long n) {
        /*  57 */
        return String.valueOf(n);

    }


    public String write(double d) {
        /*  61 */
        return String.valueOf(d);

    }


    public String write(char c) {
        /*  65 */
        return "\"" + c + "\"";

    }


    public String write(boolean b) {
        /*  69 */
        return String.valueOf(b);

    }


    private void value(Object object) {
        /*  73 */
        value(object, false);

    }


    private void value(Object object, boolean isApiModel) {
        /*  77 */
        if ((object == null) || (cyclic(object))) {
            /*  78 */
            add(null);

        } else {
            /*  80 */
            this.calls.push(object);
            /*  81 */
            if ((object instanceof Class))
                /*  82 */
                string(object);
                /*  83 */
            else if ((object instanceof Boolean))
                /*  84 */
                bool(((Boolean) object).booleanValue());
                /*  85 */
            else if ((object instanceof Number))
                /*  86 */
                add(object);
                /*  87 */
            else if ((object instanceof String))
                /*  88 */
                string(object);
                /*  89 */
            else if ((object instanceof Character))
                /*  90 */
                string(object);
                /*  91 */
            else if ((object instanceof Map))
                /*  92 */
                map((Map) object);
                /*  93 */
            else if (object.getClass().isArray())
                /*  94 */
                array(object);
                /*  95 */
            else if ((object instanceof Iterator))
                /*  96 */
                array((Iterator) object);
                /*  97 */
            else if ((object instanceof Collection))
                /*  98 */
                array(((Collection) object).iterator());
                /*  99 */
            else if ((object instanceof Date)) {
                /* 100 */
                date((Date) object);

            }
            /* 102 */
            else if (isApiModel)
                /* 103 */
                model(object);

            else {
                /* 105 */
                bean(object);

            }
            /* 107 */
            this.calls.pop();

        }

    }


    private boolean cyclic(Object object) {
        /* 112 */
        Iterator it = this.calls.iterator();
        /* 113 */
        while (it.hasNext()) {
            /* 114 */
            Object called = it.next();
            /* 115 */
            if (object == called)
                /* 116 */
                return true;

        }
        /* 118 */
        return false;

    }


    private void bean(Object object) {
        /* 122 */
        add("{");

        /* 124 */
        boolean addedSomething = false;

        try {
            /* 126 */
            BeanInfo info = Introspector.getBeanInfo(object.getClass());
            /* 127 */
            PropertyDescriptor[] props = info.getPropertyDescriptors();
            /* 128 */
            for (int i = 0; i < props.length; i++) {
                /* 129 */
                PropertyDescriptor prop = props[i];
                /* 130 */
                String name = prop.getName();
                /* 131 */
                Method accessor = prop.getReadMethod();
                /* 132 */
                if (((this.emitClassName) || (!"class".equals(name))) && (accessor != null)) {
                    /* 133 */
                    if (!accessor.isAccessible())
                        /* 134 */
                        accessor.setAccessible(true);
                    /* 135 */
                    Object value = accessor.invoke(object, (Object[]) null);
                    /* 136 */
                    if (value == null)

                        continue;
                    /* 138 */
                    if (addedSomething)
                        /* 139 */
                        add(',');
                    /* 140 */
                    add(name, value);
                    /* 141 */
                    addedSomething = true;

                }

            }
            /* 144 */
            Field[] ff = object.getClass().getFields();
            /* 145 */
            for (int i = 0; i < ff.length; i++) {
                /* 146 */
                Field field = ff[i];
                /* 147 */
                Object value = field.get(object);
                /* 148 */
                if (value == null)

                    continue;
                /* 150 */
                if (addedSomething)
                    /* 151 */
                    add(',');
                /* 152 */
                add(field.getName(), value);
                /* 153 */
                addedSomething = true;

            }

        } catch (IllegalAccessException iae) {
            /* 156 */
            iae.printStackTrace();

        } catch (InvocationTargetException ite) {
            /* 158 */
            ite.getCause().printStackTrace();
            /* 159 */
            ite.printStackTrace();

        } catch (IntrospectionException ie) {
            /* 161 */
            ie.printStackTrace();

        }
        /* 163 */
        add("}");

    }


    private void model(Object object) {
        /* 167 */
        add("{");
        /* 168 */
        boolean addedSomething = false;
        /* 169 */
        Field[] ff = object.getClass().getDeclaredFields();

        try {
            /* 171 */
            for (int i = 0; i < ff.length; i++) {
                /* 172 */
                Field field = ff[i];

                /* 174 */
                ApiField jsonField = (ApiField) field.getAnnotation(ApiField.class);
                /* 175 */
                if (jsonField != null) {
                    /* 176 */
                    PropertyDescriptor pd = new PropertyDescriptor(field.getName(), object.getClass());

                    /* 178 */
                    Method accessor = pd.getReadMethod();
                    /* 179 */
                    if (!accessor.isAccessible())
                        /* 180 */
                        accessor.setAccessible(true);
                    /* 181 */
                    Object value = accessor.invoke(object, (Object[]) null);
                    /* 182 */
                    if (value == null)

                        continue;
                    /* 184 */
                    if (addedSomething)
                        /* 185 */
                        add(',');
                    /* 186 */
                    add(jsonField.value(), value, true);
                    /* 187 */
                    addedSomething = true;

                }

            }

        } catch (IntrospectionException e1) {
            /* 191 */
            AlipayLogger.logBizError(e1);

        } catch (IllegalAccessException e2) {
            /* 193 */
            AlipayLogger.logBizError(e2);

        } catch (IllegalArgumentException e3) {
            /* 195 */
            AlipayLogger.logBizError(e3);

        } catch (InvocationTargetException e4) {
            /* 197 */
            AlipayLogger.logBizError(e4);

        }
        /* 199 */
        add("}");

    }


    private void add(String name, Object value) {
        /* 203 */
        add(name, value, false);

    }


    private void add(String name, Object value, boolean isApiModel) {
        /* 207 */
        add('"');
        /* 208 */
        add(name);
        /* 209 */
        add("\":");
        /* 210 */
        value(value, isApiModel);

    }


    private void map(Map<?, ?> map) {
        /* 214 */
        add("{");
        /* 215 */
        Iterator it = map.entrySet().iterator();
        /* 216 */
        while (it.hasNext()) {
            /* 217 */
            Entry e = (Entry) it.next();
            /* 218 */
            value(e.getKey());
            /* 219 */
            add(":");
            /* 220 */
            value(e.getValue());
            /* 221 */
            if (it.hasNext())
                /* 222 */
                add(',');

        }
        /* 224 */
        add("}");

    }


    private void array(Iterator<?> it) {
        /* 228 */
        add("[");
        /* 229 */
        while (it.hasNext()) {
            /* 230 */
            value(it.next());
            /* 231 */
            if (it.hasNext())
                /* 232 */
                add(",");

        }
        /* 234 */
        add("]");

    }


    private void array(Object object) {
        /* 238 */
        add("[");
        /* 239 */
        int length = Array.getLength(object);
        /* 240 */
        for (int i = 0; i < length; i++) {
            /* 241 */
            value(Array.get(object, i));
            /* 242 */
            if (i < length - 1)
                /* 243 */
                add(',');

        }
        /* 245 */
        add("]");

    }


    private void bool(boolean b) {
        /* 249 */
        add(b ? "true" : "false");

    }


    private void date(Date date) {
        /* 253 */
        if (this.format == null) {
            /* 254 */
            this.format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            /* 255 */
            this.format.setTimeZone(TimeZone.getTimeZone("GMT+8"));

        }
        /* 257 */
        add("\"");
        /* 258 */
        add(this.format.format(date));
        /* 259 */
        add("\"");

    }


    private void string(Object obj) {
        /* 263 */
        add('"');
        /* 264 */
        CharacterIterator it = new StringCharacterIterator(obj.toString());
        /* 265 */
        for (char c = it.first(); c != 65535; c = it.next()) {
            /* 266 */
            if (c == '"')
                /* 267 */
                add("\\\"");
                /* 268 */
            else if (c == '\\')
                /* 269 */
                add("\\\\");
                /* 270 */
            else if (c == '/')
                /* 271 */
                add("\\/");
                /* 272 */
            else if (c == '\b')
                /* 273 */
                add("\\b");
                /* 274 */
            else if (c == '\f')
                /* 275 */
                add("\\f");
                /* 276 */
            else if (c == '\n')
                /* 277 */
                add("\\n");
                /* 278 */
            else if (c == '\r')
                /* 279 */
                add("\\r");
                /* 280 */
            else if (c == '\t')
                /* 281 */
                add("\\t");
                /* 282 */
            else if (Character.isISOControl(c))
                /* 283 */
                unicode(c);

            else {
                /* 285 */
                add(c);

            }

        }
        /* 288 */
        add('"');

    }


    private void add(Object obj) {
        /* 292 */
        this.buf.append(obj);

    }


    private void add(char c) {
        /* 296 */
        this.buf.append(c);

    }


    private void unicode(char c) {
        /* 302 */
        add("\\u");
        /* 303 */
        int n = c;
        /* 304 */
        for (int i = 0; i < 4; i++) {
            /* 305 */
            int digit = (n & 0xF000) >> 12;
            /* 306 */
            add(hex[digit]);
            /* 307 */
            n <<= 4;

        }

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.json.JSONWriter
 * JD-Core Version:    0.6.0
 */