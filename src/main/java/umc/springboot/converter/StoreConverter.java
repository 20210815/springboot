package umc.springboot.converter;

import umc.springboot.domain.Store;
import umc.springboot.web.dto.StoreRequestDTO;
import umc.springboot.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {
    // DTO => 객체
    public static Store createStore(StoreRequestDTO.createStoreDTO request) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(0F)
                .build();
    }


    // 객체 다 만듦 response
    public static StoreResponseDTO.createStoreResultDTO toStore(Store store) {
        return StoreResponseDTO.createStoreResultDTO.builder()
                .id(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
