package net.zdsoft.smartcampus.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;

/**
 * @author shenke
 */
@Data
@MappedSuperclass
public class User {

    private String username;
    private String password;
    private String unitId;
}
