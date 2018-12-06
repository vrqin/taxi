package com.speedtalk.utils;

import java.io.File;

public class AutoLoadConfig implements Runnable {
    private Long lastMotifytime;
    private String fileName;

    public AutoLoadConfig(String fileName) {

        this.fileName = fileName;
    }

    @Override
    public void run() {

        File file;
        try {

            file = new File(this.fileName);
        } catch (Exception e) {

            e.printStackTrace();

            return;
        }

        com.speedtalk.utils.LoadXmlConfig.initConfigHash(this.fileName);

        this.lastMotifytime = file.lastModified();
        while (true) {
            try {

                Thread.sleep(1000 * Integer.parseInt(com.speedtalk.utils.LoadXmlConfig.getConfigHash()
                        .get("check-interval")));
            } catch (InterruptedException e) {

                com.speedtalk.utils.ExcepPrinter.print(e);
            }

            if (file.lastModified() == this.lastMotifytime)
                continue;

            com.speedtalk.utils.LoadXmlConfig.initConfigHash(this.fileName);

            this.lastMotifytime = file.lastModified();
        }
    }
}

