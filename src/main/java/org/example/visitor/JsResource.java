package org.example.visitor;

class JsResource extends BrowserResource {
    private String jsContent;

    public JsResource(String jsContent) {
        this.jsContent = jsContent;
    }

    public String getJsContent() {
        return jsContent;
    }

    @Override
    public void accept(ResourceVisitor visitor) {
        visitor.visit(this);
    }
}