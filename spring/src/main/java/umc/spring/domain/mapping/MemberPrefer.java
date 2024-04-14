package umc.spring.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.common.BaseEntity;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private FoodCategory foodCategory;

    public void setMember(Member member) {
        if (this.member != null) //prefer가 갖고 있는 member가 null이 아니면
            member.getMemberPreferList().remove(this); //멤버의 preferlist에 현재 객체가 실행한 memberPrefer가 있다면 삭제
        this.member = member; // prefer의 멤버를 객체로 들어온 member로 setting 해줌.
        member.getMemberPreferList().add(this); // 그리고 중복되지 않게 다시 add 해줌
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }
}
