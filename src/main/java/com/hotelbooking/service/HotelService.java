package com.hotelbooking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotelbooking.entity.Hotel;
import com.hotelbooking.repository.HotelRepository;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
    
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
    
    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElseThrow();
    }
    
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
    
    public Hotel updateHotel(Long id, Hotel hotel) {
        hotel.setId(id);
        return hotelRepository.save(hotel);
    }
    
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}