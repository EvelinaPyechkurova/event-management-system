package ua.edu.ukma.event_management_micro.ticket;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import ua.edu.ukma.event_management_micro.user.api.UserInternalApi;


import java.util.List;
import java.util.Optional;


@Service
public class TicketService {

    private ModelMapper modelMapper;
    private UserInternalApi userInterface;
//    private EventService eventService;
    private TicketRepository ticketRepository;

//    @Autowired
//    public void setEventService(EventService eventService) {
//        this.eventService = eventService;
//    }

    @Autowired
    public void setUserInterface(UserInternalApi userInterface) {
        this.userInterface = userInterface;
    }

    @Autowired
    void setModelMapper(@Lazy ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    void setTicketRepository(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public boolean createTicket(TicketDto ticket) {
        TicketEntity ticketEntity = modelMapper.map(ticket, TicketEntity.class);

        if (!(userInterface.validateUserExists(ticketEntity.getOwner()) || false)) {
            return false;
        };

        //TODO: check if  event exists and isnt full


        ticketRepository.save(ticketEntity);

        return true;
    }

    public List<TicketDto> getAllTickets() {
        return ticketRepository.findAll()
                .stream()
                .map(a -> modelMapper.map(a, TicketDto.class))
                .toList();
    }

    public Optional<TicketDto> getTicketById(long ticketId) {
        return ticketRepository.findById(ticketId)
                .map(a -> modelMapper.map(a, TicketDto.class));
    }

    public void removeTicket(long ticketId) {
        ticketRepository.deleteById(ticketId);
    }

    public List<TicketDto> getAllTicketsForUser(Long user) {
        return ticketRepository
                .findAllByUserId(user)
                .stream()
                .map(a -> modelMapper.map(a, TicketDto.class)).toList();
    }

    public List<TicketDto> getAllTicketsCreatedByUser(long user) {
        return ticketRepository
                .findTicketEntitiesByEvent_Creator_Id(user)
                .stream()
                .map(a -> modelMapper.map(a, TicketDto.class))
                .toList();
    }

}
