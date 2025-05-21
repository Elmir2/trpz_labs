package org.example.demo2.visitor;

import javafx.scene.control.TextArea;
import org.jsoup.nodes.Element;

public class ConcreteVisitor implements Visitor {
    private final TextArea textOutput;
    private final TextArea imageOutput;
    private final TextArea cssOutput;
    private final TextArea jsOutput;

    public ConcreteVisitor(TextArea textOutput, TextArea imageOutput, TextArea cssOutput, TextArea jsOutput) {
        this.textOutput = textOutput;
        this.imageOutput = imageOutput;
        this.cssOutput = cssOutput;
        this.jsOutput = jsOutput;
    }

    @Override
    public void visitText(Element element) {
        textOutput.appendText(element.text() + "\n");
    }

    @Override
    public void visitImage(Element element) {
        imageOutput.appendText(element.attr("src") + "\n");
    }

    @Override
    public void visitCss(Element element) {
        cssOutput.appendText(element.attr("href") + "\n");
    }

    @Override
    public void visitJs(Element element) {
        jsOutput.appendText(element.attr("src") + "\n");
    }
}