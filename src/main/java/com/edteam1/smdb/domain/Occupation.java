package com.edteam1.smdb.domain;

import lombok.Data;

public enum Occupation {

    ACTOR("actor"), DIRECTOR("director") , PRODUCER("producer");

    private String name;

     Occupation( String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
