package org.example.proxy;

class WebRequestProxy implements WebRequest {
    private RealWebRequest realWebRequest;

    public WebRequestProxy() {
        this.realWebRequest = new RealWebRequest();
    }

    @Override
    public void fetch(String url) {
        System.out.println("[Proxy] Validating URL...");

        if (!isValidUrl(url)) {
            System.out.println("Invalid URL: " + url);
            return;
        }

        System.out.println("[Proxy] URL is valid. Proceeding with request.");

        realWebRequest.fetch(url);
    }

    private boolean isValidUrl(String url) {
        return url.startsWith("http://") || url.startsWith("https://");
    }
}
