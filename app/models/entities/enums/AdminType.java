package models.entities.enums;

/**
 * Created by suren on 13/9/15.
 */
public enum AdminType {

    NORMAL_USER(1), ADMIN(2), SUPER_ADMIN(3);

    Integer value;

    AdminType(Integer value){
        this.value = value;
    }

    public Integer getValue(){
        return value;
    }
}
