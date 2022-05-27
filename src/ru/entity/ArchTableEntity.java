package ru.entity;

import javafx.scene.control.TextArea;

public class ArchTableEntity {
    private final TextArea archInfo = new TextArea();
    private final ArchEntity archEntity;
    //idsight, description, adress, phone, webSite, imagePath
    public ArchTableEntity(ArchEntity archEntity) {
        archInfo.setWrapText(true);
        archInfo.getStyleClass().add("sight-info-area");
        StringBuilder infoBuilder = new StringBuilder();
        infoBuilder.append(archEntity.getDescription());

        archInfo.setText(infoBuilder.toString());
        archInfo.setEditable(false);
        archInfo.setMouseTransparent(true);
        this.archEntity = archEntity;
    }

    public TextArea getSightInfo() {
        return archInfo;
    }

    public ArchEntity getSightEntity() {
        return archEntity;
    }
}