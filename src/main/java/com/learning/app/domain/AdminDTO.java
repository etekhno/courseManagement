package com.learning.app.domain;

import com.learning.app.domain.inbound.AdminDTOIn;

public class AdminDTO extends AdminDTOIn {

    String id;

    public AdminDTO() {
    }

    public AdminDTO(String id, String name, String email, String password) {
        super(name, email, password);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
