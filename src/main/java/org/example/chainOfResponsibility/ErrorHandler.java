package org.example.chainOfResponsibility;

public class ErrorHandler extends RequestHandler {
    @Override
    public void handleRequest(Request request) {
        if (request.getStatusCode() == 404) {
            System.out.println("ErrorHandler: Handling 404 - Page Not Found.");
        } else if (request.getStatusCode() == 502 || request.getStatusCode() == 503) {
            System.out.println("ErrorHandler: Handling 502/503 - Server Error.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
