package com.alipay.api.internal.util;


import com.alipay.api.AlipayApiException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;


public final class XmlUtils {
    private static final String XMLNS_XSI = "xmlns:xsi";
    private static final String XSI_SCHEMA_LOCATION = "xsi:schemaLocation";
    private static final String LOGIC_YES = "yes";
    private static final String DEFAULT_ENCODE = "UTF-8";
    private static final String REG_INVALID_CHARS = "&#\\d+;";


    public static Document newDocument() throws AlipayApiException {
        /*  66 */
        Document doc = null;

        try {
            /*  69 */
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

        } catch (ParserConfigurationException e) {
            /*  71 */
            throw new AlipayApiException(e);

        }

        /*  74 */
        return doc;

    }


    public static Document getDocument(File file) throws AlipayApiException {
        /*  85 */
        InputStream in = getInputStream(file);
        /*  86 */
        return getDocument(in);

    }


    public static Document getDocument(InputStream in) throws AlipayApiException {
        /*  97 */
        Document doc = null;

        try {
            /* 100 */
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            /* 102 */
            doc = builder.parse(in);

        } catch (ParserConfigurationException e) {
            /* 104 */
            throw new AlipayApiException(e);

        } catch (SAXException e) {
            /* 106 */
            throw new AlipayApiException("XML_PARSE_ERROR", e);

        } catch (IOException e) {
            /* 108 */
            throw new AlipayApiException("XML_READ_ERROR", e);

        } finally {
            /* 110 */
            if (in != null) {

                try {
                    /* 112 */
                    in.close();

                } catch (IOException e) {

                }

            }

        }
        /* 119 */
        return doc;

    }


    public static Element createRootElement(String tagName) throws AlipayApiException {
        /* 130 */
        Document doc = newDocument();
        /* 131 */
        Element root = doc.createElement(tagName);
        /* 132 */
        doc.appendChild(root);
        /* 133 */
        return root;

    }


    public static Element getRootElementFromStream(InputStream in) throws AlipayApiException {
        /* 145 */
        return getDocument(in).getDocumentElement();

    }


    public static Element getRootElementFromFile(File file) throws AlipayApiException {
        /* 157 */
        return getDocument(file).getDocumentElement();

    }


    private static String getEncoding(String text) {
        /* 167 */
        String result = "UTF-8";

        /* 169 */
        String xml = text.trim();

        /* 171 */
        if (xml.startsWith("<?xml")) {
            /* 172 */
            int end = xml.indexOf("?>");
            /* 173 */
            String sub = xml.substring(0, end);
            /* 174 */
            StringTokenizer tokens = new StringTokenizer(sub, " =\"'");

            /* 176 */
            while (tokens.hasMoreTokens()) {
                /* 177 */
                String token = tokens.nextToken();

                /* 179 */
                if ("encoding".equals(token)) {
                    /* 180 */
                    if (!tokens.hasMoreTokens())
                        break;
                    /* 181 */
                    result = tokens.nextToken();
                    break;

                }


            }


        }

        /* 188 */
        return result;

    }


    public static Element getRootElementFromString(String payload) throws AlipayApiException {
        /* 200 */
        if ((payload == null) || (payload.trim().length() < 1)) {
            /* 201 */
            throw new AlipayApiException("XML_PAYLOAD_EMPTY");

        }

        /* 204 */
        byte[] bytes = null;

        try {
            /* 207 */
            payload = StringUtils.stripNonValidXMLCharacters(payload);
            /* 208 */
            String encodeString = getEncoding(payload);
            /* 209 */
            bytes = payload.getBytes(encodeString);

        } catch (UnsupportedEncodingException e) {
            /* 211 */
            throw new AlipayApiException("XML_ENCODE_ERROR", e);

        }

        /* 214 */
        InputStream in = new ByteArrayInputStream(bytes);
        /* 215 */
        return getDocument(in).getDocumentElement();

    }


    public static List<Element> getElements(Element parent, String tagName) {
        /* 226 */
        NodeList nodes = parent.getElementsByTagName(tagName);
        /* 227 */
        List elements = new ArrayList();

        /* 229 */
        for (int i = 0; i < nodes.getLength(); i++) {
            /* 230 */
            Node node = nodes.item(i);
            /* 231 */
            if ((node instanceof Element)) {
                /* 232 */
                elements.add((Element) node);

            }

        }

        /* 236 */
        return elements;

    }


    public static Element getElement(Element parent, String tagName) {
        /* 247 */
        List children = getElements(parent, tagName);

        /* 249 */
        if (children.isEmpty()) {
            /* 250 */
            return null;

        }
        /* 252 */
        return (Element) children.get(0);

    }


