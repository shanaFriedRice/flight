package com.capgemini.flight.rest;

import com.capgemini.flight.model.Flight;
import com.capgemini.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping
    public ResponseEntity<Flight> create(@RequestBody Flight newFlight){

        this.flightService.save(newFlight);
        return new ResponseEntity<Flight>(newFlight, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<Flight> findById(@PathVariable long id) {
        Optional<Flight> result = this.flightService.findById(id);
        if (result.isPresent()){
            return new ResponseEntity<Flight>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id){
        this.flightService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
