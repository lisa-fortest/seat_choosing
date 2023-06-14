package com.example.seat_choosingmain.Model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.seat_choosingmain.Model.Seat;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface SeatRepository extends CrudRepository<Seat, Integer> {
	@Query("SELECT s.floorSeatSEQ, s.floorNO, s.seatNO, e.EmpID FROM Employee e RIGHT JOIN Seat s ON s.floorSeatSEQ = e.floorSeatSEQ")
	List<Object[]> findAllSeat();
}