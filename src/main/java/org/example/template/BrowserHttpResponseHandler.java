package org.example.template;

class BrowserHttpResponseHandler extends HttpResponseHandler {

    @Override
    protected void handleSuccess(String content) {
        System.out.println("Rendering HTML content...");
    }

    @Override
    protected void handleRedirection(String content) {
        System.out.println("Redirecting to a new URL...");
    }

    @Override
    protected void handleNotFound() {
        System.out.println("Displaying 404 Page: Page Not Found.");
    }

    @Override
    protected void handleServerError() {
        System.out.println("Displaying 502/503 Page: Server Error.");
    }

    @Override
    protected void handleUnknownStatus(int statusCode) {
        System.out.println("Unhandled status code: " + statusCode);
    }
}
