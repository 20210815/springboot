package umc.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springboot.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
