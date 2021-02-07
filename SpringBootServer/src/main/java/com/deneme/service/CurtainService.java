package com.deneme.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.deneme.Model.Curtain;
import com.deneme.Model.Light;
import com.deneme.Model.Room;
import com.deneme.Model.DTO.RoomDTO;
import com.deneme.Repository.CurtainRepository;
import com.deneme.Repository.LightRepository;
import com.deneme.Repository.RoomRepository;



@Service
public class CurtainService {
	@Autowired
	private CurtainRepository repo;
	
	@Autowired
	private RoomRepository repoRoom;
	
	public List<Curtain> listAll(){
		return repo.findAll();
		
	}
	
	public void save (Curtain curtain) {
		repo.save(curtain);
	}
	
	public Curtain get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	public List<RoomDTO> findCurtainsWithRooms() {
		ArrayList<Curtain> curtains = (ArrayList<Curtain>) repo.findAll();
		ArrayList<Room> rooms = (ArrayList<Room>) repoRoom.findAll();
		Map<Object, List<Curtain>> groupedCurtains =
				curtains.stream().collect(Collectors.groupingBy(l -> l.getRoomId()));
		List<RoomDTO> list = new ArrayList();
		for(Room room: rooms) {
			RoomDTO dto = new RoomDTO();
			dto.setRoom(room);
			ArrayList<Curtain> roomsCurtains = (ArrayList<Curtain>) groupedCurtains.get(room.getId()) != null ? (ArrayList<Curtain>) groupedCurtains.get(room.getId()) : new ArrayList();
			dto.setCurtains(roomsCurtains);
			list.add(dto);
		}
		return list;
	}
	
	public Optional<Curtain> findById(int id) {
		return repo.findById(id);
	}

	
	
	
	
}
