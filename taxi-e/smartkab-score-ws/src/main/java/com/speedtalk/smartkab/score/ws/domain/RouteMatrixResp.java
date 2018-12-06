package com.speedtalk.smartkab.score.ws.domain;

import java.util.List;

public class RouteMatrixResp {
    private int status;
    private List<Content> result;
    private String message;

    public RouteMatrixResp() {
        super();
    }

    public RouteMatrixResp(int status, List<Content> result, String message) {
        super();
        this.status = status;
        this.result = result;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Content> getResult() {
        return result;
    }

    public void setResult(List<Content> result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    class Value {
        private String text;
        private int value;

        public Value() {
            super();
        }

        public Value(String text, int value) {
            super();
            this.text = text;
            this.value = value;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    class Content {
        private Value distance;
        private Value duration;

        public Content() {
            super();
        }

        public Content(Value distance, Value duration) {
            super();
            this.distance = distance;
            this.duration = duration;
        }

        public Value getDistance() {
            return distance;
        }

        public void setDistance(Value distance) {
            this.distance = distance;
        }

        public Value getDuration() {
            return duration;
        }

        public void setDuration(Value duration) {
            this.duration = duration;
        }
    }
}
