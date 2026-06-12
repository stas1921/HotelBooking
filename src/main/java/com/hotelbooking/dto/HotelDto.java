package com.hotelbooking.dto;

public class HotelDto {
    private Long id;
    private String name;
    private String city;
    private String address;
    private Integer stars;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public Integer getStars() { return stars; }
    public void setStars(Integer stars) { this.stars = stars; }
}