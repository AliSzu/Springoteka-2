package Pracownia.Projekt.Spring.Services;

import Pracownia.Projekt.Spring.Entities.User;
import Pracownia.Projekt.Spring.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
