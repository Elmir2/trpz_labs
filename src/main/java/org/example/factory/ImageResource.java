package org.example.factory;

class ImageResource extends WebResource {
    @Override
    public void load() {
        System.out.println("Loading Image resource...");
    }
}
