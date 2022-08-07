package com.learning.app.domain.inbound;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class LoginDTOIn {

    String email;
    String password;

}
