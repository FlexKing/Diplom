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

import ru.entity.ArchTableEntity;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ru.ApplicationMain.archList;

public class ArchTableControler extends AnchorPane {
    @FXML
    private Pane topPagePane;
    @FXML
    private Pagination archListPages;
    @FXML
    private Button backButton;
    private final TableView <ArchTableEntity> archTableEntityTableView = createTable();

    private int movieIndexToSet;

    public ArchTableControler() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/ArchTable.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        archListPages.setPageFactory(this::createPage);
        initButtons();
    }

    public ArchTableControler(int pageIndexToSet, int movieIndexToSet) {
        this();
        archListPages.setCurrentPageIndex(pageIndexToSet);
        this.movieIndexToSet = movieIndexToSet;
    }
    public void initButtons(){
        backButton.setOnAction(actionEvent -> {
            MainPageController.setSubSceneRoot(new ArchMapMain());
            archList.clear();
        });
    }

    private Node createPage(int pageIndex) {
        int limit = (pageIndex + 1) * 100;
        List<ArchTableEntity> listForTable = new ArrayList<>();
        for (int i = limit - 100; i < Math.min(limit, archList.size()); i++) {
            listForTable.add(new ArchTableEntity(archList.get(i)));
        }
        archTableEntityTableView.setItems(FXCollections.observableArrayList(listForTable));
        archTableEntityTableView.scrollTo(movieIndexToSet);
        return new BorderPane(archTableEntityTableView);
    }

    private TableView<ArchTableEntity> createTable() {
        TableView<ArchTableEntity> tableView = new TableView<>();
        tableView.getStyleClass().add("movie-table");
        tableView.setMinSize(1164, 660);
        tableView.setPrefSize(1164, 660);
        tableView.setMaxSize(1164, 660);
        TableColumn<ArchTableEntity, ImageView> posterColumn = new TableColumn<>("Постер");
        posterColumn.setMinWidth(350);
        posterColumn.setPrefWidth(350);
        posterColumn.setMaxWidth(350);
        posterColumn.setReorderable(false);
        posterColumn.setResizable(false);
        posterColumn.setCellValueFactory(new PropertyValueFactory<>("majorPoster"));
        TableColumn<ArchTableEntity, TextArea> infoColumn = new TableColumn<>("Информация");
        infoColumn.setMinWidth(761);
        infoColumn.setPrefWidth(761);
        infoColumn.setMaxWidth(820);
        infoColumn.setReorderable(false);
        infoColumn.setResizable(false);
        infoColumn.setCellValueFactory(new PropertyValueFactory<>("sightInfo"));
        tableView.setFixedCellSize(300.0);
        tableView.setOnMouseClicked(mouseEvent -> {
            if (tableView.getSelectionModel().getSelectedItem() != null) {
                MainPageController.setSubSceneRoot(new CreateArchTableController(tableView.getSelectionModel().getSelectedItem().getSightEntity(), archListPages.getCurrentPageIndex(),tableView.getSelectionModel().getSelectedIndex()));
            }
        });
        tableView.getColumns().add(infoColumn);
        return tableView;
    }
}