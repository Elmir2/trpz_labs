package org.example.factory;

class HtmlResourceFactory extends WebResourceFactory {
    @Override
    public WebResource createResource() {
        return new HtmlResource();
    }
}
