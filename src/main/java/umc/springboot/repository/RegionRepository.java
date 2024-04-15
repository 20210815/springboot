package umc.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springboot.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
