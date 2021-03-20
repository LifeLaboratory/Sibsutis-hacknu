package com.haknu.btsdigital.dto;

import com.haknu.btsdigital.domain.User;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDto {

    private Long id;
    private String idAito;
    private String name;
    private String surname;
    private String avatarUrl;
    private boolean active;
    private String role;
    private String password;

    public static UserDto info(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setIdAito(user.getIdAito());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setAvatarUrl(user.getAvatarUrl());
        dto.setRole(user.getRole().name());
        return dto;
    }

    public static UserDto of(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setIdAito(user.getIdAito());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setAvatarUrl(user.getAvatarUrl());
        dto.setActive(user.isActive());
        dto.setRole(user.getRole().name());
        return dto;
    }
}
