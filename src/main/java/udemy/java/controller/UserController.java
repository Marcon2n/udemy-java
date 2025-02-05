package udemy.java.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import udemy.java.dto.request.UserRequestDTO;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/")
    public String getUser(@Valid @RequestBody UserRequestDTO userDTO) {
        return "User added";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable int userId, @RequestBody UserRequestDTO userDTO) {
        System.out.println("Update with user id: " + userId);
        return "User updated";
    }

    @PatchMapping("/{userId}")
    public String changeStatus(@PathVariable int userId, @RequestParam(required = false) boolean status) {
        System.out.println("Change status user with user id: " + userId + ", status: " + status);
        return "User changed status";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId) {
        System.out.println("Delete user with user id: " + userId);
        return "Deleted User";
    }

    @GetMapping("/{userId}")
    public UserRequestDTO getUser(@PathVariable int userId) {
        System.out.println("Get user data with user id: " + userId);
        return new UserRequestDTO("Trịnh", "Tuấn Linh", "0901364869", "tuanlinhtrinh91@gmail.com");
    }

    @GetMapping("/get-list")
    public List<UserRequestDTO> getAllUser(@RequestParam(required = false, defaultValue = "0") int pageNo,
            @RequestParam(required = false, defaultValue = "10") int pageSize) {
        System.out.println("Get list user with page number: " + pageNo + ", and page size: " + pageSize);
        return List.of(new UserRequestDTO("Trần", "Thị Xuân Diệu", "0356696987", "xdsandy@gmail.com"),
                new UserRequestDTO("Trịnh", "Tuấn Linh", "0901364869", "tuanlinhtrinh91@gmail.com"));
    }

}
