package org.example.demo2.factory_template;

import org.example.demo2.visitor.Visitor;
import org.jsoup.nodes.Element;

public class TextHandler extends ElementHandler {
    @Override
    public void handleElement(Element element, Visitor visitor) {
        visitor.visitText(element);
    }
}