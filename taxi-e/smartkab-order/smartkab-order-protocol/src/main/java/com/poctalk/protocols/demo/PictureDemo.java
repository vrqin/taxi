package com.poctalk.protocols.demo;

import com.poctalk.protocols.gps.Picture;

public class PictureDemo {
    public PictureDemo() {
    }

    public static void main(String[] args) throws Exception {
        byte[] data = new byte[]{-86, 85, -86, 85, 0, 48, 55, 56, 57, 49, 50, 49, 48, 49, 50, 55, 56, 3, 0, 0, 9, 2, 0, 1, 59};
        byte[] commd = Picture.parsePicCommand(data);
        System.out.println("[0]:" + Integer.toHexString(commd[0] & 255));
        System.out.println("[1]:" + Integer.toHexString(commd[1] & 255));
    }
}
