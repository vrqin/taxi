package com.spring.jersy.hibernate.publics.util;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Created by Administrator on 2016/5/27.
 */
public class ClientTarget {
    //    private static final String BASE_PATH = "http://221.5.72.213:9999/smartkab";
    private static final String BASE_PATH = "http://192.168.1.231:9999/smartkab";
    //	private static final String BASE_PATH = "http://192.168.1.231:9999/filews";
    //	private static final String BASE_PATH = "http://localhost:8080/Smart_Kab_ws";
    private static ClientTarget instance = new ClientTarget();
    private Client client;
    private WebTarget target;
    private MediaType mediaType;

    private ClientTarget() {
        client = ClientBuilder.newClient();
        target = client.target(BASE_PATH);
        mediaType = new MediaType("application", "json", "UTF-8");
    }

    public static ClientTarget getInstance() {
        return instance;
    }

    public Client getClient() {
        return client;
    }

    public WebTarget getTarget() {
        return target;
    }

    public String getBasePath() {
        return BASE_PATH;
    }

    public MediaType getMediaType() {
        return mediaType;
    }
}
