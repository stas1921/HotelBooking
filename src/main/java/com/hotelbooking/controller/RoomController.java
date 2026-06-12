package com.hotelbooking.controller;

import com.hotelbooking.entity.Room;
import com.hotelbooking.repository.RoomRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomRepository roomRepository;
    
    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    
    @GetMapping
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
    
    @GetMapping("/hotel/{hotelId}")
    public List<Room> getRoomsByHotel(@PathVariable Long hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }
    
    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomRepository.save(room);
    }
    
    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomRepository.deleteById(id);
    }
}