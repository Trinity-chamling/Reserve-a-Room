package com.beginners.HRRS.Repository;

import java.util.List;
import org.springframework.data.repository.Repository;

import com.beginners.HRRS.model.Room;

//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Repository;

//@Repository
//@Transactional
//spring boot has already made Repositary and jpaReposotory an interface to access the dao methods.....
public interface RoomRepository extends Repository <Room, Integer> {
	
	Room save(Room room);
	
	List<Room> findAll();
	
	Room findById(int id);
	
	void delete(Room room);
}
