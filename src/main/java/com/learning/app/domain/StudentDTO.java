package com.learning.app.domain;

import com.learning.app.domain.inbound.StudentDTOIn;

public class StudentDTO extends StudentDTOIn {

    String id;

    public StudentDTO() {
    }

    public StudentDTO(String id, String name, String email, String password) {
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
