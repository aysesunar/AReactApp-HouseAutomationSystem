package com.deneme.Controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.deneme.Model.*;
import com.deneme.Model.DTO.RoomDTO;
import com.deneme.service.AirConditionerService;
import com.deneme.service.CurtainService;
import com.deneme.service.LightService;
import com.deneme.service.RoomService;
import com.deneme.service.TelevisionService;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 


@Controller
@RequestMapping("/api")
public class MainController {
	
	@Autowired
    private LightService lightService;
	
	@Autowired
    private CurtainService curtainService;
	
	@Autowired
    private AirConditionerService airConditionerService;
	
	@Autowired
    private TelevisionService televisionService;
	
	@Autowired
    private RoomService roomService;
	
	private Temperature temperature = new Temperature(25);

	@RequestMapping("/getAllLights") 
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public Collection<Light> listAllLights() {
		return lightService.listAll();
	}
	
	@RequestMapping("/findRoomsWithAllComponents") 
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public Collection<RoomDTO> findRoomsWithAllComponents() {
		return roomService.findRoomsWithAllComponents();
	}
	
	@RequestMapping("/getRoomsWithLights") 
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public Collection<RoomDTO> findLightsWithRoom() {
		return lightService.findLightsWithRoom();
	}
	
	@RequestMapping("/updateLight/{lightId}") 
	@ResponseStatus(value = HttpStatus.OK)
	public void updateLightState(
	  @PathVariable("lightId") int lightId) {
		Optional<Light> light = lightService.findById(lightId);
		light.get().setState(!light.get().getState());
		lightService.save(light.get());
	}
	
	@RequestMapping("/getRoomsWithCurtains") 
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public Collection<RoomDTO> getRoomsWithCurtains() {
		return curtainService.findCurtainsWithRooms();
	}
	
	@RequestMapping("/updateCurtain/{curtainId}") 
	@ResponseStatus(value = HttpStatus.OK)
	public void updateCurtainState(
	  @PathVariable("curtainId") int curtainId) {
		Optional<Curtain> curtain = curtainService.findById(curtainId);
		curtain.get().setState(!curtain.get().getState());
		curtainService.save(curtain.get());
	}
	
	@RequestMapping("/getRoomsWithAcs") 
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public Collection<RoomDTO> getRoomsWithAcs() {
		return airConditionerService.findAcsWithRooms();
	}
	
	@RequestMapping("/updateAc/{acId}") 
	@ResponseStatus(value = HttpStatus.OK)
	public void updateAcState(
	  @PathVariable("acId") int acId) {
		Optional<AirConditioner> ac = airConditionerService.findById(acId);
		ac.get().setState(!ac.get().getState());
		airConditionerService.save(ac.get());
	}
	
	@RequestMapping("/getRoomsWithTelevisions") 
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public Collection<RoomDTO> getRoomsWithTelevisions() {
		return televisionService.findTvsWithRooms();
	}
	
	@RequestMapping("/updateTelevision/{tvId}") 
	@ResponseStatus(value = HttpStatus.OK)
	public void updateTelevision(
	  @PathVariable("tvId") int tvId) {
		Optional<Television> tv = televisionService.findById(tvId);
		tv.get().setState(!tv.get().getState());
		televisionService.save(tv.get());
	}
	
	@RequestMapping("/getTemperature") 
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public int getTemperature() {
		return temperature.getTemperature();
	}
	
	@RequestMapping("/setTemperature/{degree}") 
	@ResponseStatus(value = HttpStatus.OK)
	public void setTemperature(
	  @PathVariable("degree") int degree) {
		temperature.setTemperature(degree);
	}
	
	
	@RequestMapping("/getAllRooms") 
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public Collection<Room> listAllRooms() {
		return roomService.listAll();
	}
	
	
}











