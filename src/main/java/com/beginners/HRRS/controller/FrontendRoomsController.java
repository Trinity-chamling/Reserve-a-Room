package com.beginners.HRRS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beginners.HRRS.service.RoomService;

@Controller
public class FrontendRoomsController {
	
	@Autowired
	private RoomService roomService;
	
	@RequestMapping(value="/presidential_rooms", method=RequestMethod.GET)
	public String showPresedentialRooms(Model model) {
		model.addAttribute("proom",roomService.getAllRoomInfo());
		return "frontend/hotel_rooms";
	}
}
