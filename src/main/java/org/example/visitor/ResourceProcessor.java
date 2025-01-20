package org.example.visitor;

class ResourceProcessor implements ResourceVisitor {
    @Override
    public void visit(HtmlResource htmlResource) {
        System.out.println("Processing HTML content: " + htmlResource.getHtmlContent());
    }

    @Override
    public void visit(CssResource cssResource) {
        System.out.println("Processing CSS content: " + cssResource.getCssContent());
    }

    @Override
    public void visit(JsResource jsResource) {
        System.out.println("Processing JavaScript content: " + jsResource.getJsContent());
    }

    @Override
    public void visit(ImageResource imageResource) {
        System.out.println("Processing Image: " + imageResource.getImageUrl());
    }
}
