package net.zdsoft.smartcampus.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shenke
 */
@Data
public class User implements Serializable {

    private String id;
    private String username;
}
