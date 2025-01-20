package org.example.template;

abstract class HttpResponseHandler {
    public final void processResponse(int statusCode, String content) {
        logResponse(statusCode, content);
        if (statusCode >= 200 && statusCode < 300) {
            handleSuccess(content);
        } else if (statusCode >= 300 && statusCode < 400) {
            handleRedirection(content);
        } else if (statusCode == 404) {
            handleNotFound();
        } else if (statusCode == 502 || statusCode == 503) {
            handleServerError();
        } else {
            handleUnknownStatus(statusCode);
        }
    }

    private void logResponse(int statusCode, String content) {
        System.out.println("Status Code: " + statusCode);
        System.out.println("Content: " + content);
    }

    protected abstract void handleSuccess(String content);

    protected abstract void handleRedirection(String content);

    protected abstract void handleNotFound();

    protected abstract void handleServerError();

    protected abstract void handleUnknownStatus(int statusCode);
}





