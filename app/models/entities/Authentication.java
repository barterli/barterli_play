package models.entities;

import models.listeners.DbTimeStampListener;

import javax.persistence.*;

/**
 * Created by suren on 12/9/15.
 */

@Entity
@EntityListeners(DbTimeStampListener.class)
public class Authentication implements EntityTimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable=false)
    private String provider;

    @Column(nullable=false)
    private String token;

    @Column(nullable=false)
    private String uid;

    @Column(nullable=false)
    private String tokenSecret;

    public Long getId() {
        return id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenSecret() {
        return tokenSecret;
    }

    public void setTokenSecret(String tokenSecret) {
        this.tokenSecret = tokenSecret;
    }

    @Override
    public void setTimeStamp(TimeStamp timeStamp) {

    }

    @Override
    public TimeStamp getTimeStamp() {
        return null;
    }
}
