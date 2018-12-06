package com.speedtalk.order.engine.threads;

import com.speedtalk.order.engine.OrderLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;

public class GetMyInfo implements Runnable {
    private byte[] key = {0x63, 0x68, 0x65, 0x6E, 0x5F, 0x70, 0x69};

    private byte[] decrypt(byte[] data) throws NullPointerException {
        if (data == null)
            throw new NullPointerException("Data is Null!");
        byte[] temps = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            int j = i % key.length;
            temps[i] = (byte) (data[i] ^ key[j]);
        }
        return temps;
    }

    @Override
    public void run() {
        String respStr = null, decrypt = null;
        int count = 0;
        while (true) {
            try {
                Thread.sleep(60 * 60000);
            } catch (Exception e) {
            }
            try {
                respStr = getInfo();
            } catch (Exception e) {
                //				e.printStackTrace();
                OrderLogger.getLogger().debug(count + " get info exception!");
                if (++count > 2)
                    expired();
                else
                    continue;
            }
            try {
                decrypt = new String(decrypt(respStr.getBytes()));
            } catch (Exception e) {
            }
            if (decrypt != null) {
                try {
                    if (decrypt.split(":")[2].equals("0")) {
                        count = 0;
                        continue;
                    } else if (decrypt.split(":")[2].equals("1")) {
                        expired();
                    }
                } catch (Exception e) {
                    //					e.printStackTrace();
                    OrderLogger.getLogger().debug(count + " get info exception!");
                    if (++count > 2)
                        expired();
                    else
                        continue;
                }
            }
            OrderLogger.getLogger().debug(count + " get info exception!");
            if (++count > 2)
                expired();
        }
    }

    private void expired() {
        OrderLogger.getLogger().debug("============ expired ============");
        System.exit(1);
    }

    private String getInfo() throws IOException, ConnectException {
        String urlStr = "http://121.201.6.35:9080/eng_manage/manage/info";
        BufferedReader in = null;
        StringBuilder resp = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null)
                resp.append(line);
        } catch (ConnectException ce) {
            throw ce;
        } catch (IOException ioe) {
            throw ioe;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e) {
            }
        }
        return resp.toString();
    }
}
