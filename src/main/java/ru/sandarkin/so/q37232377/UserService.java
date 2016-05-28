package ru.sandarkin.so.q37232377;

import org.springframework.stereotype.Service;
import ru.sandarkin.so.q37232377.domain.User;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService() {

  }

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User getByUsername(String username) {
    return this.userRepository.getByUsername(username);
  }
}
