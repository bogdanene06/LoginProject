package Exercitii.startup;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import Exercitii.entity.MyUser;
import Exercitii.repository.MyUserRepository;

@Component
@RequiredArgsConstructor
public class RunAtStartup {

    private final MyUserRepository myUserRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void insert2UsersAfterStartup() {
        String encryptedPassword = new BCryptPasswordEncoder().encode("password1");
        MyUser myUser1 = new MyUser("user1", encryptedPassword, "admin");
        myUserRepository.save(myUser1);

        encryptedPassword = new BCryptPasswordEncoder().encode("password2");
        MyUser myUser2 = new MyUser("user2", encryptedPassword, "user");
        myUserRepository.save(myUser2);
    }
}
