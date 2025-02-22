package com.example.myproductservice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public abstract class BaseModel {

    private Long id;

    private Date createdAt;

    private Date lastupdatedAt;

    private State  state;
}
