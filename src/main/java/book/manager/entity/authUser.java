package book.manager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class authUser {
    int id;
    String name;
    String password;
    String role;
}
