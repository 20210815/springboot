package umc.spring.web.dto;

import lombok.*;

public class StoreRequestDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    public static class createStoreDTO{
        String name;
        String address;
        Float score;
        Long regionId;
    }
}
