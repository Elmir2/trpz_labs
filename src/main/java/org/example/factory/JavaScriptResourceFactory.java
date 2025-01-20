package org.example.factory;

class JavaScriptResourceFactory extends WebResourceFactory {
    @Override
    public WebResource createResource() {
        return new JavaScriptResource();
    }
}
