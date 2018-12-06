package com.spring.jersy.hibernate.model.service;

import java.io.InputStream;
import java.nio.BufferOverflowException;

/**
 * Created by Administrator on 2016/10/12.
 */
public interface FileService {
    public void saveFile(InputStream fileInputStream, String path) throws BufferOverflowException, Exception;

    public void saveFile(byte[] datas, String path) throws BufferOverflowException, Exception;
}
