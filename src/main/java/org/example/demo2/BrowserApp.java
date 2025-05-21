package org.example.demo2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.concurrent.Task;
import org.example.demo2.handlers.ContentParser;
import org.example.demo2.proxy.PageProxy;

public class BrowserApp extends Application {
    private TextField addressBar;
    private TextArea textOutput, imageOutput, cssOutput, jsOutput;
    private PageProxy proxy = new PageProxy();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Web Content Analyzer");

        // Navigation Panel
        addressBar = new TextField();
        addressBar.setPromptText("Enter URL...");
        Button goButton = new Button("Analyze");
        HBox navigationBar = new HBox(10);
        navigationBar.setPadding(new Insets(10));
        navigationBar.getChildren().addAll(addressBar, goButton);
        HBox.setHgrow(addressBar, Priority.ALWAYS);

        // Content Areas
        textOutput = createTextArea("Website Text Content");
        imageOutput = createTextArea("Image URLs");
        cssOutput = createTextArea("CSS Resources");
        jsOutput = createTextArea("JavaScript Resources");

        // Tab Layout
        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(
                createTab("Text", textOutput),
                createTab("Images", imageOutput),
                createTab("CSS", cssOutput),
                createTab("JavaScript", jsOutput)
        );
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Event Handling
        goButton.setOnAction(e -> loadWebsite());
        addressBar.setOnAction(e -> loadWebsite());

        // Main Layout
        VBox mainLayout = new VBox(10);
        mainLayout.getChildren().addAll(navigationBar, tabPane);
        VBox.setVgrow(tabPane, Priority.ALWAYS);

        Scene scene = new Scene(mainLayout, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TextArea createTextArea(String promptText) {
        TextArea textArea = new TextArea();
        textArea.setPromptText(promptText);
        textArea.setWrapText(true);
        return textArea;
    }

    private Tab createTab(String title, TextArea content) {
        Tab tab = new Tab(title);
        tab.setContent(new BorderPane(content));
        return tab;
    }

    private void loadWebsite() {
        String url = addressBar.getText().trim();
        if (url.isEmpty()) return;

        Task<String> task = new Task<>() {
            @Override
            protected String call() throws Exception {
                return proxy.visit(url);
            }
        };

        task.setOnSucceeded(e -> {
            clearOutputs();
            new ContentParser().parseContent(task.getValue(), textOutput, imageOutput, cssOutput, jsOutput);
        });

        task.setOnFailed(e -> {
            clearOutputs();
            textOutput.setText("Error loading website: " + task.getException().getMessage());
        });

        new Thread(task).start();
    }

    private void clearOutputs() {
        textOutput.clear();
        imageOutput.clear();
        cssOutput.clear();
        jsOutput.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}