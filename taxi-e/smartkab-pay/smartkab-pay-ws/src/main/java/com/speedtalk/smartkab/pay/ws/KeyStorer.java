package com.speedtalk.smartkab.pay.ws;

import java.io.*;
import java.security.Key;
import java.util.logging.Logger;

public class KeyStorer {
    //	@Context
    //	private ServletContext context;
    private static KeyStorer instance = new KeyStorer();
    private Logger log = Logger.getLogger(KeyStorer.class.getName());

    private KeyStorer() {
        // TODO Auto-generated constructor stub
    }

    public static KeyStorer getInstance() {
        if (null == instance)
            instance = new KeyStorer();
        return instance;
    }

    private String getFilePath() {
        String dir = System.getProperty("user.dir");
        dir = dir.replace("bin", "conf");
        //		return context.getRealPath("/");
        return dir;
    }

    private File getKeyFile() {
        log.info("key file path:" + getFilePath());
        File file = new File(getFilePath() + File.separator + "taxi_pay_key");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public Key getKey() throws FileNotFoundException, IOException, ClassNotFoundException {
        File file = getKeyFile();
        if (file == null)
            throw new FileNotFoundException();
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(file));
            return (Key) in.readObject();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                in.close();
            } catch (Exception e2) {
            }
        }
    }

    public void storeKey(Key key) {
        File file = getKeyFile();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(key);
            out.flush();
            log.info("Save key to file...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (Exception e2) {
            }
        }
    }
}
