package com.speedtalk.utils;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.concurrent.ConcurrentHashMap;

public class LoadXmlConfig {
    private static ConcurrentHashMap<String, String> configHash = new ConcurrentHashMap<>();

    public static void initConfigHash(String configName) {

        Document configDoc = com.speedtalk.utils.XmlParse.getXmlConfigDoc(configName);

        initHash(configDoc, "configHash");
    }

    public static ConcurrentHashMap<String, String> getConfigHash() {

        return configHash;
    }

    private static void initHash(Document doc, String hashtype) {
        try {

            NodeList nodeList = doc.getChildNodes();

            NodeList childNodeList = nodeList.item(0).getChildNodes();


            int len = childNodeList.getLength();


            if (hashtype.equalsIgnoreCase("configHash")) {

                for (int i = 0; i < len; i++) {

                    if (childNodeList.item(i).getNodeType() == 1)

                        configHash.put(childNodeList.item(i).getNodeName(), childNodeList.item(i).getTextContent());
                }
            }
        } catch (Exception e) {

            com.speedtalk.utils.ExcepPrinter.print(e);
        }
    }
}

