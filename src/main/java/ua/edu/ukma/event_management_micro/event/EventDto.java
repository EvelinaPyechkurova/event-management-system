package ua.edu.ukma.event_management_micro.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class EventDto {
    private int id;
    private String eventTitle;
    private LocalDateTime dateTimeStart;
    private LocalDateTime dateTimeEnd;
    private Long buildingId;
    private String description;
    private int numberOfTickets;
    private int minAgeRestriction;
    private List<Long> rating;
//    private List<UserDto> users;
    private byte[] image;
    private Long creatorId;
    private double price;
}