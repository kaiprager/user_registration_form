package exercises.user_registration_form.controller;

import exercises.user_registration_form.entity.User;
import exercises.user_registration_form.service.UserServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    private UserServiceInterface userServiceInterface;

    @Autowired
    public UserController(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "registration-form";
    }

    @PostMapping("/registration")
    public String submitRegistrationForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {

        if(!userServiceInterface.isPasswordConfirmed(user)) {
            bindingResult.rejectValue("confirmPassword", "error.user", "Passwords do not match!");
        }

        if (bindingResult.hasErrors()) {
            return "registration-form";
        } else {
            userServiceInterface.saveUserToDatabase(user);
            model.addAttribute("user", user);
            return "registration-success";
        }
    }

    @GetMapping("/success")
    public String showSuccessPage(@ModelAttribute("user") User user) {
        return "registration-success";
    }

}
