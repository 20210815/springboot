package umc.spring.repository;

import org.hibernate.query.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Region;
import umc.spring.domain.Review;
import umc.spring.domain.Store;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
