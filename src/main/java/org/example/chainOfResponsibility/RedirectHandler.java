package org.example.chainOfResponsibility;

public class RedirectHandler extends RequestHandler {
    @Override
    public void handleRequest(Request request) {
        if (request.getStatusCode() == 301 || request.getStatusCode() == 302) {
            System.out.println("RedirectHandler: Handling redirect response.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
