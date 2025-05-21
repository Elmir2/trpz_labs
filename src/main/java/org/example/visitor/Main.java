package org.example.visitor;

public class Main {
    public static void main(String[] args) {
        BrowserResource html = new HtmlResource("<html><body>Hello, World!</body></html>");
        BrowserResource css = new CssResource("body { background-color: lightblue; }");
        BrowserResource js = new JsResource("console.log('Hello, World!');");
        BrowserResource image = new ImageResource("https://example.com/image.png");

        ResourceProcessor processor = new ResourceProcessor();

        html.accept(processor);
        css.accept(processor);
        js.accept(processor);
        image.accept(processor);
    }
}
