package com.mert.getty.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mert Kilic on 17.8.2017.
 */

public class Person {
    private int id;
    @SerializedName("first_name")
    private int firstName;
    @SerializedName("last_name")
    private int lastName;
    private int phone;
    private int gender;
    private int avatar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFirstName() {
        return firstName;
    }

    public void setFirstName(int firstName) {
        this.firstName = firstName;
    }

    public int getLastName() {
        return lastName;
    }

    public void setLastName(int lastName) {
        this.lastName = lastName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
