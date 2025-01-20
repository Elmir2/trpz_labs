package org.example.factory;

class ImageResourceFactory extends WebResourceFactory {
    @Override
    public WebResource createResource() {
        return new ImageResource();
    }
}
