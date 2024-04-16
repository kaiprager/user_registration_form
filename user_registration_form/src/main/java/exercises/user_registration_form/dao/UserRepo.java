package exercises.user_registration_form.dao;

import exercises.user_registration_form.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
