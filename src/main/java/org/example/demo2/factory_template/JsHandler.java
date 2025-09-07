package org.example.demo2.factory_template;

import org.example.demo2.visitor.Visitor;
import org.jsoup.nodes.Element;

public class JsHandler extends ElementHandler {
    @Override
    public void handleElement(Element element, Visitor visitor) {
        if ("script".equals(element.tagName()) && element.hasAttr("src")) {
            visitor.visitJs(element);
        }
    }
}