package org.example.demo2.factory_template;

import org.example.demo2.visitor.Visitor;
import org.jsoup.nodes.Element;

public abstract class ElementHandler {
    public abstract void handleElement(Element element, Visitor visitor);
}