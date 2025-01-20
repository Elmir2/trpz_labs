package org.example.proxy;

class RealWebRequest implements WebRequest {
    @Override
    public void fetch(String url) {
        System.out.println("Fetching URL: " + url);

        // Емуляція отримання відповіді від сервера
        if (url.contains("redirect")) {
            System.out.println("HTTP 302: Redirecting to new location...");
            fetch(url.replace("redirect", "final"));
        } else if (url.contains("404")) {
            System.out.println("HTTP 404: Page not found.");
        } else if (url.contains("503")) {
            System.out.println("HTTP 503: Service unavailable.");
        } else {
            System.out.println("HTTP 200: Successfully fetched content from " + url);
        }
    }
}
