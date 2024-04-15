package umc.springboot.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.springboot.domain.common.BaseEntity;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="region_id")
    private Region region;


    public Float setScore(List<Review> reviews) {
        List<Float> scoreList = reviews.stream()
                .map(Review::getScore)
                .collect(Collectors.toList());

        // 점수 목록이 비어있는지 확인하고, 비어 있으면 null 반환
        if (scoreList.isEmpty()) {
            return null;
        }

        // 점수 목록의 평균 계산
        float averageScore = (float) scoreList.stream()
                .mapToDouble(Float::doubleValue)
                .average()
                .orElse(0.0);

        return averageScore;
    }
}
