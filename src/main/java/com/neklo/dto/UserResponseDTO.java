package com.neklo.dto;

import com.neklo.entities.User;

/**
 * Created by vladosby on 18.01.15.
 */
public class UserResponseDTO {
    private int userid;
    private String firstName;
    private String lastName;
    private String role;

    public UserResponseDTO() {
    }

    public UserResponseDTO(User user) {
        userid = user.getUserId();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        role = user.getRole().getName();
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
