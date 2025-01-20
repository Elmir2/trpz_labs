package org.example.visitor;

class ImageResource extends BrowserResource {
    private String imageUrl;

    public ImageResource(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public void accept(ResourceVisitor visitor) {
        visitor.visit(this);
    }
}
