package br.com.hub.errors.controller;


import java.util.List;

import br.com.hub.errors.dto.request.UserDTORequest;
import br.com.hub.errors.dto.response.UserDTOResponse;
import br.com.hub.errors.model.UserInfo;
import br.com.hub.errors.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Api(value = "Central de Erros")
public class UserController {
    @Autowired
    private UserInfoService userService;

    @Autowired
    private ModelMapper modelMapper;

    @ApiOperation(value="Create a new user")
    @PostMapping("/register")
    @ApiResponse(code = 201, message = "Successfully created user.", response = UserDTOResponse.class)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTOResponse addUser(@RequestBody UserDTORequest userDTORequest) {
        UserInfo newUser;
        UserInfo userInfo = userService.getUserInfoByUserEmail(userDTORequest.getUserEmail());
        UserInfo user = convertToEntity(userDTORequest);

        if (userInfo == null) {
            newUser = userService.addUser(user);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.ALREADY_REPORTED, "Email already exists, id: " + userInfo.getId());
        }
        return convertToDto(newUser);
    }

    @ApiOperation(value = "Returns a list of registered users.")
    @GetMapping("api/user")
    public Object getAllUser(@RequestHeader HttpHeaders requestHeader) {
        List<UserInfo> userInfos = userService.getAllActiveUserInfo();
        if (userInfos == null || userInfos.isEmpty()) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return userInfos;
    }

    @ApiOperation(value="Allows you to change the password of a registered user.")
    @PutMapping("api/user/changePassword/{id}")
    @ApiResponse(code = 201, message = "Password successfully updated", response = UserDTOResponse.class)
    @ResponseStatus(HttpStatus.OK)
    public UserDTOResponse updateUserPassword(@RequestBody UserDTORequest userDTORequest, @PathVariable Integer id) {
        UserInfo userUpdated;
        UserInfo userInfo = userService.getUserByUserId(id);
        UserInfo user = convertToEntity(userDTORequest);

        if (userInfo != null) {
            userUpdated = userService.updatePassword(id, user);
        } else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User not found");
        }
        return convertToDto(userUpdated);
    }

    @ApiOperation(value="Allows you to modify the role of the registered user.")
    @PutMapping("api/user/changeRole/{id}")
    @ApiResponse(code = 201, message = "Role successfully updated", response = UserDTOResponse.class)
    @ResponseStatus(HttpStatus.OK)
    public UserDTOResponse updateUserRole(@RequestBody UserDTORequest userDTORequest, @PathVariable Integer id) {
        UserInfo userUpdated;
        UserInfo userInfo = userService.getUserByUserId(id);
        UserInfo user = convertToEntity(userDTORequest);

        if (userInfo != null) {
            userUpdated = userService.updateRole(id, user);
        } else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User not found");
        }
        return convertToDto(userUpdated);
    }

    @ApiOperation(value="Deletes a user.")
    @DeleteMapping("api/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Integer id) {
        UserInfo userInfo = userService.getUserByUserId(id);

        if (userInfo != null) {
            userService.deleteUser(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User not found");
        }
    }

    private UserDTOResponse convertToDto(UserInfo userInfo ) { return modelMapper.map(userInfo, UserDTOResponse.class); }

    private UserInfo convertToEntity(UserDTORequest userDTORequest) { return modelMapper.map(userDTORequest, UserInfo.class); }
}
