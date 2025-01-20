package org.example.factory;

public class Main {
    public static void main(String[] args) {
        // Створюємо фабрики для різних типів ресурсів
        WebResourceFactory htmlFactory = new HtmlResourceFactory();
        WebResourceFactory cssFactory = new CssResourceFactory();
        WebResourceFactory jsFactory = new JavaScriptResourceFactory();
        WebResourceFactory imageFactory = new ImageResourceFactory();

        // Використовуємо фабрики для створення та завантаження ресурсів
        WebResource html = htmlFactory.createResource();
        html.load();

        WebResource css = cssFactory.createResource();
        css.load();

        WebResource js = jsFactory.createResource();
        js.load();

        WebResource image = imageFactory.createResource();
        image.load();
    }
}
