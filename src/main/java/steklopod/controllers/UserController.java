package steklopod.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import steklopod.model.User;
import steklopod.repositories.UserRepository;

import java.util.List;

@RestController
@Api(tags = {"Users", "Пользователи"}, value = "Users", description = "Rest API for Users operations")
public class UserController {
    @Autowired
    private UserRepository repository;


    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Все клиенты", response = User.class)
    public List<User> findAll() {
        return repository.findAll();
    }

    @GetMapping("/user/{lastName}")
    @ApiOperation(value = "Клиент по фамилии", response = User.class)
    public Iterable<User> findByLastName(@PathVariable String lastName) {
        return repository.findByLastName(lastName);
    }

    @RequestMapping("/raiseError")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ApiOperation(value = "Бросает ошибку", response = Exception.class)
    public val raiseError() {
        throw new IllegalArgumentException("Упс. Ты получил ошибку.");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleError(IllegalArgumentException e) {
        return e.getMessage();
    }
}
