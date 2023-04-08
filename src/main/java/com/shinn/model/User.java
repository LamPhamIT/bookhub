package com.shinn.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User extends AbstractModel<User> {
    private String userName;
    private String password;
    private Long roleId;
    private Role role;
}
