package net.zdsoft.smartcampus.user.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author shenke
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@Entity
@Table(name = "base_user")
public class User extends net.zdsoft.smartcampus.entity.User {

    @Id
    private String id;

    @Column(name = "is_deleted")
    private Integer deleted;
}
