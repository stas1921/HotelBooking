package com.hotelbooking.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String address;
    private String city;
    private String description;
    private Integer stars;
    private String imageUrl;  // ← ДОБАВЬ ЭТУ СТРОКУ
    
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager;
    
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;
    
    @OneToMany(mappedBy = "hotel")
    private List<Review> reviews;
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getStars() { return stars; }
    public void setStars(Integer stars) { this.stars = stars; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public User getManager() { return manager; }
    public void setManager(User manager) { this.manager = manager; }
    public List<Room> getRooms() { return rooms; }
    public void setRooms(List<Room> rooms) { this.rooms = rooms; }
    public List<Review> getReviews() { return reviews; }
    public void setReviews(List<Review> reviews) { this.reviews = reviews; }
}