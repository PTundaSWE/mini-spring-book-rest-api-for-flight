package org.paul.flightapi.controller;

import org.paul.flightapi.model.Flight;
import org.paul.flightapi.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    private final FlightService service;

    public FlightController(FlightService service) {
        this.service = service;
    }

    // GET /api/flights
    @GetMapping
    public List<Flight> getAllFlights() {
        return service.getAllFlights();
    }

    // GET /api/flights/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
        Flight flight = service.getFlightById(id);
        if (flight == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(flight);
    }

    // POST /api/flights
    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        Flight saved = service.addFlight(flight);
        return ResponseEntity.status(201).body(saved);
    }

    // PUT /api/flights/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id,
                                               @RequestBody Flight flight) {
        Flight updated = service.updateFlight(id, flight);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    // DELETE /api/flights/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        service.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }

    // GET /api/flights/search?from=PIT&to=NYC
    @GetMapping("/search")
    public List<Flight> searchFlights(@RequestParam("from") String from,
                                      @RequestParam("to") String to) {
        return service.getFlightsFromCityToCity(from, to);
    }
}
