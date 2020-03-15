package br.com.hub.errors.controller;

import br.com.hub.errors.dto.UserDTO;
import br.com.hub.errors.model.User;
import br.com.hub.errors.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/users")
    @ApiOperation(value = "Retorna uma lista de usuários")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    @ApiOperation(value = "Retorna um usuário específico")
    public Optional<User> findById(@PathVariable(value = "id") UUID id) {
        return userService.findById(id);
    }

    @PostMapping("/user")
    @ApiOperation(value = "Cria um novo usuário")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public UserDTO saveUser(@Valid @RequestBody UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        User userCreated = userService.registerUser(user);
        return convertToDto(userCreated);
    }

    private UserDTO convertToDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    private User convertToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
