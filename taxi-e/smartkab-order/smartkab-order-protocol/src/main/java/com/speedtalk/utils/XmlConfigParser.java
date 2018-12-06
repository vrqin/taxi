package com.speedtalk.utils;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class XmlConfigParser {
    private String configName;
    private Map<String, String> configMap;

    public XmlConfigParser(String configName) {
        /* 16 */
        this.configName = configName;
        /* 17 */
        this.configMap = new ConcurrentHashMap();
    }

    public void parseConfig() {
        try {
            /* 23 */
            Document doc = com.speedtalk.utils.XmlParse.getXmlConfigDoc(this.configName);
            /* 24 */
            NodeList nodeList = doc.getChildNodes();
            /* 25 */
            NodeList childNodeList = nodeList.item(0).getChildNodes();
            /* 26 */
            int len = childNodeList.getLength();
            /* 27 */
            for (int i = 0; i < len; i++) {
                /* 29 */
                if (childNodeList.item(i).getNodeType() == 1)
                    /* 30 */
                    this.configMap.put(childNodeList.item(i).getNodeName(), childNodeList.item(i)
                            /* 31 */.getTextContent());
            }
        } catch (Exception e) {
            /* 36 */
            e.printStackTrace();
        }
    }

    public String getConfigName() {
        /* 41 */
        return this.configName;
    }

    public void setConfigName(String configName) {
        /* 45 */
        this.configName = configName;
    }

    public Map<String, String> getConfigMap() {
        /* 49 */
        return this.configMap;
    }

    public void setConfigMap(Map<String, String> configMap) {
        /* 53 */
        this.configMap = configMap;
    }
}

