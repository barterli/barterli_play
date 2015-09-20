package models.entities;


import javax.persistence.*;

import models.entities.converter.AdminTypeConverter;
import models.entities.enums.AdminType;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;


/**
 * Created by suren on 5/9/15.
 */

@Entity
@Table(name="users")
public class User implements EntityTimeStamp{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Integer mobileNumber;

    private Integer countryCode;

    private Double latLong;

    private String city;

    private String country;

    @Convert(converter = AdminTypeConverter.class)
    private AdminType adminType;

    @Embedded
    private TimeStamp timeStamp;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Double getLatLong() {
        return latLong;
    }

    public void setLatLong(Double latLong) {
        this.latLong = latLong;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static User findById(Long id) {
        return JPA.em().find(User.class, id);
    }

    public Integer getAdminType(){
       return adminType.getValue();
    }

    @Override
    public void setTimeStamp(TimeStamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public TimeStamp getTimeStamp() {
        return timeStamp;
    }

    public static User create(User user){
        JPA.withTransaction(() -> {
            JPA.em().persist(user);
        });
        return user;
    }
}

