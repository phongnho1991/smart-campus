package net.zdsoft.smartcampus.user.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "User", description = "对应数字校园用户表", parent = net.zdsoft.smartcampus.entity.User.class)
public class User extends net.zdsoft.smartcampus.entity.User {

    @ApiModelProperty(
            value = "主键",
            dataType = "String"
    )
    @Id
    private String id;

    @ApiModelProperty(
            value = "软删标记",
            hidden = true
    )
    @Column(name = "is_deleted")
    private Integer deleted;
}