    public static List<Element> getChildElements(Element parent, String tagName) {
        /* 264 */
        NodeList nodes = parent.getElementsByTagName(tagName);
        /* 265 */
        List elements = new ArrayList();

        /* 267 */
        for (int i = 0; i < nodes.getLength(); i++) {
            /* 268 */
            Node node = nodes.item(i);
            /* 269 */
            if (((node instanceof Element)) && (node.getParentNode() == parent)) {
                /* 270 */
                elements.add((Element) node);

            }

        }

        /* 274 */
        return elements;

    }


    public static Element getChildElement(Element parent, String tagName) {
        /* 285 */
        List children = getChildElements(parent, tagName);

        /* 287 */
        if (children.isEmpty()) {
            /* 288 */
            return null;

        }
        /* 290 */
        return (Element) children.get(0);

    }


    public static String getElementValue(Element parent, String tagName) {
        /* 304 */
        Element element = getChildElement(parent, tagName);
        /* 305 */
        if (element != null) {
            /* 306 */
            NodeList nodes = element.getChildNodes();
            /* 307 */
            if ((nodes != null) && (nodes.getLength() > 0)) {
                /* 308 */
                for (int i = 0; i < nodes.getLength(); i++) {
                    /* 309 */
                    Node node = nodes.item(i);
                    /* 310 */
                    if ((node instanceof Text)) {
                        /* 311 */
                        return ((Text) node).getData();

                    }

                }

            }

        }

        /* 317 */
        return null;

    }


    public static String getElementValue(Element element) {
        /* 327 */
        if (element != null) {
            /* 328 */
            NodeList nodes = element.getChildNodes();
            /* 329 */
            if ((nodes != null) && (nodes.getLength() > 0)) {
                /* 330 */
                for (int i = 0; i < nodes.getLength(); i++) {
                    /* 331 */
                    Node node = nodes.item(i);
                    /* 332 */
                    if ((node instanceof Text)) {
                        /* 333 */
                        return ((Text) node).getData();

                    }

                }

            }

        }

        /* 339 */
        return null;

    }


    public static Element appendElement(Element parent, String tagName) {
        /* 350 */
        Element child = parent.getOwnerDocument().createElement(tagName);
        /* 351 */
        parent.appendChild(child);
        /* 352 */
        return child;

    }


    public static Element appendElement(Element parent, String tagName, String value) {
        /* 365 */
        Element child = appendElement(parent, tagName);
        /* 366 */
        child.appendChild(child.getOwnerDocument().createTextNode(value));
        /* 367 */
        return child;

    }


    public static void appendElement(Element parent, Element child) {
        /* 377 */
        Node tmp = parent.getOwnerDocument().importNode(child, true);
        /* 378 */
        parent.appendChild(tmp);

    }


    public static Element appendCDATAElement(Element parent, String tagName, String value) {
        /* 391 */
        Element child = appendElement(parent, tagName);
        /* 392 */
        if (value == null) {
            /* 393 */
            value = "";

        }

        /* 396 */
        Node cdata = child.getOwnerDocument().createCDATASection(value);
        /* 397 */
        child.appendChild(cdata);
        /* 398 */
        return child;

    }


    public static String childNodeToString(Node node) throws AlipayApiException {
        /* 409 */
        String payload = null;

        try {
            /* 412 */
            Transformer tf = TransformerFactory.newInstance().newTransformer();

            /* 414 */
            Properties props = tf.getOutputProperties();
            /* 415 */
            props.setProperty("omit-xml-declaration", "yes");
            /* 416 */
            tf.setOutputProperties(props);

            /* 418 */
            StringWriter writer = new StringWriter();
            /* 419 */
            tf.transform(new DOMSource(node), new StreamResult(writer));
            /* 420 */
            payload = writer.toString();
            /* 421 */
            payload = payload.replaceAll("&#\\d+;", " ");

        } catch (TransformerException e) {
            /* 423 */
            throw new AlipayApiException("XML_TRANSFORM_ERROR", e);

        }

        /* 426 */
        return payload;

    }


    public static String nodeToString(Node node) throws AlipayApiException {
        /* 437 */
        String payload = null;

        try {
            /* 440 */
            Transformer tf = TransformerFactory.newInstance().newTransformer();

            /* 442 */
            Properties props = tf.getOutputProperties();
            /* 443 */
            props.setProperty("indent", "yes");
            /* 444 */
            props.setProperty("encoding", "UTF-8");
            /* 445 */
            tf.setOutputProperties(props);

            /* 447 */
            StringWriter writer = new StringWriter();
            /* 448 */
            tf.transform(new DOMSource(node), new StreamResult(writer));
            /* 449 */
            payload = writer.toString();
            /* 450 */
            payload = payload.replaceAll("&#\\d+;", " ");

        } catch (TransformerException e) {
            /* 452 */
            throw new AlipayApiException("XML_TRANSFORM_ERROR", e);

        }

        /* 455 */
        return payload;

    }


