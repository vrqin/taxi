/**
 * CallInfo.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */


package com.speedtalk.datas.xsd;


/**
 * CallInfo bean class
 */
@SuppressWarnings({"unchecked", "unused"})

public class CallInfo implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
                name = CallInfo
                Namespace URI = http://datas.speedtalk.com/xsd
                Namespace Prefix = ns4
                */


    /**
     * field for BeginTime
     */


    protected String localBeginTime;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localBeginTimeTracker = false;
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
     * field for EndTime
     */


    protected String localEndTime;
    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localEndTimeTracker = false;
    /**
     * field for GrpId
     */


    protected String localGrpId;
    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localGrpIdTracker = false;
    /**
     * field for MsId
     */


    protected String localMsId;
    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localMsIdTracker = false;
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

    public boolean isBeginTimeSpecified() {
        return localBeginTimeTracker;
    }

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public String getBeginTime() {
        return localBeginTime;
    }

    /**
     * Auto generated setter method
     *
     * @param param BeginTime
     */
    public void setBeginTime(String param) {
        localBeginTimeTracker = true;

        this.localBeginTime = param;


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

    public boolean isEndTimeSpecified() {
        return localEndTimeTracker;
    }

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public String getEndTime() {
        return localEndTime;
    }

    /**
     * Auto generated setter method
     *
     * @param param EndTime
     */
    public void setEndTime(String param) {
        localEndTimeTracker = true;

        this.localEndTime = param;


    }

    public boolean isGrpIdSpecified() {
        return localGrpIdTracker;
    }

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public String getGrpId() {
        return localGrpId;
    }

    /**
     * Auto generated setter method
     *
     * @param param GrpId
     */
    public void setGrpId(String param) {
        localGrpIdTracker = true;

        this.localGrpId = param;


    }

    public boolean isMsIdSpecified() {
        return localMsIdTracker;
    }

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public String getMsId() {
        return localMsId;
    }

    /**
     * Auto generated setter method
     *
     * @param param MsId
     */
    public void setMsId(String param) {
        localMsIdTracker = true;

        this.localMsId = param;


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
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":CallInfo", xmlWriter);
            } else {
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "CallInfo", xmlWriter);
            }


        }
        if (localBeginTimeTracker) {
            namespace = "http://datas.speedtalk.com/xsd";
            writeStartElement(null, namespace, "beginTime", xmlWriter);


            if (localBeginTime == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localBeginTime);

            }

            xmlWriter.writeEndElement();
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
        if (localEndTimeTracker) {
            namespace = "http://datas.speedtalk.com/xsd";
            writeStartElement(null, namespace, "endTime", xmlWriter);


            if (localEndTime == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localEndTime);

            }

            xmlWriter.writeEndElement();
        }
        if (localGrpIdTracker) {
            namespace = "http://datas.speedtalk.com/xsd";
            writeStartElement(null, namespace, "grpId", xmlWriter);


            if (localGrpId == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localGrpId);

            }

            xmlWriter.writeEndElement();
        }
        if (localMsIdTracker) {
            namespace = "http://datas.speedtalk.com/xsd";
            writeStartElement(null, namespace, "msId", xmlWriter);


            if (localMsId == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localMsId);

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

        if (localBeginTimeTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "beginTime"));

            elementList.add(localBeginTime == null ? null : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBeginTime));
        }
        if (localCallIdTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "callId"));

            elementList.add(localCallId == null ? null : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCallId));
        }
        if (localCallerTypeTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "callerType"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCallerType));
        }
        if (localEndTimeTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "endTime"));

            elementList.add(localEndTime == null ? null : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEndTime));
        }
        if (localGrpIdTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "grpId"));

            elementList.add(localGrpId == null ? null : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGrpId));
        }
        if (localMsIdTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "msId"));

            elementList.add(localMsId == null ? null : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMsId));
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
        public static CallInfo parse(javax.xml.stream.XMLStreamReader reader) throws Exception {
            CallInfo object = new CallInfo();

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

                        if (!"CallInfo".equals(type)) {
                            //find namespace for the prefix
                            String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                            return (CallInfo) com.speedtalk.services.ExtensionMapper.getTypeObject(nsUri, type, reader);
                        }


                    }


                }


                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();


                reader.next();


                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "beginTime")
                        .equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {


                        String content = reader.getElementText();

                        object.setBeginTime(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                    } else {


                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();

                }  // End of if for expected property start element

                else {

                }


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

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "endTime")
                        .equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {


                        String content = reader.getElementText();

                        object.setEndTime(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                    } else {


                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();

                }  // End of if for expected property start element

                else {

                }


                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "grpId").equals(reader
                        .getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {


                        String content = reader.getElementText();

                        object.setGrpId(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                    } else {


                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();

                }  // End of if for expected property start element

                else {

                }


                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "msId").equals(reader
                        .getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {


                        String content = reader.getElementText();

                        object.setMsId(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                    } else {


                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();

                }  // End of if for expected property start element

                else {

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
           
    