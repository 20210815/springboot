package umc.springboot.service.StoreService;

import org.springframework.data.domain.Page;
import umc.springboot.domain.Review;
import umc.springboot.domain.Store;
import umc.springboot.web.dto.ReviewResponseDTO;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);

    Page<Review> getReviewList(Long StoreId, Integer page);

    ReviewResponseDTO.ReviewPreviewListDTO getReviewDtoList(Page<Review> reviews);
}
