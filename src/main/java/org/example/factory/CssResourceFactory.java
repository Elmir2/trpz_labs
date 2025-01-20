package org.example.factory;

class CssResourceFactory extends WebResourceFactory {
    @Override
    public WebResource createResource() {
        return new CssResource();
    }
}
