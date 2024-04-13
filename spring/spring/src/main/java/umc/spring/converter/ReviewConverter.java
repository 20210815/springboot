package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.web.dto.MemberResponseDTO;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {
    // 객체 -> DTO
    public static ReviewResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review) {
        return ReviewResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();

    }


    // DTO -> 객체
    public static Review toCreateReview(ReviewRequestDTO.CreateReviewDTO request) {
        return Review.builder()
                .title(request.getTitle())
                .body(request.getBody())
                .score(request.getScore())
                .build();
    }

}
