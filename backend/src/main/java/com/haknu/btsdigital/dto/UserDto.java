package com.haknu.btsdigital.dto;

import com.haknu.btsdigital.domain.User;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDto {

    private Long id;
    private String email;
    private String name;
    private String address;
    private String contract;
    private String phone;
    private boolean active;
    private boolean api;
    private String role;
    private String password;

    public static UserDto info(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setEmail(user.getUsername());
        dto.setName(user.getName());
        dto.setPhone(user.getPhone());
        dto.setRole(user.getRole().name());
        return dto;
    }

    public static UserDto of(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setEmail(user.getUsername());
        dto.setName(user.getName());
        dto.setPhone(user.getPhone());
        dto.setActive(user.isActive());
        dto.setRole(user.getRole().name());
        return dto;
    }
}
