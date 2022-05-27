package ru.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import ru.ApplicationMain;
import ru.entity.SightEntity;
import ru.entity.SightTableEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SightTableController extends AnchorPane {
    @FXML
    private Pane topPagePane;
    @FXML
    private Pagination sightListPages;

    private final TableView<SightTableEntity> sightTableEntityTableView = createTable();

    private int movieIndexToSet;

    public SightTableController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/SightTable.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sightListPages.setPageFactory(this::createPage);
    }

    public SightTableController(int pageIndexToSet, int movieIndexToSet) {
        this();
        sightListPages.setCurrentPageIndex(pageIndexToSet);
        this.movieIndexToSet = movieIndexToSet;
    }


    private Node createPage(int pageIndex) {
        int limit = (pageIndex + 1) * 100;
        List<SightTableEntity> listForTable = new ArrayList<>();
        for (int i = limit - 100; i < Math.min(limit, ApplicationMain.sightList.size()); i++) {
            listForTable.add(new SightTableEntity(ApplicationMain.sightList.get(i)));
        }
        sightTableEntityTableView.setItems(FXCollections.observableArrayList(listForTable));
        sightTableEntityTableView.scrollTo(movieIndexToSet);
        return new BorderPane(sightTableEntityTableView);
    }

    private TableView<SightTableEntity> createTable() {
        TableView<SightTableEntity> tableView = new TableView<>();
        tableView.getStyleClass().add("movie-table");
        tableView.setMinSize(1164, 660);
        tableView.setPrefSize(1164, 660);
        tableView.setMaxSize(1164, 660);
        TableColumn<SightTableEntity, ImageView> posterColumn = new TableColumn<>("Постер");
        posterColumn.setMinWidth(350);
        posterColumn.setPrefWidth(350);
        posterColumn.setMaxWidth(350);
        posterColumn.setReorderable(false);
        posterColumn.setResizable(false);
        posterColumn.setCellValueFactory(new PropertyValueFactory<>("majorPoster"));
        TableColumn<SightTableEntity, TextArea> infoColumn = new TableColumn<>("Информация");
        infoColumn.setMinWidth(761);
        infoColumn.setPrefWidth(761);
        infoColumn.setMaxWidth(820);
        infoColumn.setReorderable(false);
        infoColumn.setResizable(false);
        infoColumn.setCellValueFactory(new PropertyValueFactory<>("sightInfo"));
        tableView.setFixedCellSize(300.0);
        tableView.setOnMouseClicked(mouseEvent -> {
           if (tableView.getSelectionModel().getSelectedItem() != null) {
                MainPageController.setSubSceneRoot(new CreateSightTableController(tableView.getSelectionModel().getSelectedItem().getSightEntity(), sightListPages.getCurrentPageIndex(),tableView.getSelectionModel().getSelectedIndex()));
            }
        });
        tableView.getColumns().add(infoColumn);
        return tableView;
    }
}
