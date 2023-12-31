package com.example.seat_choosingmain.Controller;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.seat_choosingmain.Model.*;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController // This means that this class is a Controller
@CrossOrigin(origins="http://localhost:8081")
@RequestMapping(path="/seat") // This means URL's start with /seat (after Application path)
public class SeatController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private SeatRepository seatRepository;

  //列出座位狀態
  @GetMapping(path="/all")
  public @ResponseBody List<HashMap<String, Object>> getAllSeats() {
    // This returns a JSON or XML with the users
	  List<HashMap<String, Object>> seat_results = new ArrayList<>();
	  List<Object[]> all_seats = seatRepository.findAllSeat();
	  for (Object[] all_seat : all_seats) {
	    HashMap<String, Object> seat_result = new HashMap<String, Object>();
	    seat_result.put("floorSeatSEQ", all_seat[0]);
	    seat_result.put("floorNO", all_seat[1]);
	    seat_result.put("seatNO", all_seat[2]);
	    seat_result.put("EmpID", all_seat[3]);
	    seat_results.add(seat_result);
	}
//	  for (Object[] all_seat : all_seats) {
//		  seat.put()
//	  }
	  return seat_results;
//    return seatRepository.findAll();
  }
  
}