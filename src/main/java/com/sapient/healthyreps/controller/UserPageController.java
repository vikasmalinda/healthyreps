/**
 * User page Controller
 *
 * @author Aniket
 */
package com.sapient.healthyreps.controller;

import com.sapient.healthyreps.entity.User;
import com.sapient.healthyreps.interfaces.IUserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/user")
@SessionAttributes("User")
public class UserPageController {
  private final IUserDAO userRepo;

  public UserPageController(IUserDAO userRepo) {
    this.userRepo = userRepo;
  }

  @GetMapping("/{id}")
  public String processUserId(Model model, @PathVariable(value = "id") int id) {
    Optional<User> userOfGivenId = userRepo.findById(id);
    if (!userOfGivenId.isPresent()) {
      return "home";
    }

    // User is found in the database
    User presentUser = userOfGivenId.orElse(null);
    model.addAttribute("User", presentUser);
    return "userPage";
  }
}
