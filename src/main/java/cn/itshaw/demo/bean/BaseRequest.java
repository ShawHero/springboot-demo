package cn.itshaw.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@ApiModel("基础请求信息")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseRequest<T> implements Serializable{

    public BaseRequest(String seqNo){
        this.seqNo = seqNo;
    }

    @ApiModelProperty("序列号")
    private String seqNo;

    @ApiModelProperty("来源系统")
    private String system;

    @ApiModelProperty("版本号")
    private String version = "1.0";

    @ApiModelProperty("请求参数")
    private T request;

}
