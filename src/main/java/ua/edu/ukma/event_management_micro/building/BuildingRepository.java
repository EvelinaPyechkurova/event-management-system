package ua.edu.ukma.event_management_micro.building;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long> {
    BuildingEntity findByAddressContaining(String address);
    List<BuildingEntity> findAllByCapacity(int capacity);
}