package ru.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;

public class ConnectController extends AnchorPane {
    @FXML
    private WebEngine webEngine;
    @FXML
    private WebView contentWebView;
    public ConnectController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/ConnectPage.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        contentWebView.setMinSize(1110, 761);
        webEngine = contentWebView.getEngine();
        webEngine.load("https://forms.yandex.ru/u/627182b6ed0f88f149794682/");

    }
}
