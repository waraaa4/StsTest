package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Reservation;

@SpringBootTest
public class ReservationTest {

	@Autowired
	ReservationRepository repository;
	
	@Test // 단위테스트
	void 리파지토리빈_확인() {
		System.out.println("repository:" + repository);
	}
	
	@Test
	void 게시물등록() {
		Reservation reservation = Reservation.builder()
						.guest_name("1")
						.guest_phone("111")
						.room_no(1)
						.check_in_date(LocalDate.of(2024, 1, 1))
						.build();
		repository.save(reservation);
	}

	@Test
	void 게시물목록조회() {
		List<Reservation> list = repository.findAll();
		for(Reservation reservation : list) {
			System.out.println(reservation);
		}
	}
	
	@Test
	void 게시물단건조회() {
		Optional<Reservation> result = repository.findById(1);
		if(result.isPresent()) {
			Reservation reservation = result.get();
			System.out.println(reservation);
		}
	}

	@Test
	void 게시물수정() {
		//1번 게시물이 존재하는지 확인
		Optional<Reservation> result = repository.findById(2);
		
		Reservation reservation = result.get();
		
		//일부 내용 수정
		reservation.setGuest_name("내용수정");
		
		//데이터 업데이트
		repository.save(reservation);
	}
	
	@Test
	void 게시물삭제() {
		repository.deleteById(1);
	}
	
}
