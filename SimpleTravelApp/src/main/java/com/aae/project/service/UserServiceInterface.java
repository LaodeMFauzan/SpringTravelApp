package com.aae.project.service;

import com.aae.project.model.User;
import java.util.Optional;

/**
 *
 * @author fauzan
 */
public interface UserServiceInterface {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    User saveUser(User user);
}
