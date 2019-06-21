package net.zdsoft.smartcampus.base;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author shenke
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {

    private String id;
    private String username;
}
