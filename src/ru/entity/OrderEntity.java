package ru.entity;

import java.util.Objects;

public class OrderEntity {
    private Integer idOrder;
    private String description;
    private String title;
    private String type;
    private String imagePath;

    public OrderEntity(Integer idOrder, String description, String title, String type, String imagePath) {
        this.idOrder = idOrder;
        this.description = description;
        this.title = title;
        this.type = type;
        this.imagePath = imagePath;
    }

    //idOrder, description, title, type
    @Override
    public String toString() {
        return "OrderEntity{" +
                "idOrder=" + idOrder +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return idOrder.equals(that.idOrder) && description.equals(that.description) && title.equals(that.title) && type.equals(that.type) && imagePath.equals(that.imagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, description, title, type, imagePath);
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getImagePath() {
        return imagePath;
    }
}
