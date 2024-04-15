package umc.springboot.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.springboot.converter.StoreConverter;
import umc.springboot.domain.Store;
import umc.springboot.repository.RegionRepository;
import umc.springboot.repository.ReviewRepository;
import umc.springboot.repository.StoreRepository;
import umc.springboot.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final RegionRepository regionRepository;
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;

    @Override
    public Store createStore(StoreRequestDTO.createStoreDTO request) {
        Store store = StoreConverter.createStore(request);
        store.setRegion(regionRepository.findById(request.getRegionId()).get());
        storeRepository.save(store);
        return store;
    }
}
