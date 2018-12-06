package com.speedtalk;

import com.speedtalk.utils.AutoLoadConfig;
import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;
import org.apache.log4j.Logger;
import org.apache.mina.core.future.ConnectFuture;


public class StartUp {
    public final static Logger LOG = Logger.getLogger("cnsle");
    public static String SERV_CHARSET = System.getProperty("file.encoding");

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            LOG.debug("The Server's encoding is :" + SERV_CHARSET);
            LoadXmlConfig.initConfigHash("config.xml");
            new Thread(new AutoLoadConfig("config.xml")).start();
            ExcepPrinter.init(LoadXmlConfig.getConfigHash().get("excep-log"));
            LOG.debug("Finished load config...");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Load config error,check config.xml then restart!");
            System.exit(0);
        }
        try {
            LOG.debug("Connecting server...");
            ConnectFuture future = ClientConnector.getInstance().connect();
            while (!future.isConnected()) {
                try {
                    Thread.sleep(Integer.parseInt(LoadXmlConfig.getConfigHash().get("reconnect-interval")) * 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                future = ClientConnector.getInstance().reConnect();
                StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + "Connect server failure,continue...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connect server error,check server's config then restart!");
            System.exit(0);
        }
    }
}
