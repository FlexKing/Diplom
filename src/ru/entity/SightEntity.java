package ru.entity;

import java.util.Objects;

public class SightEntity {
    //idsight,title, description, adress, phone, webSite, imagePath
    private final Integer idSight;
    private final String description;
    private final String address;
    private final String phone;
    private final String webSite;
    private final String imagePath;
    private final String title;

    public SightEntity(Integer idSight, String description, String address, String phone, String webSite, String imagePath, String title) {
        this.idSight = idSight;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.webSite = webSite;
        this.imagePath = imagePath;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SightEntity that = (SightEntity) o;
        return idSight.equals(that.idSight) && description.equals(that.description) && address.equals(that.address) && phone.equals(that.phone) && webSite.equals(that.webSite) && imagePath.equals(that.imagePath) && title.equals(that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSight, description, address, phone, webSite, imagePath, title);
    }

    public Integer getIdSight() {
        return idSight;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebSite() {
        return webSite;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getTitle() {
        return title;
    }
}
