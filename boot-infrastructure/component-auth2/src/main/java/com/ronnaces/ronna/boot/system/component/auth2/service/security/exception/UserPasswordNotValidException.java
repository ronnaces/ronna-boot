
package com.ronnaces.ronna.boot.system.component.auth2.service.security.exception;

import org.springframework.security.authentication.AccountStatusException;

public class UserPasswordNotValidException extends AccountStatusException {

    public UserPasswordNotValidException(String msg) {
        super(msg);
    }

}
