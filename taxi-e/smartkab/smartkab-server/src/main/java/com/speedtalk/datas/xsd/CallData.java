/**
 * CallData.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */


package com.speedtalk.datas.xsd;


/**
 * CallData bean class
 */
@SuppressWarnings({"unchecked", "unused"})

public class CallData implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
                name = CallData
                Namespace URI = http://datas.speedtalk.com/xsd
                Namespace Prefix = ns4
                */


    /**
     * field for CallId
     */


    protected String localCallId;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localCallIdTracker = false;
    /**
     * field for CallerType
     */


    protected int localCallerType;
    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localCallerTypeTracker = false;
    /**
     * field for Datas
     */


    protected javax.activation.DataHandler localDatas;
    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localDatasTracker = false;
    /**
     * field for PackLen
     */


    protected short localPackLen;
    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localPackLenTracker = false;
    /**
     * field for Result
     */


    protected Result localResult;
    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localResultTracker = false;

    private static String generatePrefix(String namespace) {
        if (namespace.equals("http://datas.speedtalk.com/xsd")) {
            return "ns4";
        }
        return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    public boolean isCallIdSpecified() {
        return localCallIdTracker;
    }

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public String getCallId() {
        return localCallId;
    }

    /**
     * Auto generated setter method
     *
     * @param param CallId
     */
    public void setCallId(String param) {
        localCallIdTracker = true;

        this.localCallId = param;


    }

    public boolean isCallerTypeSpecified() {
        return localCallerTypeTracker;
    }

    /**
     * Auto generated getter method
     *
     * @return int
     */
    public int getCallerType() {
        return localCallerType;
    }

    /**
     * Auto generated setter method
     *
     * @param param CallerType
     */
    public void setCallerType(int param) {

        // setting primitive attribute tracker to true
        localCallerTypeTracker = param != Integer.MIN_VALUE;

        this.localCallerType = param;


    }

    public boolean isDatasSpecified() {
        return localDatasTracker;
    }

    /**
     * Auto generated getter method
     *
     * @return javax.activation.DataHandler
     */
    public javax.activation.DataHandler getDatas() {
        return localDatas;
    }

    /**
     * Auto generated setter method
     *
     * @param param Datas
     */
    public void setDatas(javax.activation.DataHandler param) {
        localDatasTracker = true;

        this.localDatas = param;


    }

    public boolean isPackLenSpecified() {
        return localPackLenTracker;
    }

    /**
     * Auto generated getter method
     *
     * @return short
     */
    public short getPackLen() {
        return localPackLen;
    }

    /**
     * Auto generated setter method
     *
     * @param param PackLen
     */
    public void setPackLen(short param) {

        // setting primitive attribute tracker to true
        localPackLenTracker = param != Short.MIN_VALUE;

        this.localPackLen = param;


    }

    public boolean isResultSpecified() {
        return localResultTracker;
    }

    /**
     * Auto generated getter method
     *
     * @return com.speedtalk.datas.xsd.Result
     */
    public Result getResult() {
        return localResult;
    }

    /**
     * Auto generated setter method
     *
     * @param param Result
     */
    public void setResult(Result param) {
        localResultTracker = true;

        this.localResult = param;


    }

    /**
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
            throws org.apache.axis2.databinding.ADBException {


        org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
        return factory.createOMElement(dataSource, parentQName);

    }

    public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
        serialize(parentQName, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


        String prefix = null;
        String namespace = null;


        prefix = parentQName.getPrefix();
        namespace = parentQName.getNamespaceURI();
        writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

        if (serializeType) {


            String namespacePrefix = registerPrefix(xmlWriter, "http://datas.speedtalk.com/xsd");
            if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":CallData", xmlWriter);
            } else {
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "CallData", xmlWriter);
            }


        }
        if (localCallIdTracker) {
            namespace = "http://datas.speedtalk.com/xsd";
            writeStartElement(null, namespace, "callId", xmlWriter);


            if (localCallId == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localCallId);

            }

            xmlWriter.writeEndElement();
        }
        if (localCallerTypeTracker) {
            namespace = "http://datas.speedtalk.com/xsd";
            writeStartElement(null, namespace, "callerType", xmlWriter);

            if (localCallerType == Integer.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException("callerType cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCallerType));
            }

            xmlWriter.writeEndElement();
        }
        if (localDatasTracker) {
            namespace = "http://datas.speedtalk.com/xsd";
            writeStartElement(null, namespace, "datas", xmlWriter);


            if (localDatas != null) {
                try {
                    org.apache.axiom.util.stax.XMLStreamWriterUtils.writeDataHandler(xmlWriter, localDatas, null, true);
                } catch (java.io.IOException ex) {
                    throw new javax.xml.stream.XMLStreamException("Unable to read data handler for datas", ex);
                }
            } else {

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            }

            xmlWriter.writeEndElement();
        }
        if (localPackLenTracker) {
            namespace = "http://datas.speedtalk.com/xsd";
            writeStartElement(null, namespace, "packLen", xmlWriter);

            if (localPackLen == Short.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException("packLen cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPackLen));
            }

            xmlWriter.writeEndElement();
        }
        if (localResultTracker) {
            if (localResult == null) {

                writeStartElement(null, "http://datas.speedtalk.com/xsd", "result", xmlWriter);

                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                xmlWriter.writeEndElement();
            } else {
                localResult.serialize(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "result"), xmlWriter);
            }
        }
        xmlWriter.writeEndElement();


    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(String prefix, String namespace, String localPart, javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
        String writerPrefix = xmlWriter.getPrefix(namespace);
        if (writerPrefix != null) {
            xmlWriter.writeStartElement(namespace, localPart);
        } else {
            if (namespace.length() == 0) {
                prefix = "";
            } else if (prefix == null) {
                prefix = generatePrefix(namespace);
            }

            xmlWriter.writeStartElement(prefix, localPart, namespace);
            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
        }
    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(String prefix, String namespace, String attName, String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
        if (xmlWriter.getPrefix(namespace) == null) {
            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
        }
        xmlWriter.writeAttribute(namespace, attName, attValue);
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(String namespace, String attName, String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
        if (namespace.equals("")) {
            xmlWriter.writeAttribute(attName, attValue);
        } else {
            registerPrefix(xmlWriter, namespace);
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }
    }


    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeQNameAttribute(String namespace, String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {

        String attributeNamespace = qname.getNamespaceURI();
        String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
        if (attributePrefix == null) {
            attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
        }
        String attributeValue;
        if (attributePrefix.trim().length() > 0) {
            attributeValue = attributePrefix + ":" + qname.getLocalPart();
        } else {
            attributeValue = qname.getLocalPart();
        }

        if (namespace.equals("")) {
            xmlWriter.writeAttribute(attName, attributeValue);
        } else {
            registerPrefix(xmlWriter, namespace);
            xmlWriter.writeAttribute(namespace, attName, attributeValue);
        }
    }

    /**
     * method to handle Qnames
     */

    private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
        String namespaceURI = qname.getNamespaceURI();
        if (namespaceURI != null) {
            String prefix = xmlWriter.getPrefix(namespaceURI);
            if (prefix == null) {
                prefix = generatePrefix(namespaceURI);
                xmlWriter.writeNamespace(prefix, namespaceURI);
                xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
                xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            } else {
                // i.e this is the default namespace
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }

        } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {

        if (qnames != null) {
            // we have to store this data until last moment since it is not possible to write any
            // namespace data after writing the charactor data
            StringBuilder stringToWrite = new StringBuilder();
            String namespaceURI = null;
            String prefix = null;

            for (int i = 0; i < qnames.length; i++) {
                if (i > 0) {
                    stringToWrite.append(" ");
                }
                namespaceURI = qnames[i].getNamespaceURI();
                if (namespaceURI != null) {
                    prefix = xmlWriter.getPrefix(namespaceURI);
                    if ((prefix == null) || (prefix.length() == 0)) {
                        prefix = generatePrefix(namespaceURI);
                        xmlWriter.writeNamespace(prefix, namespaceURI);
                        xmlWriter.setPrefix(prefix, namespaceURI);
                    }

                    if (prefix.trim().length() > 0) {
                        stringToWrite.append(prefix)
                                .append(":")
                                .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                } else {
                    stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                }
            }
            xmlWriter.writeCharacters(stringToWrite.toString());
        }

    }


    /**
     * Register a namespace prefix
     */
    private String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, String namespace)
            throws javax.xml.stream.XMLStreamException {
        String prefix = xmlWriter.getPrefix(namespace);
        if (prefix == null) {
            prefix = generatePrefix(namespace);
            javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
            while (true) {
                String uri = nsContext.getNamespaceURI(prefix);
                if (uri == null || uri.length() == 0) {
                    break;
                }
                prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
            }
            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
        }
        return prefix;
    }


    /**
     * databinding method to get an XML representation of this object
     */
    public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
            throws org.apache.axis2.databinding.ADBException {


        java.util.ArrayList elementList = new java.util.ArrayList();
        java.util.ArrayList attribList = new java.util.ArrayList();

        if (localCallIdTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "callId"));

            elementList.add(localCallId == null ? null : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCallId));
        }
        if (localCallerTypeTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "callerType"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCallerType));
        }
        if (localDatasTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "datas"));

            elementList.add(localDatas);
        }
        if (localPackLenTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "packLen"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPackLen));
        }
        if (localResultTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "result"));


            elementList.add(localResult == null ? null : localResult);
        }

        return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList
                .toArray());


    }


    /**
     * Factory class that keeps the parse method
     */
    public static class Factory {


        /**
         * static method to create the object
         * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
         * If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
         * Postcondition: If this object is an element, the reader is positioned at its end element
         * If this object is a complex type, the reader is positioned at the end element of its outer element
         */
        public static CallData parse(javax.xml.stream.XMLStreamReader reader) throws Exception {
            CallData object = new CallData();

            int event;
            String nillableValue = null;
            String prefix = "";
            String namespaceuri = "";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                    String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
                    if (fullTypeName != null) {
                        String nsPrefix = null;
                        if (fullTypeName.indexOf(":") > -1) {
                            nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                        }
                        nsPrefix = nsPrefix == null ? "" : nsPrefix;

                        String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                        if (!"CallData".equals(type)) {
                            //find namespace for the prefix
                            String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                            return (CallData) com.speedtalk.services.ExtensionMapper.getTypeObject(nsUri, type, reader);
                        }


                    }


                }


                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();


                reader.next();


                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "callId")
                        .equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {


                        String content = reader.getElementText();

                        object.setCallId(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                    } else {


                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();

                }  // End of if for expected property start element

                else {

                }


                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "callerType")
                        .equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException("The element: " + "callerType" + "  cannot be null");
                    }


                    String content = reader.getElementText();

                    object.setCallerType(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                    reader.next();

                }  // End of if for expected property start element

                else {

                    object.setCallerType(Integer.MIN_VALUE);

                }


                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "datas").equals(reader
                        .getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        object.setDatas(null);
                        reader.next();
                    } else {

                        object.setDatas(org.apache.axiom.util.stax.XMLStreamReaderUtils.getDataHandlerFromElement(reader));

                    }

                    reader.next();

                }  // End of if for expected property start element

                else {

                }


                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "packLen")
                        .equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException("The element: " + "packLen" + "  cannot be null");
                    }


                    String content = reader.getElementText();

                    object.setPackLen(org.apache.axis2.databinding.utils.ConverterUtil.convertToShort(content));

                    reader.next();

                }  // End of if for expected property start element

                else {

                    object.setPackLen(Short.MIN_VALUE);

                }


                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "result")
                        .equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        object.setResult(null);
                        reader.next();

                        reader.next();

                    } else {

                        object.setResult(Result.Factory.parse(reader));

                        reader.next();
                    }
                }  // End of if for expected property start element

                else {

                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement())
                    // A start element we are not expecting indicates a trailing invalid property
                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());


            } catch (javax.xml.stream.XMLStreamException e) {
                throw new Exception(e);
            }

            return object;
        }

    }//end of factory class


}
           
    