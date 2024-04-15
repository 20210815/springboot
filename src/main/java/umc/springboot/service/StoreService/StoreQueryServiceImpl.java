package umc.springboot.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springboot.converter.ReviewConverter;
import umc.springboot.domain.Review;
import umc.springboot.domain.Store;
import umc.springboot.repository.ReviewRepository;
import umc.springboot.repository.StoreRepository;
import umc.springboot.web.dto.ReviewResponseDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {
        return reviewRepository.findAllByStoreId(StoreId, PageRequest.of(page, 10));

    }

    public ReviewResponseDTO.ReviewPreviewListDTO getReviewDtoList(Page<Review> reviews) {
        return ReviewConverter.reviewPreViewListDTO(reviews);
    }
}
