package ua.edu.ukma.event_management_micro.building.api;

import org.springframework.stereotype.Component;
import ua.edu.ukma.event_management_micro.building.BuildingEntity;
import ua.edu.ukma.event_management_micro.building.BuildingService;

import java.util.Optional;

@Component
public class BuildingInternalApiImpl implements BuildingInternalApi{

    private final BuildingService buildingService;

    public BuildingInternalApiImpl(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @Override
    public BuildingEntity ensureBuildingExists(BuildingEntity building) {
        return buildingService.ensureBuildingExists(building);
    }
}
