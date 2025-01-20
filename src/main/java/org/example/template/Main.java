package org.example.template;

public class Main {
    public static void main(String[] args) {
        HttpResponseHandler handler = new BrowserHttpResponseHandler();

        handler.processResponse(200, "<html>Success Page</html>");
        handler.processResponse(301, "Redirected Content");
        handler.processResponse(404, "Page Not Found Content");
        handler.processResponse(503, "Server Error Content");
        handler.processResponse(999, "Unknown Response");
    }
}
