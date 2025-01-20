package org.example.visitor;

class HtmlResource extends BrowserResource {
    private String htmlContent;

    public HtmlResource(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    @Override
    public void accept(ResourceVisitor visitor) {
        visitor.visit(this);
    }
}
