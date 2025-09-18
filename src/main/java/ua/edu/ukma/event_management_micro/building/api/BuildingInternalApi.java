package ua.edu.ukma.event_management_micro.building.api;

import ua.edu.ukma.event_management_micro.building.BuildingEntity;

public interface BuildingInternalApi {
    BuildingEntity ensureBuildingExists(BuildingEntity building);
}
