package com.example.seat_choosingmain.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Employee {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer EmpID;

  private String name;

  private String email;
  
  private Integer floorSeatSEQ;

  public Integer getEmpId() {
    return EmpID;
  }

  public void setEmpId(Integer EmpID) {
    this.EmpID = EmpID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

public Integer getFloorSeatSEQ() {
    return floorSeatSEQ;
  }

  public void setFloorSeatSEQ(Integer floorSeatSEQ) {
    this.floorSeatSEQ = floorSeatSEQ;
  }
}