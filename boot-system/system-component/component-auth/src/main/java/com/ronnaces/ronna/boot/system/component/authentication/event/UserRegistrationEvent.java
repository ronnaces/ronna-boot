package com.ronnaces.ronna.boot.system.component.authentication.event;

import com.ronnaces.ronna.boot.system.component.authentication.bean.request.RegisterRequest;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * UserRegistrationEvent
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/3/11 22:02
 */
@Getter
public class UserRegistrationEvent extends ApplicationEvent {

    private final RegisterRequest user;

    public UserRegistrationEvent(RegisterRequest user) {
        super(user);
        this.user = user;
    }
}
