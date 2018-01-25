package cn.itshaw.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("账号")
public class Account implements Serializable {

    public static final String KEY = "ACCOUNT";

    @Id
    @Column(name = "ID", nullable = false, length = 16)
    @ApiModelProperty("账号ID")
    private Long id;

    @Column(name = "PASSWORD", nullable = false, length = 50)
    @ApiModelProperty("账号密码")
    private String password;

    @Column(name = "ACCOUNT_NAME", nullable = false, length = 100)
    @ApiModelProperty("账号名称")
    private String accountName;

    @Column(name = "ENABLED", nullable = true, length = 1)
    @ApiModelProperty("是否可用")
    private Integer enabled;

}