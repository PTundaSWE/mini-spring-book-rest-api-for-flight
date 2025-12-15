package org.paul.flightapi.repository;

import org.paul.flightapi.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFlightRepository extends JpaRepository<Flight, Long>{

    // Custom finder
    List<Flight> findByDepartureCityAndArrivalCity(String departureCity, String arrivalCity);

}
