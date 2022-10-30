package project.repository;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface StatisticDAO {

    void initialize(int size);
    Map<String, Integer> getStats();

    void changeStats(int income, int available, int purchased);
}
