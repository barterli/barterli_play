package models.entities.converter;

import models.entities.enums.AdminType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by suren on 13/9/15.
 */

@Converter
public class AdminTypeConverter implements AttributeConverter<AdminType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(AdminType attribute) {
        switch (attribute) {
            case ADMIN:
                return AdminType.ADMIN.getValue();
            case SUPER_ADMIN:
                return AdminType.SUPER_ADMIN.getValue();
            case NORMAL_USER:
                return AdminType.NORMAL_USER.getValue();
            default:
                return AdminType.NORMAL_USER.getValue();
        }
    }

    @Override
    public AdminType convertToEntityAttribute(Integer dbData) {
        if(dbData.equals(AdminType.ADMIN.getValue())){
            return AdminType.ADMIN;
        }else if(dbData.equals(AdminType.SUPER_ADMIN.getValue())){
            return AdminType.SUPER_ADMIN;
        }else if(dbData.equals(AdminType.NORMAL_USER.getValue())) {
            return AdminType.NORMAL_USER;
        }
        else{
            throw new IllegalArgumentException("Unknown" + dbData);
        }
    }


}
