package org.example.factory;

class HtmlResource extends WebResource {
    @Override
    public void load() {
        System.out.println("Loading HTML resource...");
    }
}
