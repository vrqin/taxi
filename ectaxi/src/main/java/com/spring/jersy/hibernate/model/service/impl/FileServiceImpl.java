package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.service.FileService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.BufferOverflowException;

/**
 * Created by Administrator on 2016/10/12.
 */
@Service
public class FileServiceImpl implements FileService {


    private static final long MAX_FILE_SIZE = 20971520l; //20M

    @Override
    public void saveFile(InputStream fileInputStream, String path) throws BufferOverflowException, Exception {
        OutputStream outputStream = null;
        try {
            File file = new File(path);
            if (!file.exists()) {
                if (!file.getParentFile().exists())
                    file.getParentFile().mkdirs();
                int read = 0;
                byte[] bytes = new byte[524288]; //512KB
                outputStream = new FileOutputStream(new File(path));
                while ((read = fileInputStream.read(bytes)) != -1 && file.length() < MAX_FILE_SIZE)
                    outputStream.write(bytes, 0, read);
                if (read != -1 && file.length() >= MAX_FILE_SIZE) {
                    file.delete();
                    throw new BufferOverflowException();
                }
            } else {
                //System.out.println("The file already exist!");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                fileInputStream.close();
            } catch (Exception e) {
            }
            try {
                outputStream.flush();
            } catch (Exception e2) {
            }
            try {
                outputStream.close();
            } catch (Exception e2) {
            }
        }
    }

    @Override
    public void saveFile(byte[] datas, String path) throws BufferOverflowException, Exception {
        OutputStream outputStream = null;
        try {
            if (datas.length > MAX_FILE_SIZE)
                throw new BufferOverflowException();
            File file = new File(path);
            if (!file.exists()) {
                if (!file.getParentFile().exists())
                    file.getParentFile().mkdirs();
                outputStream = new FileOutputStream(new File(path));
                outputStream.write(datas);
            } else {
                //System.out.println("The file already exist!");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                outputStream.flush();
            } catch (Exception e2) {
            }
            try {
                outputStream.close();
            } catch (Exception e2) {
            }
        }
    }
}
