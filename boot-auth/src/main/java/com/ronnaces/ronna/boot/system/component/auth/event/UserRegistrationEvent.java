package com.ronnaces.ronna.boot.system.component.auth.event;

import com.ronnaces.ronna.boot.system.component.auth.bean.request.RegisterRequest;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;


@Getter
public class UserRegistrationEvent extends ApplicationEvent {

    private final RegisterRequest user;

    public UserRegistrationEvent(RegisterRequest user) {
        super(user);
        this.user = user;
    }
}
