package umc.study.converter;

import umc.study.domain.User;
import umc.study.web.dto.UserResponseDTO;

import java.time.LocalDateTime;

public class UserConverter {

    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user){
        return UserResponseDTO.JoinResultDTO.builder()
                .memberId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
