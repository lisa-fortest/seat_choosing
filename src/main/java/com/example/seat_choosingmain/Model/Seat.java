package com.example.seat_choosingmain.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Seat {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer floorSeatSEQ;

  private Integer floorNO;

  private Integer seatNO;

  public Integer getFloorSeatSEQ() {
    return floorSeatSEQ;
  }

  public void setFloorSeatSEQ(Integer floorSeatSEQ) {
    this.floorSeatSEQ = floorSeatSEQ;
  }
  
  public Integer getFloorNO() {
    return floorNO;
  }

  public void setFloorNO(Integer floorNO) {
    this.floorNO = floorNO;
  }
  
  public Integer getSeatNO() {
    return seatNO;
  }

  public void setSeatNO(Integer seatNO) {
    this.seatNO = seatNO;
  }


}
