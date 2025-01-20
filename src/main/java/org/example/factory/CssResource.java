package org.example.factory;

class CssResource extends WebResource {
    @Override
    public void load() {
        System.out.println("Loading CSS resource...");
    }
}
