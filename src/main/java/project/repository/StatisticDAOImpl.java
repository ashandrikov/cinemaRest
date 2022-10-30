package project.repository;

import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class StatisticDAOImpl implements StatisticDAO {
    private int currentIncome;
    private int numberOfAvailableSeats;
    private int numberOfPurchasedTickets;

    @Override
    public void initialize(int size){
        numberOfAvailableSeats = size;
    }

    @Override
    public Map<String, Integer> getStats(){
        Map<String, Integer> statsMap = new LinkedHashMap<>();
        statsMap.put("current_income", currentIncome);
        statsMap.put("number_of_available_seats", numberOfAvailableSeats);
        statsMap.put("number_of_purchased_tickets", numberOfPurchasedTickets);
        return statsMap;
    }

    @Override
    public void changeStats(int income, int available, int purchased){
        currentIncome += income;
        numberOfAvailableSeats += available;
        numberOfPurchasedTickets += purchased;
    }
}
