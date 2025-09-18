package ua.edu.ukma.event_management_micro.building;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ua.edu.ukma.event_management_micro.user.UserDto;
import ua.edu.ukma.event_management_micro.user.UserEntity;

import java.util.List;

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
        return buildingRepository.save(dtoToEntity(building));
    }

//    public List<Building> getAllBuildings() {
//        return List.of();
//    }
//
//    public Building getBuildingById(Long id) {
//        return null;
//    }

    public void updateBuilding(Long id, BuildingDto updatedBuilding) {

    }

    public void deleteBuilding(Long id) {

    }


//    public List<Building> getAllByCapacity(int capacity) {
//        return List.of();
//    }


    private BuildingDto toDomain(BuildingEntity building) {
        return modelMapper.map(building, BuildingDto.class);
    }

    private BuildingEntity dtoToEntity(BuildingEntity buildingDto) {
        return modelMapper.map(buildingDto, BuildingEntity.class);
    }
}
