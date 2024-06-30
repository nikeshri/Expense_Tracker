package org.example.expensestracker.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {

    private String token;
    private long expiresIn;

    public String getToken()
    {

        return token;
    }
}
