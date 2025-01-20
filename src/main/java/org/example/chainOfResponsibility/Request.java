package org.example.chainOfResponsibility;

public class Request {
    private final int statusCode;
    private final String payload;

    public Request(int statusCode, String payload) {
        this.statusCode = statusCode;
        this.payload = payload;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getPayload() {
        return payload;
    }
}
