package com.beginners.HRRS.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.beginners.HRRS.model.Room;

public interface RoomService {
	
	public boolean uploadImage(MultipartFile image);
	
	public boolean saveRoomInfo(Room room);
	
	public List<Room> getAllRoomInfo();
	
	public Room getRoomById(int id);
	
	public boolean updateRoomInfo(Room room);
	
	public void deleteRoomInfo(Room room);
}
