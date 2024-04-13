package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    @Override
    @Transactional
    public Review createReview(ReviewRequestDTO.CreateReviewDTO request) {
        Review review = ReviewConverter.toCreateReview(request);
        review.setMember(memberRepository.findById(request.getMemberId()).get());
        reviewRepository.save(review);
        //System.out.println(review.getMember().getReviewList());
        return review;
    }
}
