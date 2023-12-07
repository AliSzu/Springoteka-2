package Pracownia.Projekt.Spring.Services;

import Pracownia.Projekt.Spring.Entities.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);
}
