package ru.entity;

import java.util.Objects;

public class ArchEntity {
    //idArchitecture, title, description, type, imagePath
    private Integer idArchitecture;
    private String title;
    private String description;
    private String type;
    private String imagePath;

    public ArchEntity(Integer idArchitecture, String title, String description, String type, String imagePath) {
        this.idArchitecture = idArchitecture;
        this.title = title;
        this.description = description;
        this.type = type;
        this.imagePath = imagePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArchEntity that = (ArchEntity) o;
        return idArchitecture.equals(that.idArchitecture) && title.equals(that.title) && description.equals(that.description) && type.equals(that.type) && imagePath.equals(that.imagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idArchitecture, title, description, type, imagePath);
    }

    @Override
    public String toString() {
        return "ArchEntity{" +
                "idArchitecture=" + idArchitecture +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }

    public Integer getIdArchitecture() {
        return idArchitecture;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getImagePath() {
        return imagePath;
    }
}
