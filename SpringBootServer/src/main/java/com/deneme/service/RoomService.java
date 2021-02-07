package com.deneme.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.deneme.Model.AirConditioner;
import com.deneme.Model.Curtain;
import com.deneme.Model.Light;
import com.deneme.Model.Room;
import com.deneme.Model.Television;
import com.deneme.Model.DTO.RoomDTO;
import com.deneme.Repository.AirConditionerRepository;
import com.deneme.Repository.CurtainRepository;
import com.deneme.Repository.LightRepository;
import com.deneme.Repository.RoomRepository;
import com.deneme.Repository.TelevisionRepository;



@Service
public class RoomService {
	@Autowired
	private RoomRepository repo;
	
	@Autowired
	private LightRepository lightRepo;
	
	@Autowired
	private CurtainRepository curtainRepo;
	
	@Autowired
	private AirConditionerRepository acRepo;
	
	@Autowired
	private TelevisionRepository tvRepo;
	
	public List<Room> listAll(){
		return repo.findAll();
		
	}
	
	public void save (Room room) {
		repo.save(room);
	}
	
	public Room get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<RoomDTO> findRoomsWithAllComponents() {
		ArrayList<Light> lights = (ArrayList<Light>) lightRepo.findAll();
		ArrayList<AirConditioner> acs = (ArrayList<AirConditioner>) acRepo.findAll();
		ArrayList<Curtain> curtains = (ArrayList<Curtain>) curtainRepo.findAll();
		ArrayList<Television> tvs = (ArrayList<Television>) tvRepo.findAll();
		
		
		ArrayList<Room> rooms = (ArrayList<Room>) repo.findAll();
		
		Map<Object, List<Light>> groupLights =
				lights.stream().collect(Collectors.groupingBy(l -> l.getRoomId()));
		Map<Object, List<AirConditioner>> groupedAcs =
				acs.stream().collect(Collectors.groupingBy(l -> l.getRoomId()));
		Map<Object, List<Curtain>> groupedCurtains =
				curtains.stream().collect(Collectors.groupingBy(l -> l.getRoomId()));
		Map<Object, List<Television>> groupedtvs =
				tvs.stream().collect(Collectors.groupingBy(l -> l.getRoomId()));
		
		List<RoomDTO> list = new ArrayList();
		for(Room room: rooms) {
			RoomDTO dto = new RoomDTO();
			dto.setRoom(room);
			ArrayList<Light> roomsLights = (ArrayList<Light>) groupLights.get(room.getId()) != null ? (ArrayList<Light>) groupLights.get(room.getId()) : new ArrayList();
			dto.setLights(roomsLights);
			ArrayList<Television> roomsTvs = (ArrayList<Television>) groupedtvs.get(room.getId()) != null ? (ArrayList) groupedtvs.get(room.getId()) : new ArrayList();
			dto.setTelevisions(roomsTvs);
			ArrayList<Curtain> roomsCurtains = (ArrayList<Curtain>) groupedCurtains.get(room.getId()) != null ? (ArrayList<Curtain>) groupedCurtains.get(room.getId()) : new ArrayList();
			dto.setCurtains(roomsCurtains);
			ArrayList<AirConditioner> roomsAcs = (ArrayList<AirConditioner>) groupedAcs.get(room.getId()) != null ? (ArrayList) groupedAcs.get(room.getId()) : new ArrayList();
			dto.setAirconditioners(roomsAcs);
			list.add(dto);
		}
		return list;
	}
	
	
}
