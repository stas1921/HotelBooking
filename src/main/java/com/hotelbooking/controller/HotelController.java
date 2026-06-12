package com.hotelbooking.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.entity.Hotel;
import com.hotelbooking.repository.HotelRepository;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
    private final HotelRepository hotelRepository;
    
    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
    
    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Hotel getHotel(@PathVariable Long id) {
        return hotelRepository.findById(id).orElseThrow();
    }
    
    @GetMapping("/search")
    public List<Hotel> searchHotels(@RequestParam(required = false) String city) {
        if (city == null || city.trim().isEmpty()) {
            return hotelRepository.findAll();
        }
        return hotelRepository.findByCityContainingIgnoreCase(city);
    }
    
    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelRepository.save(hotel);
    }
    
    @PutMapping("/{id}")
    public Hotel updateHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
        hotel.setId(id);
        return hotelRepository.save(hotel);
    }
    
    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Long id) {
        hotelRepository.deleteById(id);
    }
}