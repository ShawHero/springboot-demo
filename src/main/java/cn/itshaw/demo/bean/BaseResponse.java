package cn.itshaw.demo.bean;

import cn.itshaw.demo.util.PropUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("基础响应信息")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {

    public BaseResponse(String seqNo){
        this.seqNo = seqNo;
    }

    @ApiModelProperty("seqNo值")
    private String seqNo;

    @ApiModelProperty("返回数据")
    private T response;

    @ApiModelProperty("返回编码")
    private int code = 100;

    @ApiModelProperty("返回信息")
    private String desc = PropUtils.getProp(code);

}
