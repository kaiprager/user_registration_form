package exercises.user_registration_form.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "user_registration")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please enter your username!")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must contain only letters and numbers.")
    private String username;

    @NotBlank(message = "Please enter your email!")
    @Email(message = "Please enter a valid email address!")
    private String email;

    @NotBlank(message = "Please enter your password!")
    @Size(min = 6, message = "Password must be at least 6 characters long.")
    private String password;

    @Transient
    private String confirmPassword;

    @NotNull(message = "Please enter your date of birth!")
    @Past(message = "Date of birth must be in the past.")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Please select your gender!")
    private String gender;

    private String phoneNumber;

    @NotBlank(message = "Please select your country!")
    @Pattern(regexp = "^(?!Select$).*", message = "Please select your country!")
    private String country;


    // Constructors
    public User() {

    }

    public User(String username, String email, String password, String confirmPassword, LocalDate dateOfBirth, String gender, String phoneNumber, String country) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.country = country;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
