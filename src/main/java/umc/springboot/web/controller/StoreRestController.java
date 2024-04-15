package umc.springboot.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.springboot.apiPayload.ApiResponse;
import umc.springboot.converter.StoreConverter;
import umc.springboot.domain.Store;
import umc.springboot.service.StoreService.StoreCommandService;
import umc.springboot.web.dto.StoreRequestDTO;
import umc.springboot.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.createStoreResultDTO> createStore(StoreRequestDTO.createStoreDTO request){
        Store store = storeCommandService.createStore(request);
        return ApiResponse.onSuccess(StoreConverter.toStore(store));
    }
}
