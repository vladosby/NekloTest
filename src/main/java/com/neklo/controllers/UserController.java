package com.neklo.controllers;

import com.neklo.dto.UserIdDTO;
import com.neklo.dto.UserResponseDTO;
import com.neklo.entities.Role;
import com.neklo.entities.User;
import com.neklo.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

import static org.springframework.http.MediaType.*;

/**
 * Created by vladosby on 18.01.15.
 */
@Controller
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST,
            produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    public UserResponseDTO returnUserById(@RequestBody UserIdDTO userIdDTO) {
        final User user = new User();
        user.setPassword("4321098");
        user.setFirstName("Xxxx");
        user.setLastName("Yyyy");
        final Role role = new Role();
        role.setRoleId(1);
        user.setRole(role);
        userService.saveUser(user);
        try {
            return new UserResponseDTO(userService.findUserById(userIdDTO.getUserId()));
        } catch (EmptyResultDataAccessException e) {
            log.error("Object with id {} not found", userIdDTO.getUserId());
            return new UserResponseDTO();
        }

    }

}
