package umc.springboot.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springboot.converter.ReviewConverter;
import umc.springboot.domain.Review;
import umc.springboot.repository.MemberRepository;
import umc.springboot.repository.ReviewRepository;
import umc.springboot.repository.StoreRepository;
import umc.springboot.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    @Override
    @Transactional
    public Review createReview(ReviewRequestDTO.CreateReviewDTO request) {
        Review review = ReviewConverter.toCreateReview(request);
        review.setMember(memberRepository.findById(request.getMemberId()).get());
        review.setStore(storeRepository.findById(request.getStoreId()).get());
        reviewRepository.save(review);

        //System.out.println(review.getMember().getReviewList());
        return review;
    }
}
