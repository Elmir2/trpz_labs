package org.example.chainOfResponsibility;

public class SuccessHandler extends RequestHandler {
    @Override
    public void handleRequest(Request request) {
        if (request.getStatusCode() == 200) {
            System.out.println("SuccessHandler: Handling successful response.");
            System.out.println("Payload: " + request.getPayload());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
