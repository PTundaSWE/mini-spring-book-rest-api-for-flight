package org.paul.flightapi.service;

import org.paul.flightapi.model.Flight;
import org.paul.flightapi.repository.IFlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    private final IFlightRepository repo;

    public FlightService(IFlightRepository repo) {
        this.repo = repo;
    }

    public Flight addFlight(Flight flight) {
        return repo.save(flight);
    }

    public Flight updateFlight(Long id, Flight updated) {
        Optional<Flight> existingOpt = repo.findById(id);
        if (existingOpt.isEmpty()) {
            return null; // or throw custom exception
        }

        Flight existing = existingOpt.get();
        existing.setDepartureCity(updated.getDepartureCity());
        existing.setArrivalCity(updated.getArrivalCity());

        return repo.save(existing);
    }

    public List<Flight> getAllFlights() {
        return repo.findAll();
    }

    public Flight getFlightById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteFlight(Long id) {
        repo.deleteById(id);
    }

    public List<Flight> getFlightsFromCityToCity(String departure, String arrival) {
        return repo.findByDepartureCityAndArrivalCity(departure, arrival);
    }
}
