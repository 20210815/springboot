package umc.spring.web.dto;

import lombok.*;

import java.time.LocalDateTime;

public class StoreResponseDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    public static class createStoreResultDTO {
        Long id;
        LocalDateTime createdAt;
    }
}
