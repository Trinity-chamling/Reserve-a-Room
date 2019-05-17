package com.beginners.HRRS.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.beginners.HRRS.Repository.RoomRepository;
import com.beginners.HRRS.model.Room;
import com.beginners.HRRS.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired RoomRepository roomRepository;
	
	private static final String UPLOAD_DIR = "C:\\Users\\test\\Desktop\\HRRS"; 

	@Override
	public boolean uploadImage(MultipartFile image) {
		boolean status = false;
		//upload the multipart file image into a directory...
		
		File dir = new File(UPLOAD_DIR + File.separator + "rooms");
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
//		String fileName = StringUtils.cleanPath(image.getOriginalFilename());
		String fileName = image.getOriginalFilename();
		String uploadFileName = fileName.substring(fileName.lastIndexOf("\\")+1);
		
		
//		String fileName = getFileName(image);
		System.out.println(fileName);
		System.out.println(uploadFileName);
		File uploadDir = new File(dir + File.separator + uploadFileName);
		System.out.println(uploadDir);
		
		try {
			image.transferTo(uploadDir);
			status = true;
			
		}catch(IOException | IllegalStateException ee) {
			System.out.println(ee);
		}
		
		return status;
	}

	@Override
	public boolean saveRoomInfo(Room room) {
		boolean status = false;
		
		if(roomRepository.save(room) != null) {
			status = true;
		}
		return status;
	}

	@Override
	public List<Room> getAllRoomInfo() {
		List<Room> rooms = roomRepository.findAll();
		return rooms;
	}

	@Override
	public Room getRoomById(int id) {
		Room room = roomRepository.findById(id);
		return room;
	}

	@Override
	public boolean updateRoomInfo(Room room) {
		boolean status = false;
		
		if(roomRepository.save(room) != null) {
			status = true;
		}
 		return status;
	}

	@Override
	public void deleteRoomInfo(Room room) {
		roomRepository.delete(room);
	}
	
//	private String getFileName(MultipartFile part) {
//		String conDis = part.getName();
////		InputStream conDis =part.getInputStream(); //((Part) part).getHeader("content-disposition");
//		System.out.println(conDis);
////		String[] items = conDis.split(";");
////		
////		for(String st:items) {
////			
////			if(st.trim().startsWith("filename")) {
////				String filename = st.substring(st.indexOf("=")+2, st.length()-1);
////				
////				return filename;
////			}
////		}
//		return "";
//	}
//	private String getFileName(MultipartFile part) {
//		InputStream conDis =part.getInputStream(); //((Part) part).getHeader("content-disposition");
//		System.out.println(conDis);
//		String[] items = conDis.split(";");
//		
//		for(String st:items) {
//			
//			if(st.trim().startsWith("filename")) {
//				String filename = st.substring(st.indexOf("=")+2, st.length()-1);
//				
//				return filename;
//			}
//		}
//		return "";
//	}

}
