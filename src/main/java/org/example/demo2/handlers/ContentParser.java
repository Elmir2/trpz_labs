package org.example.demo2.handlers;

import javafx.scene.control.TextArea;
import org.example.demo2.factory_template.ElementHandler;
import org.example.demo2.factory_template.ElementHandlerFactory;
import org.example.demo2.visitor.ConcreteVisitor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ContentParser {
    private final ElementHandlerFactory handlerFactory = new ElementHandlerFactory();

    public void parseContent(String html, TextArea textOutput, TextArea imageOutput, TextArea cssOutput, TextArea jsOutput) {
        Document doc = Jsoup.parse(html);
        Elements elements = doc.getAllElements();
        ConcreteVisitor visitor = new ConcreteVisitor(textOutput, imageOutput, cssOutput, jsOutput);

        for (Element element : elements) {
            for (ElementHandler handler : handlerFactory.createHandlers()) {
                handler.handleElement(element, visitor);
            }
        }
    }
}