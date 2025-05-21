package org.example.demo2.visitor;

import org.jsoup.nodes.Element;

public interface Visitor {
    void visitText(Element element);
    void visitImage(Element element);
    void visitCss(Element element);
    void visitJs(Element element);
}