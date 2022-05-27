package ru.controllers;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import ru.entity.ArchEntity;
import ru.manager.ArchEntityManager;
import ru.manager.SightEntityManager;
import ru.utils.DialogUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ru.ApplicationMain.archList;
import static ru.controllers.MainPageController.setSubSceneRoot;

public class ArchMapMain extends AnchorPane {
    @FXML
    private Button refreshButton;
    @FXML
    private WebEngine webEngine;
    @FXML
    private WebView contentWeb;
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private Button nextButton;
    private final List<String> archValues = new ArrayList<>();
    public ArchMapMain () {
        String url = "https://yandex.ru/maps/?um=constructor%3A9e4ccd334b5e0855621e454ca149cc00a840ff33935b3c862353dc3c2831f697&source=constructorLink";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/ArchMapMain.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        contentWeb.setMinSize(1165, 861);
        webEngine = contentWeb.getEngine();
        webEngine.load(url);
        initBoxes();
        initButtons();
    }
    private void initBoxes(){
        archValues.add("Aттик");
        archValues.add("Портик");
        archValues.add("Колонна");
        archValues.add("Статуя бога");
        archValues.add("Статуя героя");
        choiceBox.setItems(FXCollections.observableArrayList(archValues));
        choiceBox.setValue("Выбирите тип архетиктурного элемента");
    }
    private  void  initButtons(){
        choiceBox.setOnAction(actionEvent -> {
                String url = "";
                if (choiceBox.getValue().equals("Aттик")) {
                    url = "https://yandex.ru/maps/?um=constructor%3Ac27aff12b0951771ff47d156387df5bf56d472a9211a32607482b7e0e60b50ae&source=constructorLink";
                    webEngine.load(url);
                    archList.clear();
                        try {
                            archList.addAll(ArchEntityManager.getAllRowsAttik());
                        }catch (SQLException e){
                            e.printStackTrace();
                        }

                }

                else if (choiceBox.getValue().equals("Портик")) {
                            archList.clear();
                            url = "https://yandex.ru/maps/?um=constructor%3A0de941d866d374e1f440352494060707064e172e7061c75989ea1e5ccdc599c2&source=constructorLink";
                            webEngine.load(url);
                    try {
                        archList.addAll(ArchEntityManager.getAllRowsPortik());
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
                else if (choiceBox.getValue().equals("Колонна")) {
                    archList.clear();
                    url = "https://yandex.ru/maps/?um=constructor%3Ab8aa17d372cf3fd9473aab4f0566cde67ee8ed09809d90abea9ee179011933c7&source=constructorLink";
                    webEngine.load(url);  try {
                        archList.addAll(ArchEntityManager.getAllRowsColumn());
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
                else if (choiceBox.getValue().equals("Статуя героя")) {
                    archList.clear();
                    url = "https://yandex.ru/maps/?um=constructor%3Ae1a5500d56d979804b9eaec195778ead83d5b7d495cfffc624221da0cb4d83e0&source=constructorLink";
                    webEngine.load(url);
                    try {
                        archList.addAll(ArchEntityManager.getAllRowsHeroes());
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
                else if (choiceBox.getValue().equals("Статуя бога")) {
                    archList.clear();
                    url= "https://yandex.ru/maps/?um=constructor%3Ad22c84a85477276d71f723ac25ad265ece3d19239a5f9a6bd45c47d170e2ff18&source=constructorLink";
                    webEngine.load(url);
                    try {
                        archList.addAll(ArchEntityManager.getAllRowsGods());
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
        });
        // <Button layoutX="429.0" layoutY="19.0" mnemonicParsing="false" prefHeight="34.0" prefWidth="170.0" styleClass="exit-button" text="Сбросить фильры" />
        nextButton.setOnAction(actionEvent -> {
            if (archList.isEmpty()){
                DialogUtil.showError("Прежде чем нажать на кнопку 'Подробнее' выбирите тип архитектуры");
            }
            else {
                setSubSceneRoot(new ArchTableControler());
            }
        });
    }
}