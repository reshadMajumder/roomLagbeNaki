package com.roomLagbe.roomlagbenaki.entities;

import jakarta.persistence.*;


@Entity
@Table(name="ROOM")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int r_id;
    private String imageUrl;
    private String title;
    private String price;
    private String divition;
    private String city;
    private String address;
    @Column(length = 500)
    private String description;
    private String roomtype;
    @ManyToOne
    private  User user;

    // Getters and setters omitted for brevity


    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDivition() {
        return divition;
    }

    public void setDivition(String divition) {
        this.divition = divition;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Room{" +
                "r_id=" + r_id +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", divition='" + divition + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", roomtype='" + roomtype + '\'' +
                ", user=" + user +
                '}';
    }


    public Room() {
        super();
    }
}