/*
Author: Ene Bogdan
Country: Romania
*/
package Exercitii.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyUserDTO {

    private Long id;
    private String username;
    private String password;
    private String role;


    public MyUserDTO(String username) {
        this.username = username;

    }
}
