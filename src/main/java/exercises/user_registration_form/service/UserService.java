package exercises.user_registration_form.service;

import exercises.user_registration_form.dao.UserRepo;
import exercises.user_registration_form.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User saveUserToDatabase(User user) {
        return userRepo.save(user);
    }

    @Override
    public boolean isPasswordConfirmed(User user) {

        String password = user.getPassword();
        String confirmPassword = user.getConfirmPassword();
        boolean passwordsMatch = password != null && password.equals(confirmPassword);

        return passwordsMatch;
    }
}
