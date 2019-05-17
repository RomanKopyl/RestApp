package newProject.controllers.restControllers;

import newProject.domain.User;
import newProject.dto.RequestUserDto;
import newProject.dto.ResponseUserDto;
import newProject.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userslist")
public class UsersController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public Iterable<ResponseUserDto> list() {

        Iterable<User> users = userRepo.findAll();

        List<ResponseUserDto> responseList = new ArrayList<ResponseUserDto>();

        for (User userFromDb : users) {

            ResponseUserDto response = new ResponseUserDto(
                    userFromDb.getId(),
                    userFromDb.getUsername(),
                    userFromDb.getState());

            responseList.add(response);
        }

        return responseList;
    }

    @GetMapping("{id}")
    public ResponseUserDto getOne(@PathVariable Long id) throws Exception {

        User userFromDb = getUser(id);

        ResponseUserDto response = new ResponseUserDto(
                userFromDb.getId(),
                userFromDb.getUsername(),
                userFromDb.getState());

        return response;
    }

    private User getUser(@PathVariable Long id) throws Exception {

        Optional<User> user = userRepo.findById(id);

        if (!user.isPresent()) {
            throw new Exception("User with such id missing");
        }

        return user.get();
    }

    @PostMapping
    public ResponseUserDto create(@RequestBody RequestUserDto user) {

        User newUser = new User(user.getUsername(), user.getPassword());
        userRepo.save(newUser);

        ResponseUserDto response = new ResponseUserDto(
                newUser.getId(),
                newUser.getUsername(),
                newUser.getState());

        return response;
    }

    @PutMapping("{id}")
    public ResponseUserDto update(@PathVariable Long id, @RequestBody RequestUserDto user) throws Exception {

        User userFromDb = getUser(id);

        userFromDb.setUsername(user.getUsername());
        userFromDb.setPassword(user.getPassword());

        ResponseUserDto response = new ResponseUserDto(
                userFromDb.getId(),
                userFromDb.getUsername(),
                userFromDb.getState());

        userRepo.save(userFromDb);

        return response;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {

        userRepo.deleteById(id);
    }
}
