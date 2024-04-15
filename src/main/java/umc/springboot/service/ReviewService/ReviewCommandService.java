package umc.springboot.service.ReviewService;

import umc.springboot.domain.Review;
import umc.springboot.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {

    Review createReview(ReviewRequestDTO.CreateReviewDTO request);
}
