package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tbl_reservation")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {
	
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int no;

    @Column(length = 20, nullable = false)
    String guest_name;

    @Column(length = 20, nullable = true)
    String guest_phone; 

    @Column(nullable = false)
    int room_no;
    
    @Column(nullable = false)
    LocalDate check_in_date;

}
