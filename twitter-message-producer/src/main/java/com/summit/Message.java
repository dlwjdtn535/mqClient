package com.summit;


import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class Message {
    @NotEmpty(message = "{email.notempty}")
    private String email;


    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }
}
