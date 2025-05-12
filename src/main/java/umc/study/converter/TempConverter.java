package umc.study.converter;

import umc.study.web.dto.TempResponse;

// ResponseDTO로 변환하는 역할
public class TempConverter {

    public static TempResponse.TempTestDTO toTempTestDTO(){
        return TempResponse.TempTestDTO.builder()
                .testString("This is Test!")
                .build();
    }
}
