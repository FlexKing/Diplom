package ru.controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;

public class Map extends AnchorPane {
    @FXML
    private WebEngine webEngine;
    @FXML
    private WebView contentWebView;
    public Map () {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/Map.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        contentWebView.setMinSize(1165, 861);
        webEngine = contentWebView.getEngine();
        webEngine.load("https://yandex.ru/maps/?um=constructor%3A9e4ccd334b5e0855621e454ca149cc00a840ff33935b3c862353dc3c2831f697&source=constructorLink");
    }

}
