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
import com.deneme.Model.DTO.RoomDTO;
import com.deneme.Repository.AirConditionerRepository;
import com.deneme.Repository.LightRepository;
import com.deneme.Repository.RoomRepository;



@Service
public class AirConditionerService {
	@Autowired
	private AirConditionerRepository repo;
	
	@Autowired
	private RoomRepository repoRoom;
	
	public List<AirConditioner> listAll(){
		return repo.findAll();
		
	}
	
	public void save (AirConditioner ac) {
		repo.save(ac);
	}
	
	public AirConditioner get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	public List<RoomDTO> findAcsWithRooms() {
		ArrayList<AirConditioner> acs = (ArrayList<AirConditioner>) repo.findAll();
		System.out.println(acs);
		ArrayList<Room> rooms = (ArrayList<Room>) repoRoom.findAll();
		Map<Object, List<AirConditioner>> groupedAcs =
				acs.stream().collect(Collectors.groupingBy(l -> l.getRoomId()));
		List<RoomDTO> list = new ArrayList();
		for(Room room: rooms) {
			RoomDTO dto = new RoomDTO();
			dto.setRoom(room);
			ArrayList<AirConditioner> roomsAcs = (ArrayList<AirConditioner>) groupedAcs.get(room.getId()) != null ? (ArrayList) groupedAcs.get(room.getId()) : new ArrayList();
			dto.setAirconditioners(roomsAcs);
			list.add(dto);
		}
		return list;
	}
	
	public Optional<AirConditioner> findById(int id) {
		return repo.findById(id);
	}

	
	
	
	
}
