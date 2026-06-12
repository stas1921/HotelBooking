package com.hotelbooking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotelbooking.entity.Booking;
import com.hotelbooking.repository.BookingRepository;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    
    public Booking createBooking(Booking booking) {
        booking.setStatus("CONFIRMED");
        return bookingRepository.save(booking);
    }
    
    public void cancelBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}