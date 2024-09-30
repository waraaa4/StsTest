package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.entity.Reservation;

public interface ReservationService {

	// 게시물 등록 메소드
	int register(ReservationDTO dto);

	List<ReservationDTO> getList();

	// 게시물 상세조회 메소드
	ReservationDTO read(int no);
	
	default Reservation dtoToEntity(ReservationDTO dto) {
		Reservation entity = Reservation.builder()
				.no(dto.getNo())
				.guest_name(dto.getGuest_name())
				.guest_phone(dto.getGuest_phone())
				.room_no(dto.getRoom_no())
				.check_in_date(dto.getCheck_in_date())
				.build();
		return entity;
	}
	default ReservationDTO entityToDTO(Reservation entity) {
		ReservationDTO dto = ReservationDTO.builder()
				.no(entity.getNo())
				.guest_name(entity.getGuest_name())
				.guest_phone(entity.getGuest_phone())
				.room_no(entity.getRoom_no())
				.check_in_date(entity.getCheck_in_date())
				.build();
		return dto;
	}

}