    public static String xmlToString(File file) throws AlipayApiException {
        /* 466 */
        Element root = getRootElementFromFile(file);
        /* 467 */
        return nodeToString(root);

    }


    public static String xmlToString(InputStream in) throws AlipayApiException {
        /* 478 */
        Element root = getRootElementFromStream(in);
        /* 479 */
        return nodeToString(root);

    }


    public static void saveToXml(Node doc, File file) throws AlipayApiException {
        /* 490 */
        OutputStream out = null;

        try {
            /* 493 */
            Transformer tf = TransformerFactory.newInstance().newTransformer();

            /* 495 */
            Properties props = tf.getOutputProperties();
            /* 496 */
            props.setProperty("method", "xml");
            /* 497 */
            props.setProperty("indent", "yes");
            /* 498 */
            tf.setOutputProperties(props);

            /* 500 */
            DOMSource dom = new DOMSource(doc);
            /* 501 */
            out = getOutputStream(file);
            /* 502 */
            Result result = new StreamResult(out);
            /* 503 */
            tf.transform(dom, result);

        } catch (TransformerException e) {
            /* 505 */
            throw new AlipayApiException("XML_TRANSFORM_ERROR", e);

        } finally {
            /* 507 */
            if (out != null)

                try {
                    /* 509 */
                    out.close();

                } catch (IOException e) {

                }

        }

    }


    public static void validateXml(Node doc, File schemaFile) throws AlipayApiException {
        /* 526 */
        validateXml(doc, getInputStream(schemaFile));

    }


    public static void validateXml(Node doc, InputStream schemaStream) throws AlipayApiException {

        try {
            /* 539 */
            Source source = new StreamSource(schemaStream);
            /* 540 */
            Schema schema = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema").newSchema(source);

            /* 543 */
            Validator validator = schema.newValidator();
            /* 544 */
            validator.validate(new DOMSource(doc));

        } catch (SAXException e) {
            /* 546 */
            throw new AlipayApiException("XML_VALIDATE_ERROR", e);

        } catch (IOException e) {
            /* 548 */
            throw new AlipayApiException("XML_READ_ERROR", e);

        } finally {
            /* 550 */
            if (schemaStream != null)

                try {
                    /* 552 */
                    schemaStream.close();

                } catch (IOException e) {

                }

        }

    }


    public static String xmlToHtml(String payload, File xsltFile) throws AlipayApiException {
        /* 570 */
        String result = null;

        try {
            /* 573 */
            Source template = new StreamSource(xsltFile);
            /* 574 */
            Transformer transformer = TransformerFactory.newInstance().newTransformer(template);

            /* 577 */
            Properties props = transformer.getOutputProperties();
            /* 578 */
            props.setProperty("omit-xml-declaration", "yes");
            /* 579 */
            transformer.setOutputProperties(props);

            /* 581 */
            StreamSource source = new StreamSource(new StringReader(payload));
            /* 582 */
            StreamResult sr = new StreamResult(new StringWriter());
            /* 583 */
            transformer.transform(source, sr);

            /* 585 */
            result = sr.getWriter().toString();

        } catch (TransformerException e) {
            /* 587 */
            throw new AlipayApiException("XML_TRANSFORM_ERROR", e);

        }

        /* 590 */
        return result;

    }


    public static void setNamespace(Element element, String namespace, String schemaLocation) {
        /* 602 */
        element.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", namespace);

        /* 604 */
        element.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");

        /* 606 */
        element.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "xsi:schemaLocation", schemaLocation);

    }


    public static String encodeXml(String payload) throws AlipayApiException {
        /* 618 */
        Element root = createRootElement("xml");
        /* 619 */
        root.appendChild(root.getOwnerDocument().createTextNode(payload));
        /* 620 */
        return childNodeToString(root.getFirstChild());

    }


    private static InputStream getInputStream(File file) throws AlipayApiException {
        /* 624 */
        InputStream in = null;

        try {
            /* 627 */
            in = new FileInputStream(file);

        } catch (FileNotFoundException e) {
            /* 629 */
            throw new AlipayApiException("FILE_NOT_FOUND", e);

        }

        /* 632 */
        return in;

    }


    private static OutputStream getOutputStream(File file) throws AlipayApiException {
        /* 636 */
        OutputStream in = null;

        try {
            /* 639 */
            in = new FileOutputStream(file);

        } catch (FileNotFoundException e) {
            /* 641 */
            throw new AlipayApiException("FILE_NOT_FOUND", e);

        }

        /* 644 */
        return in;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.XmlUtils
 * JD-Core Version:    0.6.0
 */