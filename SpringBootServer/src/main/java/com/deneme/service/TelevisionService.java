package com.deneme.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.deneme.Model.AirConditioner;
import com.deneme.Model.Light;
import com.deneme.Model.Room;
import com.deneme.Model.Television;
import com.deneme.Model.DTO.RoomDTO;
import com.deneme.Repository.AirConditionerRepository;
import com.deneme.Repository.LightRepository;
import com.deneme.Repository.RoomRepository;
import com.deneme.Repository.TelevisionRepository;



@Service
public class TelevisionService {
	@Autowired
	private TelevisionRepository repo;
	
	@Autowired
	private RoomRepository repoRoom;
	
	public List<Television> listAll(){
		return repo.findAll();
		
	}
	
	public void save (Television television) {
		repo.save(television);
	}
	
	public Television get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	public List<RoomDTO> findTvsWithRooms() {
		ArrayList<Television> tvs = (ArrayList<Television>) repo.findAll();
		ArrayList<Room> rooms = (ArrayList<Room>) repoRoom.findAll();
		Map<Object, List<Television>> groupedtvs =
				tvs.stream().collect(Collectors.groupingBy(l -> l.getRoomId()));
		List<RoomDTO> list = new ArrayList();
		for(Room room: rooms) {
			RoomDTO dto = new RoomDTO();
			dto.setRoom(room);
			ArrayList<Television> roomsTvs = (ArrayList<Television>) groupedtvs.get(room.getId()) != null ? (ArrayList) groupedtvs.get(room.getId()) : new ArrayList();
			dto.setTelevisions(roomsTvs);
			list.add(dto);
		}
		return list;
	}
	
	public Optional<Television> findById(int id) {
		return repo.findById(id);
	}

	
	
	
	
}
