package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberPreferConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberPrefer;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    //멤버가 지금 join 하겠다고 들어온 상황 JoinDTO에 맞춰서
    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDTO request) {

        Member newMember = MemberConverter.toMember(request);
        
        // 화면에서 List 중 선택된 food category의 id 값을 전달 받음
        //stream 요소를 하나씩 빼는 작업을 함.
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream() //사용자가 마음에 들어하는 foodCategory에서 고른 것들을 하나씩 가져옴
                .map(category -> {   //그것들을 가져와서 category의 값을 -> O 여기 값으로 바꿀 거임 (id로 찾은 객체로 category를 바꿈)
                                //category는 id임 id로 객체를 찾아서 받음   거기 없으면, handler를 통해서 오류 알림
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList()); // 그것들을 모아서 list로 만들어서 foodCategoryList 안에 넣어줌

        // foodCategoryList에서 newMember가 좋아하는 음식 카테고리를 id로 찾아서 list를 만들었고, 그거를 Member 안에 넣어줘야 하기 때문에,
        // foodCategory 타입의 list가 아니라 MemberPrefer 타입의 리스트로 변환해서 => MemberPrefer 자체가 member id 를 가져야 하니까
        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        //또 각각의 memberpreferlist에서 꺼내서 memberprefer 하나씩 추가함
        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}
