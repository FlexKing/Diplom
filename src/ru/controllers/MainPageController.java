package ru.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import ru.ApplicationMain;
import ru.utils.DialogUtil;

import java.io.IOException;
import java.util.Objects;

public class MainPageController {
    @FXML
    private AnchorPane mainPane;

    @FXML
    private Pane topPane;

    @FXML
    private ImageView topLogo;

    @FXML
    private Label userLabel;

    @FXML
    private Pane leftNavPane;

    @FXML
    private ToggleButton conceptsButton;

    @FXML
    private ToggleButton moviesButton;

    @FXML
    private ToggleButton genresButton;


    @FXML
    private ToggleButton certificatesButton;
    @FXML
    private  ToggleButton connectButton;

    @FXML
    private ToggleGroup Menu;

    @FXML
    private Button exitButton;

    private static SubScene subSceneRoot;


    @FXML
    private void initialize() {
        topLogo.setImage(new Image(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream("images/mainIcon.png"))));
        mainPane.setOnMouseClicked(mouseEvent -> mainPane.requestFocus());
        Menu.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle == null) {
                oldToggle.setSelected(true);
            }
        });

        subSceneRoot = new SubScene(new Map(), 1165, 860);
        subSceneRoot.getStyleClass().add("sub-panels");
        AnchorPane.setTopAnchor(subSceneRoot, 89.0);
        AnchorPane.setLeftAnchor(subSceneRoot, 275.0);
        mainPane.getChildren().add(subSceneRoot);

        userLabel.setText(ApplicationMain.currentUser.getName() + ", " + ApplicationMain.currentUser.getEmail());
        initNavButtons();
    }



    private void initNavButtons() {
        conceptsButton.setOnAction(actionEvent -> {
            if (conceptsButton.isSelected()) {
                setSubSceneRoot(new SightTableController());
            }
        });
        moviesButton.setOnAction(actionEvent -> {
            if(moviesButton.isSelected()){
                setSubSceneRoot(new Map());
            }
        });
        genresButton.setOnAction(actionEvent -> {
            if(genresButton.isSelected()){
                setSubSceneRoot(new ArchMapMain());
            }
        });
        certificatesButton.setOnAction(actionEvent -> {
            if(certificatesButton.isSelected()){
                setSubSceneRoot(new OrderMapMain());
            }
        });
        connectButton.setOnAction(actionEvent -> {
            if (connectButton.isSelected()){
                setSubSceneRoot(new ConnectController());
            }
        });
        exitButton.setOnAction(actionEvent -> {
            if (DialogUtil.showConfirm("Вы точно хотите выйти?\nВы будете возвращены на страницу авторизации.")) {
                ApplicationMain.currentUser = null;
                try {
                    ApplicationMain.mainScene.setRoot(FXMLLoader.load(getClass().getResource("../views/LoginPage.fxml")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void setSubSceneRoot(Parent newRoot) {
        subSceneRoot.setRoot(newRoot);
    }
}


