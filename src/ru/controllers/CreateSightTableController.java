package ru.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import ru.entity.SightEntity;
import ru.utils.DialogUtil;

import java.io.IOException;
import java.util.Objects;


public class CreateSightTableController extends AnchorPane {
    @FXML
    private Button backButton;

    @FXML
    private Label movieLabel;

    @FXML
    private TextArea movieInfoArea;

    @FXML
    private ImageView poster;

    @FXML
    private Button locationsListButton;

    @FXML
    private Button camerasListButton;
    @FXML
    private Button nextButton;

    @FXML
    private Button castListButton;

    private final SightEntity sightEntity;

    private final int currentPageIndex;

    private final int thisMovieIndex;

    public CreateSightTableController(SightEntity sightEntity, int pageIndex, int movieIndex) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/CreatingSightPage.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sightEntity = sightEntity;
        this.currentPageIndex = pageIndex;
        this.thisMovieIndex = movieIndex;
        initPageInfo();
        initButtons();
    }

    private void initPageInfo() {
        poster.setImage(new Image(sightEntity.getImagePath()));
        movieLabel.setText(sightEntity.getTitle());
        StringBuilder infoBuilder = new StringBuilder();
        infoBuilder.append("\nОписание: ").append(sightEntity.getDescription());
        infoBuilder.append("\nАдресс: ").append(sightEntity.getAddress());
        infoBuilder.append("\nТелефон: ").append(sightEntity.getPhone());
        movieInfoArea.setText(infoBuilder.toString());
    }

    private void initButtons() {
        //camerasListButton.setAlignment(Pos.CENTER_LEFT);
        //castListButton.setAlignment(Pos.CENTER_LEFT);
        nextButton.setOnAction(actionEvent -> {
            if(Objects.equals(sightEntity.getWebSite(), "Отсутсвует")){
                DialogUtil.showInfo("У достопримечательности нет вэб-сайта");
            }
            else {
                MainPageController.setSubSceneRoot(new LoadController(sightEntity, currentPageIndex, thisMovieIndex));
            }
        });
        backButton.setOnAction(actionEvent -> {
            MainPageController.setSubSceneRoot(new SightTableController(currentPageIndex,thisMovieIndex));
        });
        /*if (movieEntity.getLocations() == null) {
            locationsListButton.setDisable(true);
        } else {
            locationsListButton.setOnAction(actionEvent -> MainPageController.setSubSceneRoot(new MovieCertainPositionsSubPageController(movieEntity, currentPageIndex, thisMovieIndex, 1)));
        }
        if (movieEntity.getCamera() == null) {
            camerasListButton.setDisable(true);
        } else {
            camerasListButton.setOnAction(actionEvent -> MainPageController.setSubSceneRoot(new MovieCertainPositionsSubPageController(movieEntity, currentPageIndex, thisMovieIndex, 2)));
        }
        castListButton.setOnAction(actionEvent -> MainPageController.setSubSceneRoot(new MovieCertainPositionsSubPageController(movieEntity, currentPageIndex, thisMovieIndex, 3)));*/
    }
}
