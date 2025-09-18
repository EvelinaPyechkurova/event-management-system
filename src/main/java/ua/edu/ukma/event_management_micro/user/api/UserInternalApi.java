package ua.edu.ukma.event_management_micro.user.api;

import ua.edu.ukma.event_management_micro.user.UserDto;

import java.util.Optional;

/**
 * Internal API for other modules to communicate with User module
 */
public interface UserInternalApi {

    boolean validateUserExists(Long userId);

}