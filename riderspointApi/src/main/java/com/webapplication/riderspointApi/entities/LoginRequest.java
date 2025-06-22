package com.webapplication.riderspointApi.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class LoginRequest {

    @Id
    private String username;
    private String password;

}
