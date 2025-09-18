package ua.edu.ukma.event_management_micro.user.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.edu.ukma.event_management_micro.user.UserService;


@Component
public class UserInternalApiImpl implements UserInternalApi {

    private final UserService userService;

    @Autowired
    public UserInternalApiImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean validateUserExists(Long userId) {
        try {
            userService.getUserById(userId);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

}