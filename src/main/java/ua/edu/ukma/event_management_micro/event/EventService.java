package ua.edu.ukma.event_management_micro.event;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import ua.edu.ukma.event_management_micro.building.api.BuildingApi;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EventService {

    private final ModelMapper modelMapper;
    private final EventRepository eventRepository;
    private final BuildingApi buildingApi;

    @Autowired
    public EventService(ModelMapper modelMapper, EventRepository eventRepository, BuildingApi buildingApi) {
        this.modelMapper = modelMapper;
        this.eventRepository = eventRepository;
        this.buildingApi = buildingApi;
    }

    public List<EventDto> getAllEvents(){
        return eventRepository.findAll()
                .stream()
                .map(this::toDomain)
                .toList();
    }

    public EventDto getEventById(long eventId) {
        return toDomain(eventRepository.findById(eventId)
                .orElseThrow());
    }

    public List<EventDto> getAllEventsByTitle(String title) {
        return eventRepository.findAllByEventTitle(title)
                .stream()
                .map(this::toDomain)
                .toList();
    }

    public void createEvent(EventDto event) {
        // Ensures the building with such id exists before saving the event
        EventEntity toSave = toEntity(event);
        Long buildingId = event.getBuildingId();
        if (buildingId != null && buildingApi.buildingExists(buildingId)) {
            eventRepository.save(toSave);
        } else {
            throw new NoSuchElementException("Building with id " + buildingId + " not found");
        }
    }

    public void updateEvent(Long id, EventDto updatedEvent) {
        Optional<EventEntity> existingEventOpt = eventRepository.findById(id);

        if (existingEventOpt.isPresent()) {
            Long buildingId = updatedEvent.getBuildingId();
            if (buildingId != null && buildingApi.buildingExists(buildingId)) {
                EventEntity existingEvent = existingEventOpt.get();
                existingEvent.setEventTitle(updatedEvent.getEventTitle());
                existingEvent.setDateTimeStart(updatedEvent.getDateTimeStart());
                existingEvent.setDateTimeEnd(updatedEvent.getDateTimeEnd());
                existingEvent.setImage(updatedEvent.getImage());
                existingEvent.setDescription(updatedEvent.getDescription());
                existingEvent.setNumberOfTickets(updatedEvent.getNumberOfTickets());
                existingEvent.setMinAgeRestriction(updatedEvent.getMinAgeRestriction());
                existingEvent.setPrice(updatedEvent.getPrice());
                existingEvent.setDescription(updatedEvent.getDescription());
                existingEvent.setNumberOfTickets(updatedEvent.getNumberOfTickets());
                existingEvent.setMinAgeRestriction(updatedEvent.getMinAgeRestriction());

                eventRepository.save(existingEvent);
            }
        }
    }

    public void deleteEvent(long eventId) {
        eventRepository.deleteById(eventId);
    }

    public List<EventDto> getAllRelevant() {
        return eventRepository.findEventEntitiesByDateTimeEndAfter(LocalDateTime.now())
                .stream()
                .map(this::toDomain)
                .toList();
    }

    public List<EventDto> getAllForOrganizer(Long organizerId) {
        return eventRepository.findEventEntitiesByCreatorId(organizerId)
                .stream()
                .map(this::toDomain)
                .toList();
    }

    public List<EventDto> getAllThatIntersect(LocalDateTime start, LocalDateTime end, long id) {
        return eventRepository.findEventEntitiesByBuildingIdAndDateTimeEndAfterAndDateTimeStartBefore(id, start, end)
                .stream()
                .map(this::toDomain)
                .toList();
    }

    private EventDto toDomain(EventEntity event){
        return modelMapper.map(event, EventDto.class);
    }

    private EventEntity toEntity(EventDto event){
        return modelMapper.map(event, EventEntity.class);
    }

}