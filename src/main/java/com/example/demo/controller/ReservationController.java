package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	ReservationService service;

	@GetMapping("/list")
	public void list(Model model) {
		List<ReservationDTO> list = service.getList();

		model.addAttribute("list", list);
	}
	
	@GetMapping("/register")
	public void register() {

	}

	@PostMapping("/register")
	public String registerPost(ReservationDTO dto, 
			RedirectAttributes redirectAttributes) {

		int no = service.register(dto);

		redirectAttributes.addFlashAttribute("no", no);

		return "redirect:/reservation/list";
	}
	
	@GetMapping("/read")
	public String read(@RequestParam(name = "no") int no, Model model) {
	    ReservationDTO dto = service.read(no);

	    model.addAttribute("dto", dto);
	    
	    return "reservation/read"; 
	}

}
