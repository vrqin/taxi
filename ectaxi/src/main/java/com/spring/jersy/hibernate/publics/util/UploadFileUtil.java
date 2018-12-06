package com.spring.jersy.hibernate.publics.util;

import java.io.*;
import java.util.Calendar;

/**
 * Created by Administrator on 2016/10/21.
 */
public class UploadFileUtil {

    /**
     * 上传图片的方法
     *
     * @param imageFile
     * @param imageName
     * @return
     * @throws IOException
     */
    public static String uploadImage(String path, File imageFile, String imageName) throws IOException {
        /*创建输入流*/
        InputStream is = new FileInputStream(imageFile);
        return uploadImage(path, is, imageName);
    }

    /**
     * 上传图片的方法
     *
     * @param path
     * @param inputStream
     * @param imageName
     * @return
     * @throws IOException
     */
    public static String uploadImage(String path, InputStream inputStream, String imageName) throws IOException {
        int random = (int) (Math.random() * 900) + 100;
        /*设置上传目录*/
        Calendar cal = Calendar.getInstance();
        String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
        month = month.length() == 1 ? "0" + month : month;
        String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        day = day.length() == 1 ? "0" + day : day;
        String imageUrlPath = "images" + "/" + cal.get(Calendar.YEAR) + "/" + month + "/" + day;
        String imagePath = path + imageUrlPath;
        File file = new File(imagePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        /*设置目标文件*/
        String targetImageName = "" + cal.get(Calendar.HOUR) + cal.get(Calendar.MINUTE) + cal.get(Calendar.SECOND) + cal
                .get(Calendar.MILLISECOND) + random + imageName.substring(imageName.lastIndexOf("."));
        File target = new File(imagePath + "/" + targetImageName);
        /*创建输出流*/
        OutputStream os = new FileOutputStream(target);
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = inputStream.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
        inputStream.close();
        os.close();
        return "/" + imageUrlPath + "/" + targetImageName;
    }
}
