package com.deneme.Model.DTO;

import com.deneme.Model.Room;
import com.deneme.Model.Television;

import antlr.collections.List;

import java.util.ArrayList;

import com.deneme.Model.AirConditioner;
import com.deneme.Model.Curtain;
import com.deneme.Model.Light;

public class RoomDTO {
	private Room room;
	private ArrayList<Light> lights;
	private ArrayList<Curtain> curtains;
	private ArrayList<AirConditioner> airconditioners;
	private ArrayList<Television> televisions;
	
	public RoomDTO() {
		
	}
	
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public ArrayList<Light> getLights() {
		return lights;
	}
	public void setLights(ArrayList<Light> lights) {
		this.lights = lights;
	}

	public ArrayList<Curtain> getCurtains() {
		return curtains;
	}

	public void setCurtains(ArrayList<Curtain> curtains) {
		this.curtains = curtains;
	}

	public ArrayList<AirConditioner> getAirconditioners() {
		return airconditioners;
	}

	public void setAirconditioners(ArrayList<AirConditioner> airconditioners) {
		this.airconditioners = airconditioners;
	}

	public ArrayList<Television> getTelevisions() {
		return televisions;
	}

	public void setTelevisions(ArrayList<Television> televisions) {
		this.televisions = televisions;
	}
	
	
}
