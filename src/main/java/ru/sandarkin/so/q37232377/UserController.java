package ru.sandarkin.so.q37232377;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.sandarkin.so.q37232377.domain.User;

@RestController
public class UserController {

  // backed by UserRepository
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(path = "/users/{username}", method = RequestMethod.GET)
  public User getUser(@PathVariable String username) {
    return userService.getByUsername(username);
  }

}