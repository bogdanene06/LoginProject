package Exercitii.mapper;

import org.springframework.stereotype.Component;
import Exercitii.DTO.MyUserDTO;
import Exercitii.entity.MyUser;

@Component
public class MyUserMapper {

    public MyUser toEntity(MyUserDTO myUserDTO) {
        return new MyUser(
                myUserDTO.getId(),
                myUserDTO.getUsername(),
                myUserDTO.getPassword(),
                myUserDTO.getRole()
        );
    }

    public MyUserDTO toDTO(MyUser myUser) {
        return new MyUserDTO(
                myUser.getUsername()
        );
    }
}
