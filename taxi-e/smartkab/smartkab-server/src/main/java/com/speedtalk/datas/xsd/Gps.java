/**
 * Gps.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */


package com.speedtalk.datas.xsd;


/**
 * Gps bean class
 */
@SuppressWarnings({"unchecked", "unused"})

public class Gps implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
                name = Gps
                Namespace URI = http://datas.speedtalk.com/xsd
                Namespace Prefix = ns4
                */


    /**
     * field for Alarm
     */


    protected int localAlarm;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localAlarmTracker = false;
    /**
     * field for Direction
     */


    protected short localDirection;
    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localDirectionTracker = false;
    /**
     * field for Elevation
     */


    protected short localElevation;
    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localElevationTracker = false;
    /**
     * field for GpsTime
     */


    protected String localGpsTime;
    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localGpsTimeTracker = false;
    /**
     * field for Len
     */


    protected int localLen;
    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localLenTracker = false;
    /**
     * field for Lg
     */


    protected int localLg;
    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localLgTracker = false;
    /**
     * field for Lt
     */


    protected int localLt;
    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localLtTracker = false;
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
     * field for Oil
     */


    protected short localOil;
    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localOilTracker = false;
    /**
     * field for Result
     */


    protected com.speedtalk.datas.xsd.Result localResult;
    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localResultTracker = false;
    /**
     * field for Speed
     */


    protected short localSpeed;
    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localSpeedTracker = false;
    /**
     * field for Status
     */


    protected int localStatus;
    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localStatusTracker = false;
    /**
     * field for TotalMile
     */


    protected int localTotalMile;
    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localTotalMileTracker = false;

    private static String generatePrefix(String namespace) {
        if (namespace.equals("http://datas.speedtalk.com/xsd")) {
            return "ns4";
        }
        return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    public boolean isAlarmSpecified() {
        return localAlarmTracker;
    }

    /**
     * Auto generated getter method
     *
     * @return int
     */
    public int getAlarm() {
        return localAlarm;
    }

    /**
     * Auto generated setter method
     *
     * @param param Alarm
     */
    public void setAlarm(int param) {

        // setting primitive attribute tracker to true
        localAlarmTracker = param != Integer.MIN_VALUE;

        this.localAlarm = param;


    }

    public boolean isDirectionSpecified() {
        return localDirectionTracker;
    }

    /**
     * Auto generated getter method
     *
     * @return short
     */
    public short getDirection() {
        return localDirection;
    }

    /**
     * Auto generated setter method
     *
     * @param param Direction
     */
    public void setDirection(short param) {

        // setting primitive attribute tracker to true
        localDirectionTracker = param != Short.MIN_VALUE;

        this.localDirection = param;


    }

    public boolean isElevationSpecified() {
        return localElevationTracker;
    }

    /**
     * Auto generated getter method
     *
     * @return short
     */
    public short getElevation() {
        return localElevation;
    }

    /**
     * Auto generated setter method
     *
     * @param param Elevation
     */
    public void setElevation(short param) {

        // setting primitive attribute tracker to true
        localElevationTracker = param != Short.MIN_VALUE;

        this.localElevation = param;


    }

    public boolean isGpsTimeSpecified() {
        return localGpsTimeTracker;
    }

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public String getGpsTime() {
        return localGpsTime;
    }

    /**
     * Auto generated setter method
     *
     * @param param GpsTime
     */
    public void setGpsTime(String param) {
        localGpsTimeTracker = true;

        this.localGpsTime = param;


    }

    public boolean isLenSpecified() {
        return localLenTracker;
    }

    /**
     * Auto generated getter method
     *
     * @return int
     */
    public int getLen() {
        return localLen;
    }

    /**
     * Auto generated setter method
     *
     * @param param Len
     */
    public void setLen(int param) {

        // setting primitive attribute tracker to true
        localLenTracker = param != Integer.MIN_VALUE;

        this.localLen = param;


    }

    public boolean isLgSpecified() {
        return localLgTracker;
    }

    /**
     * Auto generated getter method
     *
     * @return int
     */
    public int getLg() {
        return localLg;
    }

    /**
     * Auto generated setter method
     *
     * @param param Lg
     */
    public void setLg(int param) {

        // setting primitive attribute tracker to true
        localLgTracker = param != Integer.MIN_VALUE;

        this.localLg = param;


    }

    public boolean isLtSpecified() {
        return localLtTracker;
    }

    /**
     * Auto generated getter method
     *
     * @return int
     */
    public int getLt() {
        return localLt;
    }

    /**
     * Auto generated setter method
     *
     * @param param Lt
     */
    public void setLt(int param) {

        // setting primitive attribute tracker to true
        localLtTracker = param != Integer.MIN_VALUE;

        this.localLt = param;


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

    public boolean isOilSpecified() {
        return localOilTracker;
    }

    /**
     * Auto generated getter method
     *
     * @return short
     */
    public short getOil() {
        return localOil;
    }

    /**
     * Auto generated setter method
     *
     * @param param Oil
     */
    public void setOil(short param) {

        // setting primitive attribute tracker to true
        localOilTracker = param != Short.MIN_VALUE;

        this.localOil = param;


    }

    public boolean isResultSpecified() {
        return localResultTracker;
    }

    /**
     * Auto generated getter method
     *
     * @return com.speedtalk.datas.xsd.Result
     */
    public com.speedtalk.datas.xsd.Result getResult() {
        return localResult;
    }

    /**
     * Auto generated setter method
     *
     * @param param Result
     */
    public void setResult(com.speedtalk.datas.xsd.Result param) {
        localResultTracker = true;

        this.localResult = param;


    }

    public boolean isSpeedSpecified() {
        return localSpeedTracker;
    }

    /**
     * Auto generated getter method
     *
     * @return short
     */
    public short getSpeed() {
        return localSpeed;
    }

    /**
     * Auto generated setter method
     *
     * @param param Speed
     */
    public void setSpeed(short param) {

        // setting primitive attribute tracker to true
        localSpeedTracker = param != Short.MIN_VALUE;

        this.localSpeed = param;


    }

    public boolean isStatusSpecified() {
        return localStatusTracker;
    }

    /**
     * Auto generated getter method
     *
     * @return int
     */
    public int getStatus() {
        return localStatus;
    }

    /**
     * Auto generated setter method
     *
     * @param param Status
     */
    public void setStatus(int param) {

        // setting primitive attribute tracker to true
        localStatusTracker = param != Integer.MIN_VALUE;

        this.localStatus = param;


    }

    public boolean isTotalMileSpecified() {
        return localTotalMileTracker;
    }

    /**
     * Auto generated getter method
     *
     * @return int
     */
    public int getTotalMile() {
        return localTotalMile;
    }

    /**
     * Auto generated setter method
     *
     * @param param TotalMile
     */
    public void setTotalMile(int param) {

        // setting primitive attribute tracker to true
        localTotalMileTracker = param != Integer.MIN_VALUE;

        this.localTotalMile = param;


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
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":Gps", xmlWriter);
            } else {
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "Gps", xmlWriter);
            }


        }
        if (localAlarmTracker) {
            namespace = "http://datas.speedtalk.com/xsd";
            writeStartElement(null, namespace, "alarm", xmlWriter);

            if (localAlarm == Integer.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException("alarm cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAlarm));
            }

            xmlWriter.writeEndElement();
        }
        if (localDirectionTracker) {
            namespace = "http://datas.speedtalk.com/xsd";
            writeStartElement(null, namespace, "direction", xmlWriter);

            if (localDirection == Short.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException("direction cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDirection));
            }

            xmlWriter.writeEndElement();
        }
        if (localElevationTracker) {
            namespace = "http://datas.speedtalk.com/xsd";
            writeStartElement(null, namespace, "elevation", xmlWriter);

            if (localElevation == Short.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException("elevation cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localElevation));
            }

            xmlWriter.writeEndElement();
        }
        if (localGpsTimeTracker) {
            namespace = "http://datas.speedtalk.com/xsd";
            writeStartElement(null, namespace, "gpsTime", xmlWriter);


            if (localGpsTime == null) {
                // write the nil attribute

                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

            } else {


                xmlWriter.writeCharacters(localGpsTime);

            }

            xmlWriter.writeEndElement();
        }
        if (localLenTracker) {
            namespace = "http://datas.speedtalk.com/xsd";
            writeStartElement(null, namespace, "len", xmlWriter);

            if (localLen == Integer.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException("len cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLen));
            }

            xmlWriter.writeEndElement();
        }
        if (localLgTracker) {
            namespace = "http://datas.speedtalk.com/xsd";
            writeStartElement(null, namespace, "lg", xmlWriter);

            if (localLg == Integer.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException("lg cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLg));
            }

            xmlWriter.writeEndElement();
        }
        if (localLtTracker) {
            namespace = "http://datas.speedtalk.com/xsd";
            writeStartElement(null, namespace, "lt", xmlWriter);

            if (localLt == Integer.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException("lt cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLt));
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
        if (localOilTracker) {
            namespace = "http://datas.speedtalk.com/xsd";
            writeStartElement(null, namespace, "oil", xmlWriter);

            if (localOil == Short.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException("oil cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOil));
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
        if (localSpeedTracker) {
            namespace = "http://datas.speedtalk.com/xsd";
            writeStartElement(null, namespace, "speed", xmlWriter);

            if (localSpeed == Short.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException("speed cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSpeed));
            }

            xmlWriter.writeEndElement();
        }
        if (localStatusTracker) {
            namespace = "http://datas.speedtalk.com/xsd";
            writeStartElement(null, namespace, "status", xmlWriter);

            if (localStatus == Integer.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException("status cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStatus));
            }

            xmlWriter.writeEndElement();
        }
        if (localTotalMileTracker) {
            namespace = "http://datas.speedtalk.com/xsd";
            writeStartElement(null, namespace, "totalMile", xmlWriter);

            if (localTotalMile == Integer.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException("totalMile cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTotalMile));
            }

            xmlWriter.writeEndElement();
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

        if (localAlarmTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "alarm"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAlarm));
        }
        if (localDirectionTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "direction"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDirection));
        }
        if (localElevationTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "elevation"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localElevation));
        }
        if (localGpsTimeTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "gpsTime"));

            elementList.add(localGpsTime == null ? null : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGpsTime));
        }
        if (localLenTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "len"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLen));
        }
        if (localLgTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "lg"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLg));
        }
        if (localLtTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "lt"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLt));
        }
        if (localMsIdTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "msId"));

            elementList.add(localMsId == null ? null : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMsId));
        }
        if (localOilTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "oil"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOil));
        }
        if (localResultTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "result"));


            elementList.add(localResult == null ? null : localResult);
        }
        if (localSpeedTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "speed"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSpeed));
        }
        if (localStatusTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "status"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStatus));
        }
        if (localTotalMileTracker) {
            elementList.add(new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "totalMile"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTotalMile));
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
        public static Gps parse(javax.xml.stream.XMLStreamReader reader) throws Exception {
            Gps object = new Gps();

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

                        if (!"Gps".equals(type)) {
                            //find namespace for the prefix
                            String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                            return (Gps) com.speedtalk.services.ExtensionMapper.getTypeObject(nsUri, type, reader);
                        }


                    }


                }


                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();


                reader.next();


                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "alarm").equals(reader
                        .getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException("The element: " + "alarm" + "  cannot be null");
                    }


                    String content = reader.getElementText();

                    object.setAlarm(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                    reader.next();

                }  // End of if for expected property start element

                else {

                    object.setAlarm(Integer.MIN_VALUE);

                }


                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "direction")
                        .equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException("The element: " + "direction" + "  cannot be null");
                    }


                    String content = reader.getElementText();

                    object.setDirection(org.apache.axis2.databinding.utils.ConverterUtil.convertToShort(content));

                    reader.next();

                }  // End of if for expected property start element

                else {

                    object.setDirection(Short.MIN_VALUE);

                }


                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "elevation")
                        .equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException("The element: " + "elevation" + "  cannot be null");
                    }


                    String content = reader.getElementText();

                    object.setElevation(org.apache.axis2.databinding.utils.ConverterUtil.convertToShort(content));

                    reader.next();

                }  // End of if for expected property start element

                else {

                    object.setElevation(Short.MIN_VALUE);

                }


                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "gpsTime")
                        .equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {


                        String content = reader.getElementText();

                        object.setGpsTime(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                    } else {


                        reader.getElementText(); // throw away text nodes if any.
                    }

                    reader.next();

                }  // End of if for expected property start element

                else {

                }


                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "len").equals(reader
                        .getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException("The element: " + "len" + "  cannot be null");
                    }


                    String content = reader.getElementText();

                    object.setLen(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                    reader.next();

                }  // End of if for expected property start element

                else {

                    object.setLen(Integer.MIN_VALUE);

                }


                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "lg").equals(reader
                        .getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException("The element: " + "lg" + "  cannot be null");
                    }


                    String content = reader.getElementText();

                    object.setLg(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                    reader.next();

                }  // End of if for expected property start element

                else {

                    object.setLg(Integer.MIN_VALUE);

                }


                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "lt").equals(reader
                        .getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException("The element: " + "lt" + "  cannot be null");
                    }


                    String content = reader.getElementText();

                    object.setLt(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                    reader.next();

                }  // End of if for expected property start element

                else {

                    object.setLt(Integer.MIN_VALUE);

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

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "oil").equals(reader
                        .getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException("The element: " + "oil" + "  cannot be null");
                    }


                    String content = reader.getElementText();

                    object.setOil(org.apache.axis2.databinding.utils.ConverterUtil.convertToShort(content));

                    reader.next();

                }  // End of if for expected property start element

                else {

                    object.setOil(Short.MIN_VALUE);

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

                        object.setResult(com.speedtalk.datas.xsd.Result.Factory.parse(reader));

                        reader.next();
                    }
                }  // End of if for expected property start element

                else {

                }


                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "speed").equals(reader
                        .getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException("The element: " + "speed" + "  cannot be null");
                    }


                    String content = reader.getElementText();

                    object.setSpeed(org.apache.axis2.databinding.utils.ConverterUtil.convertToShort(content));

                    reader.next();

                }  // End of if for expected property start element

                else {

                    object.setSpeed(Short.MIN_VALUE);

                }


                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "status")
                        .equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException("The element: " + "status" + "  cannot be null");
                    }


                    String content = reader.getElementText();

                    object.setStatus(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                    reader.next();

                }  // End of if for expected property start element

                else {

                    object.setStatus(Integer.MIN_VALUE);

                }


                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://datas.speedtalk.com/xsd", "totalMile")
                        .equals(reader.getName())) {

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException("The element: " + "totalMile" + "  cannot be null");
                    }


                    String content = reader.getElementText();

                    object.setTotalMile(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                    reader.next();

                }  // End of if for expected property start element

                else {

                    object.setTotalMile(Integer.MIN_VALUE);

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
           
    