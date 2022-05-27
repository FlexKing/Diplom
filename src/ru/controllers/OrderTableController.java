package ru.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import ru.entity.OrderTableEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static ru.ApplicationMain.orderList;

public class OrderTableController extends AnchorPane {
    @FXML
    private Pane topPagePane;
    @FXML
    private Pagination orderListPages;
    @FXML
    private Button backButton;

    private final TableView <OrderTableEntity> orderTableEntityTableView = createTable();

    private int orderIndexToSet;

    public OrderTableController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/OrderTable.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        orderListPages.setPageFactory(this::createPage);
        initButtons();
    }

    public OrderTableController(int pageIndexToSet, int orderIndexToSet) {
        this();
        orderListPages.setCurrentPageIndex(pageIndexToSet);
        this.orderIndexToSet = orderIndexToSet;
    }
    public void initButtons(){
        backButton.setOnAction(actionEvent -> {
            MainPageController.setSubSceneRoot(new OrderMapMain());
            orderList.clear();
        });
    }

    private Node createPage(int pageIndex) {
        int limit = (pageIndex + 1) * 100;
        List<OrderTableEntity> listForTable = new ArrayList<>();
        for (int i = limit - 100; i < Math.min(limit, orderList.size()); i++) {
            listForTable.add(new OrderTableEntity(orderList.get(i)));
        }
        orderTableEntityTableView.setItems(FXCollections.observableArrayList(listForTable));
        orderTableEntityTableView.scrollTo(orderIndexToSet);
        return new BorderPane(orderTableEntityTableView);
    }

    private TableView<OrderTableEntity> createTable() {
        TableView<OrderTableEntity> tableView = new TableView<>();
        tableView.getStyleClass().add("movie-table");
        tableView.setMinSize(1164, 660);
        tableView.setPrefSize(1164, 660);
        tableView.setMaxSize(1164, 660);
        TableColumn<OrderTableEntity, ImageView> posterColumn = new TableColumn<>("Постер");
        posterColumn.setMinWidth(350);
        posterColumn.setPrefWidth(350);
        posterColumn.setMaxWidth(350);
        posterColumn.setReorderable(false);
        posterColumn.setResizable(false);
        posterColumn.setCellValueFactory(new PropertyValueFactory<>("majorPoster"));
        TableColumn<OrderTableEntity, TextArea> infoColumn = new TableColumn<>("Информация");
        infoColumn.setMinWidth(760);
        infoColumn.setPrefWidth(761);
        infoColumn.setMaxWidth(820);
        infoColumn.setReorderable(false);
        infoColumn.setResizable(false);
        infoColumn.setCellValueFactory(new PropertyValueFactory<>("orderInfo"));
        tableView.setFixedCellSize(300.0);
        tableView.setOnMouseClicked(mouseEvent -> {
            if (tableView.getSelectionModel().getSelectedItem() != null) {
                MainPageController.setSubSceneRoot(new CreateOrderTableController(tableView.getSelectionModel().getSelectedItem().getOrderEntity(), orderListPages.getCurrentPageIndex(),tableView.getSelectionModel().getSelectedIndex()));
            }
        });
        tableView.getColumns().add(infoColumn);
        return tableView;
    }
}
