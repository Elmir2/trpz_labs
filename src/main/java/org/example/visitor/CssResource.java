package org.example.visitor;

class CssResource extends BrowserResource {
    private String cssContent;

    public CssResource(String cssContent) {
        this.cssContent = cssContent;
    }

    public String getCssContent() {
        return cssContent;
    }

    @Override
    public void accept(ResourceVisitor visitor) {
        visitor.visit(this);
    }
}
