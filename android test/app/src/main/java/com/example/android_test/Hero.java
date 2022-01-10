package com.example.android_test;

public class Hero {
    private String id, nama, type, attribute, health, max_attack, speed, roles,image;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getMax_attack() {
        return max_attack;
    }

    public void setMax_attack(String max_attack) {
        this.max_attack = max_attack;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Hero(String id, String nama, String type, String attribute, String health, String max_attack, String speed, String roles, String image) {
        this.id = id;
        this.nama = nama;
        this.type = type;
        this.attribute = attribute;
        this.health = health;
        this.max_attack = max_attack;
        this.speed = speed;
        this.roles = roles;
        this.image = image;
    }
}
