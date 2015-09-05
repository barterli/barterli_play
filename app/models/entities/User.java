package models.entities;


import javax.persistence.*;


/**
 * Created by suren on 5/9/15.
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true, nullable = false)
    private int email;

    @Column
    private String password;

    @Column(name = "mobile_number")
    private int mobileNumber;

    @Column(name = "country_code")
    private int countryCode;

    @Column(name = "lat_long")
    private String latLong;

    private String city;

    private String country;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getEmail() {
        return email;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public String getLatLong() {
        return latLong;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public void setLatLong(String latLong) {
        this.latLong = latLong;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

