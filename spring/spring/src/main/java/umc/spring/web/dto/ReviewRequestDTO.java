package umc.spring.web.dto;

import lombok.Getter;

public class ReviewRequestDTO {

    //리뷰를 만들겠다.
    @Getter
    public static class CreateReviewDTO {
        String title;
        Float score;
        String body;
        Long memberId;
        Long storeId;
    }
}
