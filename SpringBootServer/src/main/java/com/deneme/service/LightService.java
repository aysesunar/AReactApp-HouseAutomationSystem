package com.deneme.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.deneme.Model.Light;
import com.deneme.Model.Room;
import com.deneme.Model.DTO.RoomDTO;
import com.deneme.Repository.LightRepository;
import com.deneme.Repository.RoomRepository;



@Service
public class LightService {
	@Autowired
	private LightRepository repo;
	
	@Autowired
	private RoomRepository repoRoom;
	
	public List<Light> listAll(){
		return repo.findAll();
		
	}
	
	public void save (Light Light) {
		repo.save(Light);
	}
	
	public Light get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	public List<RoomDTO> findLightsWithRoom() {
		ArrayList<Light> lights = (ArrayList<Light>) repo.findAll();
		ArrayList<Room> rooms = (ArrayList<Room>) repoRoom.findAll();
		Map<Object, List<Light>> groupLights =
				lights.stream().collect(Collectors.groupingBy(l -> l.getRoomId()));
		List<RoomDTO> list = new ArrayList();
		for(Room room: rooms) {
			RoomDTO dto = new RoomDTO();
			dto.setRoom(room);
			ArrayList<Light> roomsLights = (ArrayList<Light>) groupLights.get(room.getId()) != null ? (ArrayList<Light>) groupLights.get(room.getId()) : new ArrayList();
			dto.setLights(roomsLights);
			list.add(dto);
		}
		return list;
	}
	
	public Optional<Light> findById(int id) {
		return repo.findById(id);
	}

	
	
	
	
}
