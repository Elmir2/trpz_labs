package org.example.demo2.factory_template;

import java.util.List;

public class ElementHandlerFactory {
    public List<ElementHandler> createHandlers() {
        return List.of(
                new TextHandler(),
                new ImageHandler(),
                new CssHandler(),
                new JsHandler()
        );
    }
}

