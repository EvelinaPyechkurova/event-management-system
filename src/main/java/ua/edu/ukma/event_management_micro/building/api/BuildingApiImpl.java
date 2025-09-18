package ua.edu.ukma.event_management_micro.building.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.edu.ukma.event_management_micro.building.BuildingEntity;
import ua.edu.ukma.event_management_micro.building.BuildingService;

@Component
public class BuildingApiImpl implements BuildingApi {

    private final BuildingService buildingService;

    @Autowired
    public BuildingApiImpl(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @Override
    public boolean buildingExists(Long buildingId) {
        return buildingService.buildingExists(buildingId);
    }

    @Override
    public Integer buildingCapacity(Long buildingId) {
        return buildingService.getBuildingById(buildingId).getCapacity();
    }
}
