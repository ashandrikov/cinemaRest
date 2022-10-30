package project.repository;

import org.springframework.stereotype.Repository;
import project.model.Seat;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TicketDAOImpl implements TicketDAO{
    private Map<String, Seat> tokenSeatList = new HashMap<>();

    public Map<String, Seat> getTicketList(){
        return tokenSeatList;
    }

    @Override
    public void addTicketToList(String token, Seat seat){
        tokenSeatList.put(token, seat);
    }

    @Override
    public void removeTicketFromListByToken(String token){
        tokenSeatList.remove(token);
    }
}
