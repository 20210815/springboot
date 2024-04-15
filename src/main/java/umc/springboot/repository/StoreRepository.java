package umc.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springboot.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
