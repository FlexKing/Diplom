package ru.entity;

import javafx.scene.control.TextArea;

public class SightTableEntity {
    private final TextArea sightInfo = new TextArea();
    private final SightEntity sightEntity;
    //idsight, description, adress, phone, webSite, imagePath
    public SightTableEntity(SightEntity sightEntity) {
        sightInfo.setWrapText(true);
        sightInfo.getStyleClass().add("sight-info-area");
        StringBuilder infoBuilder = new StringBuilder();
        infoBuilder.append(sightEntity.getDescription());
        infoBuilder.append("\n\nАдресс: ").append(sightEntity.getAddress());
        infoBuilder.append("\nТелефон: ").append(sightEntity.getPhone());
        infoBuilder.append("\nСайт: ").append(sightEntity.getWebSite());
        sightInfo.setText(infoBuilder.toString());
        sightInfo.setEditable(false);
        sightInfo.setMouseTransparent(true);
        this.sightEntity = sightEntity;
    }

    @Override
    public String toString() {
        return "SightTableEntity{" +
                "sightInfo=" + sightInfo +
                ", sightEntity=" + sightEntity +
                '}';
    }

    public TextArea getSightInfo() {
        return sightInfo;
    }

    public SightEntity getSightEntity() {
        return sightEntity;
    }
}
