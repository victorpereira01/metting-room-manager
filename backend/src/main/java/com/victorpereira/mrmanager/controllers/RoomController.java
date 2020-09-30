package com.victorpereira.mrmanager.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victorpereira.mrmanager.exceptions.ResourceNotFoundException;
import com.victorpereira.mrmanager.models.Room;
import com.victorpereira.mrmanager.repositories.RoomRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1")
public class RoomController {

	@Autowired
	private RoomRepository repo;

	@GetMapping("/rooms")
	public List<Room> getAllRooms() {
		return repo.findAll();
	}

	@GetMapping("/rooms/{id}")
	public ResponseEntity<Room> getRoomById(@PathVariable(value = "id") long roomId) throws ResourceNotFoundException {
		Room room = repo.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("Room not found: " + roomId));

		return ResponseEntity.ok().body(room);
	}

	@PostMapping("/rooms")
	public Room createRoom(@Valid @RequestBody Room room) {
		return repo.save(room);
	}

	@PutMapping("/rooms/{id}")
	public ResponseEntity<Room> updateRoom(@PathVariable(value = "id") Long roomId,
			@Valid @RequestBody Room roomDetails) throws ResourceNotFoundException {
		Room room = repo.findById(roomId)
				.orElseThrow(() -> new ResourceNotFoundException("Room not found: " + roomId));
		
		room.setName(roomDetails.getName());
		room.setDate(roomDetails.getDate());
		room.setStartHour(roomDetails.getStartHour());
		room.setEndHour(roomDetails.getStartHour());
		
		final Room updateRoom = repo.save(room);
		return ResponseEntity.ok(updateRoom);
	}
	
	@DeleteMapping("/rooms/{id}")
	public Map<String, Boolean> deleteRoom(@PathVariable(value="id") Long roomId) throws ResourceNotFoundException {
		Room room = repo.findById(roomId)
				.orElseThrow(() -> new ResourceNotFoundException("Room not found: " + roomId));
		
		repo.delete(room);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}

}
