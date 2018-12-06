package com.speedtalk.smartkab.score.ws;

import com.speedtalk.utils.AutoLoadConfig;
import com.speedtalk.utils.LoadXmlConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Logger;

public class TaxiScoreListener implements ServletContextListener {
    private Logger log = Logger.getLogger(TaxiScoreListener.class.getName());
    private ScoreCalculator calculator;

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        try {
            calculator.setRun(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(1);
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        String dir = System.getProperty("user.dir");
        dir = dir.replace("bin", "conf");
        LoadXmlConfig.initConfigHash(dir + "/taxiscore_config.xml");
        new Thread(new AutoLoadConfig(dir + "/taxiscore_config.xml")).start();
        log.info("TaxiScoreListener finished init...!");

        calculator = new ScoreCalculator(LoadXmlConfig.getConfigHash().get("queue_addr"), "engine_to_score");
        new Thread(calculator).start();
    }
}
