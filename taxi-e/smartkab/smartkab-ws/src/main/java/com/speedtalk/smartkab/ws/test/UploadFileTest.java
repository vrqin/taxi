package com.speedtalk.smartkab.ws.test;

import com.speedtalk.smartkab.ws.kabs.Distance;
import com.speedtalk.smartkab.ws.kabs.DistanceComparator;
import com.speedtalk.smartkab.ws.kabs.KabInfo;

import java.util.ArrayList;
import java.util.Collections;

public class UploadFileTest {
    public static void main(String[] args) {
        //		UploadFile file = new UploadFile("test.jpg",new byte[100]);
        //		MediaType mediaType = new MediaType("",MediaType.MULTIPART_FORM_DATA);
        //		Entity<UploadFile> entity = Entity.entity(file,mediaType);
        //		Response resp = ClientTarget.getInstance().getTarget().path("upload")
        //				.path("file").request().post(entity,Response.class);
        //		System.out.println(resp.getCode() + ":" + resp.getDesc());
        ArrayList<Distance> list = new ArrayList<Distance>();
        Distance d1 = new Distance(new KabInfo("d1", "1", "1", (byte) 1, (byte) 0, 0.0, 0.0, 100, 0, (byte) 0), 3.5);
        Distance d2 = new Distance(new KabInfo("d2", "2", "2", (byte) 1, (byte) 0, 0.0, 0.0, 100, 0, (byte) 1), 3.5);
        Distance d3 = new Distance(new KabInfo("d3", "3", "3", (byte) 1, (byte) 0, 0.0, 0.0, 100, 0, (byte) 1), 4.5);
        Distance d4 = new Distance(new KabInfo("d4", "4", "4", (byte) 1, (byte) 0, 0.0, 0.0, 100, 0, (byte) 0), 3.51);
        Distance d5 = new Distance(new KabInfo("d5", "5", "5", (byte) 1, (byte) 0, 0.0, 0.0, 100, 0, (byte) 1), 3.45);
        list.add(d1);
        list.add(d2);
        list.add(d3);
        list.add(d4);
        list.add(d5);
        Collections.sort(list, new DistanceComparator());
        for (Distance distance : list) {
            System.out.println(distance.getKab().getAccount() + "," + distance.getDistance() + "," + distance.getKab()
                    .getIsApp());
        }
    }
}
