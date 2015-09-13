package models.listeners;

import models.entities.EntityTimeStamp;
import models.entities.TimeStamp;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * Created by suren on 12/9/15.
 */
public class DbTimeStampListener {

    @PrePersist
    protected void onCreate(Object entity) {
        if (entity instanceof EntityTimeStamp) {
            TimeStamp timeStamp = new TimeStamp();
            timeStamp.setCreatedAt(new Date());
            ((EntityTimeStamp) entity).setTimeStamp(timeStamp);
        }
    }

    @PreUpdate
    protected void onUpdate(Object entity) {
        TimeStamp timeStamp = ((EntityTimeStamp) entity).getTimeStamp();
        timeStamp.setUpdatedAt(new Date());
    }
}
