package org.example.chainOfResponsibility;

public class Main {
    public static void main(String[] args) {
        RequestHandler successHandler = new SuccessHandler();
        RequestHandler redirectHandler = new RedirectHandler();
        RequestHandler errorHandler = new ErrorHandler();

        successHandler.setNextHandler(redirectHandler);
        redirectHandler.setNextHandler(errorHandler);

        Request request1 = new Request(200, "OK");
        Request request2 = new Request(301, "Redirect to /new-location");
        Request request3 = new Request(404, "Not Found");
        Request request4 = new Request(502, "Bad Gateway");

        System.out.println("Processing request1:");
        successHandler.handleRequest(request1);

        System.out.println("\nProcessing request2:");
        successHandler.handleRequest(request2);

        System.out.println("\nProcessing request3:");
        successHandler.handleRequest(request3);

        System.out.println("\nProcessing request4:");
        successHandler.handleRequest(request4);
    }
}
