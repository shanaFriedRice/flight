package com.capgemini.flight.persistence;

import com.capgemini.flight.model.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {

    Iterable<Flight> findAllByOrderByNameAsc();

}
