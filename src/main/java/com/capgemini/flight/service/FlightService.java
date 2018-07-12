package com.capgemini.flight.service;

import com.capgemini.flight.model.Flight;
import com.capgemini.flight.persistence.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @PostConstruct
    public void addSomeDummyFlight() {
        for (int i = 1; i < 11; i++) {
            Flight flight = new Flight();
            flight.setSerialNumber(i);
            flight.setModel("A00"+i);
            flight.setName("Flgiht"+i);

            this.flightRepository.save(flight);
        }
    }

    @Transactional
    public Flight save(Flight f){
        this.flightRepository.save(f);
        return f;
    }

    public Iterable<Flight> findAll(){
        return this.flightRepository.findAll();
    }

    public Optional<Flight> findById(long id){
        return this.flightRepository.findById(id);
    }

    public Flight findByName(String name) {
        return this.flightRepository.findByName(name);
    }

    @Transactional
    public void deleteById(long id) {
        this.flightRepository.deleteById(id);
    }

}
