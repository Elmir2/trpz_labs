package org.example.factory;

class JavaScriptResource extends WebResource {
    @Override
    public void load() {
        System.out.println("Loading JavaScript resource...");
    }
}
