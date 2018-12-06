package com.speedtalk.utils;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

public class XmlParse {
    /* 14 */   private static DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    /* 15 */   private static DocumentBuilder db = null;
    /* 16 */   private static Document doc = null;

    public static Document getXmlConfigDoc(String filename) {
        try {
            /* 25 */
            db = dbf.newDocumentBuilder();
            /* 26 */
            doc = db.parse(new File(filename));
            /* 27 */
            return doc;
        } catch (Exception e) {
            /* 31 */
            com.speedtalk.utils.ExcepPrinter.print(e);
        }
        /* 33 */
        return null;
    }

    public static Document getXmlFromString(String xml) {
        try {
            /* 41 */
            db = dbf.newDocumentBuilder();
            /* 42 */
            byte[] buf = xml.getBytes();
            /* 43 */
            InputStream in = new ByteArrayInputStream(buf);
            /* 44 */
            doc = db.parse(in);
            /* 45 */
            return doc;
        } catch (Exception e) {
            /* 49 */
            com.speedtalk.utils.ExcepPrinter.print(e);
            /* 50 */
        }
        return null;
    }

    public static String getElementByTagName(String tagName) {
        /* 57 */
        return doc.getElementsByTagName(tagName).item(0).getFirstChild()
                /* 58 */.getNodeValue();
    }
}

