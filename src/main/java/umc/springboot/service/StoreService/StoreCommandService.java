package umc.springboot.service.StoreService;

import umc.springboot.domain.Store;
import umc.springboot.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Store createStore(StoreRequestDTO.createStoreDTO request);
}
