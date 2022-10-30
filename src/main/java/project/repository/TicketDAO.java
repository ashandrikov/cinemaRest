package project.repository;

import org.springframework.stereotype.Repository;
import project.model.Seat;

import java.util.Map;

@Repository
public interface TicketDAO {

    Map<String, Seat> getTicketList();
    void addTicketToList(String token, Seat seat);

    void removeTicketFromListByToken(String token);
}
