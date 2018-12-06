package com.speedtalk.smartkab.ws.domain;

public class Content {
    private String account;
    private String content;

    public Content() {
        // TODO Auto-generated constructor stub
    }

    public Content(String account, String content) {
        super();
        this.account = account;
        this.content = content;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
