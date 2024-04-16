package exercises.user_registration_form.service;

import exercises.user_registration_form.entity.User;

public interface UserServiceInterface {

    User saveUserToDatabase(User user);

    boolean isPasswordConfirmed(User user);
}
