package org.example.proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        WebRequest webRequest = new WebRequestProxy();

        webRequest.fetch("http://example.com");
        webRequest.fetch("http://example.com/redirect");
        webRequest.fetch("http://example.com/404");
        webRequest.fetch("http://example.com/503");
        webRequest.fetch("invalid_url");
    }
}
