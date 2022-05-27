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
import ru.manager.OrderEntityManager;
import ru.manager.SightEntityManager;
import ru.utils.DialogUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ru.ApplicationMain.archList;
import static ru.ApplicationMain.orderList;
import static ru.controllers.MainPageController.setSubSceneRoot;

public class OrderMapMain extends AnchorPane {
    @FXML
    private WebEngine webEngine;
    @FXML
    private WebView contentWeb;
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private Button nextButton;
    private final List<String> orderValues = new ArrayList<>();
    public OrderMapMain () {
        String url = "https://yandex.ru/maps/?um=constructor%3A9e4ccd334b5e0855621e454ca149cc00a840ff33935b3c862353dc3c2831f697&source=constructorLink";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/OrderMapMain.fxml"));
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
        orderValues.add("Дорический");
        orderValues.add("Ионический");
        orderValues.add("Коринфский");
        orderValues.add("Тосканский");
        orderValues.add("Композитный");
        choiceBox.setItems(FXCollections.observableArrayList(orderValues));
        choiceBox.setValue("Выбирите тип ордера");
    }
    private  void  initButtons(){
        choiceBox.setOnAction(actionEvent -> {
            String url = "";
            if (choiceBox.getValue().equals("Дорический")) {
                url = "https://yandex.ru/maps/?um=constructor%3A4350fd0b898b20b1ffe105a1f29f41ef7eaeab0794749dbc7696962eded07f4f&source=constructorLink";
                webEngine.load(url);
                orderList.clear();
                try {
                    orderList.addAll(OrderEntityManager.getAllRowsDorion());
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            //"Дорический Ионический Коринфский Тосканский Композитный"
            else if (choiceBox.getValue().equals("Ионический")) {
                url="https://yandex.ru/maps/?um=constructor%3A41d3045338126021c28087e0c62ccddb0c2e8be00b3a66e0415496d38ae3f969&source=constructorLink";
                webEngine.load(url);
                orderList.clear();
                try {
                    orderList.addAll(OrderEntityManager.getAllRowsIon());
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
            else if (choiceBox.getValue().equals("Коринфский")) {
                url="https://yandex.ru/maps/?um=constructor%3A12cb91f3ce45683ab87ebb6a3b008c1e41be66ce271a993a7bf35c0c2d256069&source=constructorLink";
                webEngine.load(url);
                orderList.clear();
                try {
                    orderList.addAll(OrderEntityManager.getAllRowsKorinf());
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
            else if (choiceBox.getValue().equals("Тосканский")) {
                url="https://yandex.ru/maps/?um=constructor%3A10d4c3c527ba95549ee90077c539d6cef943a3b8de7bbfb11a63cf310cb32257&source=constructorLink";
                webEngine.load(url);
                orderList.clear();
                try {
                    orderList.addAll(OrderEntityManager.getAllRowsTosk());
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
            else if (choiceBox.getValue().equals("Композитный")) {
                url="https://yandex.ru/maps/?um=constructor%3A71782a65fb7aae797452483c130cb63d4070153b3febe2c71cd6f65dda8fada0&source=constructorLink";
                webEngine.load(url);
                orderList.clear();
                try {
                    orderList.addAll(OrderEntityManager.getAllRowsKompozitn());
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        });
        nextButton.setOnAction(actionEvent -> {
            if (orderList.isEmpty()){
                DialogUtil.showError("Прежде чем нажать на кнопку 'Подробнее' выбирите тип ордера");
            }
            else {
                setSubSceneRoot(new OrderTableController());

            }
        });
    }
}
