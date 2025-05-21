package org.example.demo2.factory_template;

import org.example.demo2.visitor.Visitor;
import org.jsoup.nodes.Element;

public class CssHandler extends ElementHandler {
    @Override
    public void handleElement(Element element, Visitor visitor) {
        if ("link".equals(element.tagName()) && "stylesheet".equals(element.attr("rel"))) {
            visitor.visitCss(element);
        }
    }
}