package umc.springboot.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.springboot.apiPayload.ApiResponse;
import umc.springboot.converter.MemberConverter;
import umc.springboot.domain.Member;
import umc.springboot.web.dto.MemberRequestDTO;
import umc.springboot.web.dto.MemberResponseDTO;
import umc.springboot.service.MemberService.MemberCommandService;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;


    //body에는 기본 회원 정보들을 채운 valid한 정보를 가져옴
    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDTO request) {
        Member member = memberCommandService.joinMember(request); //멤버로 회원가입을 하고
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
        //응답은 멤버가 회원가입하고 난 다음의 응답을 전달함.
    }
}
