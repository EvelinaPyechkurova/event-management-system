package ua.edu.ukma.event_management_micro.building;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class BuildingService {

    private ModelMapper modelMapper;
    private BuildingRepository buildingRepository;

    @Autowired
    void setModelMapper(@Lazy ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    void setUserRepository(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public BuildingDto createBuilding(BuildingDto building) {
        return toDomain(buildingRepository.save(dtoToEntity(building)));
    }

    public List<BuildingDto> getAllBuildings() {
        return buildingRepository.findAll()
                .stream()
                .map(this::toDomain)
                .toList();
    }

    public BuildingDto getBuildingById(Long id) {
        return toDomain(buildingRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Building not found: " + id)));
    }

    public void updateBuilding(Long id, BuildingDto updatedBuilding) {
        Optional<BuildingEntity> existingBuilding = buildingRepository.findById(id);
        if (existingBuilding.isPresent()) {
            BuildingEntity building = existingBuilding.get();
            building.setAddress(updatedBuilding.getAddress());
            building.setHourlyRate(updatedBuilding.getHourlyRate());
            building.setAreaM2(updatedBuilding.getAreaM2());
            building.setCapacity(updatedBuilding.getCapacity());
            building.setDescription(updatedBuilding.getDescription());
            buildingRepository.save(building);
        }
    }

    public void deleteBuilding(Long id) {
        buildingRepository.deleteById(id);
    }

    public List<BuildingDto> getAllByAddressContaining(String address) {
        return buildingRepository.findAllByAddressContaining(address)
                .stream()
                .map(this::toDomain)
                .toList();
    }

    public List<BuildingDto> getAllByCapacity(int capacity) {
        return buildingRepository.findAllByCapacity(capacity)
                .stream()
                .map(this::toDomain)
                .toList();
    }

    private BuildingDto toDomain(BuildingEntity building) {
        return modelMapper.map(building, BuildingDto.class);
    }

    private BuildingEntity dtoToEntity(BuildingDto buildingDto) {
        return modelMapper.map(buildingDto, BuildingEntity.class);
    }
}
