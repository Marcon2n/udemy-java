package udemy.java.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import udemy.java.util.EnumPattern;
import udemy.java.util.GenderSubset;
import udemy.java.util.UserGender;
import udemy.java.util.UserStatus;

public class UserRequestDTO {
    @NotBlank(message = "First name cant be blank")
    @NotNull(message = "First name cant be null")
    private String firstName;

    @NotBlank(message = "Last name cant be blank")
    @NotNull(message = "Last name cant be null")
    private String lastName;

    @Pattern(regexp = "^\\d{10}$", message = "Phone needs to be 10 digits")
    private String phone;

    @Email(message = "Email is invalid")
    private String email;

    // EnumPattern annotation is manually created to validate enums from
    // EnumPatternValidator, this pattern is check valid base on regex
    @EnumPattern(name = "status", regexp = "ACTIVE|NONE")
    private UserStatus status;

    // Dont know why GenderSubset dont worked
    // @GenderSubset(anyOf = { MALE, FEMALE, OTHER })
    @EnumPattern(name = "gender", regexp = "MALE|FEMALE|OTHER")
    private UserGender gender;

    public UserRequestDTO(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public UserStatus getStatus() {
        return status;
    }

    public UserGender getGender() {
        return gender;
    }
}
