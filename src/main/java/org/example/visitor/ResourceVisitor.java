package org.example.visitor;

interface ResourceVisitor {
    void visit(HtmlResource htmlResource);
    void visit(CssResource cssResource);
    void visit(JsResource jsResource);
    void visit(ImageResource imageResource);
}
