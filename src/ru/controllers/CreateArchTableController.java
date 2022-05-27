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
import ru.entity.ArchEntity;
import ru.entity.SightEntity;

import java.io.IOException;

import static ru.ApplicationMain.archList;

public class CreateArchTableController extends AnchorPane {
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
    private Button castListButton;

    private final ArchEntity archEntity;

    private final int currentPageIndex;

    private final int thisMovieIndex;

    public CreateArchTableController(ArchEntity archEntity, int pageIndex, int movieIndex) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/CreatingArchPage.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.archEntity = archEntity;
        this.currentPageIndex = pageIndex;
        this.thisMovieIndex = movieIndex;
        initPageInfo();
        initButtons();
    }

    private void initPageInfo() {
        poster.setImage(new Image(archEntity.getImagePath()));
        movieLabel.setText(archEntity.getTitle());
        StringBuilder infoBuilder = new StringBuilder();
        infoBuilder.append("\nОписание: ").append(archEntity.getDescription());
        movieInfoArea.setText(infoBuilder.toString());
    }
    private void initButtons() {
        //locationsListButton.setAlignment(Pos.CENTER_LEFT);
        //camerasListButton.setAlignment(Pos.CENTER_LEFT);
        //castListButton.setAlignment(Pos.CENTER_LEFT);
        backButton.setOnAction(actionEvent -> {
            MainPageController.setSubSceneRoot(new ArchTableControler(currentPageIndex, thisMovieIndex));
        });
    }
}