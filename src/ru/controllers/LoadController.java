package ru.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import ru.entity.SightEntity;
import ru.manager.SightEntityManager;

import java.io.IOException;

public class LoadController extends AnchorPane {
    @FXML
    private Button backButton;
    @FXML
    private WebEngine webEngine;
    @FXML
    private WebView contentWebView;
    private final SightEntity sightEntity;
    private final int currentPageIndex;

    private final int thisMovieIndex;

    public LoadController (SightEntity sightEntity,int pageIndex, int movieIndex) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/LoadSite.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        contentWebView.setMinSize(1165, 861);
        webEngine = contentWebView.getEngine();
        String url = sightEntity.getWebSite();
        this.sightEntity = sightEntity;
        this.currentPageIndex = pageIndex;
        this.thisMovieIndex = movieIndex;
        webEngine.load(url);
        initButtons();
    }
    public void initButtons(){
        backButton.setOnAction(actionEvent -> {
            MainPageController.setSubSceneRoot(new CreateSightTableController(sightEntity,currentPageIndex,thisMovieIndex));
        });
    }

}