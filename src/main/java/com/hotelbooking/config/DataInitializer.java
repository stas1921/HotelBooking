package com.hotelbooking.config;

import com.hotelbooking.entity.*;
import com.hotelbooking.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

//@Component
public class DataInitializer implements CommandLineRunner {
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final RoleRepository roleRepository;
    
    public DataInitializer(HotelRepository hotelRepository, RoomRepository roomRepository, RoleRepository roleRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
        this.roleRepository = roleRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
        if (hotelRepository.count() > 0) {
            System.out.println("✅ Данные уже загружены");
            return;
        }
        
        // Роли
        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        roleRepository.save(adminRole);
        
        Role touristRole = new Role();
        touristRole.setName("TOURIST");
        roleRepository.save(touristRole);
        
        // Отели России
        Hotel h1 = new Hotel();
        h1.setName("Four Seasons Moscow");
        h1.setCity("Москва");
        h1.setAddress("ул. Охотный Ряд, 2");
        h1.setStars(5);
        h1.setDescription("Роскошный 5-звездочный отель с видом на Кремль. Рестораны высокой кухни, спа-центр.");
        hotelRepository.save(h1);
        
        Hotel h2 = new Hotel();
        h2.setName("Belmond Grand Hotel Europe");
        h2.setCity("Санкт-Петербург");
        h2.setAddress("Невский пр., 23");
        h2.setStars(5);
        h2.setDescription("Исторический отель на Невском проспекте. Изысканные интерьеры, рестораны.");
        hotelRepository.save(h2);
        
        Hotel h3 = new Hotel();
        h3.setName("Rosa Springs Hotel");
        h3.setCity("Сочи");
        h3.setAddress("Красная Поляна");
        h3.setStars(4);
        h3.setDescription("Горнолыжный курорт на Красной Поляне. Термальные источники, спа.");
        hotelRepository.save(h3);
        
        Hotel h4 = new Hotel();
        h4.setName("Kazan Palace");
        h4.setCity("Казань");
        h4.setAddress("ул. Баумана, 15");
        h4.setStars(4);
        h4.setDescription("Отель в историческом центре Казани. Сочетание восточной роскоши.");
        hotelRepository.save(h4);
        
        Hotel h5 = new Hotel();
        h5.setName("Hyatt Regency Ekaterinburg");
        h5.setCity("Екатеринбург");
        h5.setAddress("ул. Бориса Ельцина, 8");
        h5.setStars(5);
        h5.setDescription("Современный бизнес-отель в центре Екатеринбурга.");
        hotelRepository.save(h5);
        
        Hotel h6 = new Hotel();
        h6.setName("AZIMUT Hotel Siberia");
        h6.setCity("Новосибирск");
        h6.setAddress("ул. Ленина, 21");
        h6.setStars(3);
        h6.setDescription("Уютный отель в центре Новосибирска. Отличное соотношение цены и качества.");
        hotelRepository.save(h6);
        
        // Комнаты для отелей
        for (Hotel hotel : hotelRepository.findAll()) {
            Room room1 = new Room();
            room1.setRoomNumber("101");
            room1.setType("STANDARD");
            room1.setCapacity(2);
            room1.setPricePerNight(new BigDecimal(5000 + Math.random() * 15000));
            room1.setHotel(hotel);
            roomRepository.save(room1);
            
            Room room2 = new Room();
            room2.setRoomNumber("102");
            room2.setType("DELUXE");
            room2.setCapacity(4);
            room2.setPricePerNight(new BigDecimal(10000 + Math.random() * 20000));
            room2.setHotel(hotel);
            roomRepository.save(room2);
        }
        
        System.out.println("✅ Загружено " + hotelRepository.count() + " отелей и " + roomRepository.count() + " номеров");
    }
}