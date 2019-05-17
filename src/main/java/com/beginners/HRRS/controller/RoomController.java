package com.beginners.HRRS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.beginners.HRRS.model.Room;
import com.beginners.HRRS.service.RoomService;

@Controller
@RequestMapping("/admin/room")
public class RoomController {
	
	@Autowired RoomService roomService;
	
	@GetMapping("/add")
	public String addRoomPage(Model model) {
		model.addAttribute("room", "true");//this will be used for breadcrumb need to edit in the menu bar ..... do it later..
		return "admin/room";
	}
	
	@PostMapping("/add")
	public String addRoom(@RequestParam("rtype") String type,
						  @RequestParam("rimage") MultipartFile image,
						  @RequestParam("rdescription") String description,
						  @RequestParam("rrate") double rate,
						  @RequestParam("rstatus") boolean status,
						  Model model) {//try for next model to match form name and model properties name and use @ModelAttribute....(not @RequestBody and @ResponseBody .....)
		Room room = new Room();
		
		//making multipart file name into string and removing all unwanted \ using substring
		String imagename = image.getOriginalFilename();
		String imageName = imagename.substring(imagename.lastIndexOf("\\")+1);
		
		//upload the image file into folder then...
		if(!roomService.uploadImage(image)) {
			model.addAttribute("uploadError", "Image upload Failure!! Please Choose an image again");
			return "admin/room";
		}
		
		//add the information into database and return boolean value and send a notification to the room page....
		room.setType(type);
		room.setImage(imageName);
		room.setDescription(description);
		room.setRate(rate);
		room.setStatus(status);
		
		if(!roomService.saveRoomInfo(room)) {
			model.addAttribute("saveError", "Room information failed to save!!");
			return "admin/room";
		}else {
			model.addAttribute("congrulation", "Room information saved");
			return "admin/room";
//			return "redirect:/admin/room/display#ShowRooms";
		}
	}
	
	@GetMapping("/display")
	public String displayRoomInfo(Model model) {
		model.addAttribute("rooms", roomService.getAllRoomInfo());
		return "admin/room";
	}
	
	@GetMapping("/edit/{id}")
	public String editPage(@PathVariable("id") int id, Model model) {
		model.addAttribute("room", roomService.getRoomById(id));
		model.addAttribute("edit", "true");
		return "admin/room";
	}
	
	@PostMapping("/update")
	public String updateRoomInformation(@RequestParam("rid") int id,
										@RequestParam("rtype") String type,
										@RequestParam("rimage") MultipartFile image,
										@RequestParam("rdescription") String description,
										@RequestParam("rrate") double rate,
										@RequestParam("rstatus") boolean status,
										Model model) {
		
		Room room = new Room();
		
		String imagename = image.getOriginalFilename();
		String imageFileName = imagename.substring(imagename.lastIndexOf("\\")+1);
		
		if(!roomService.uploadImage(image)) {
			model.addAttribute("uploadError", "Image upload Failure!! Please Choose an image again");
			return "admin/room";
		}
		
		room.setId(id);
		room.setType(type);
		room.setImage(imageFileName);
		room.setDescription(description);
		room.setRate(rate);
		room.setStatus(status);
		
		if(!roomService.updateRoomInfo(room)) {
			model.addAttribute("saveError", "Room information failed to Update!!");
			return "admin/room";
		}else {
			return "redirect:/admin/room/display#ShowRooms";
		}
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteRoom(@PathVariable("id") int id, Model model) {
		Room room = roomService.getRoomById(id);
		roomService.deleteRoomInfo(room);
		return "redirect:/admin/room/display#ShowRooms";
	}
}
