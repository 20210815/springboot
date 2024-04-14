package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

import java.util.ArrayList;

public class MemberConverter {

    //그냥 Member 데이터를 JoinResultDTO로 바꿔줌. 아마 controller에 회원가입 완료한 다음 결과로 내보내려는 듯
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memeberId(member.getId())
                .createdAt(member.getCreatedAt())
                .build();
    }

    //JoinDto로 받은 멤버 정보를 Member 객체로 만들어서 저장함
    public static Member toMember(MemberRequestDTO.JoinDTO request) {

        Gender gender = null;

        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }
}
