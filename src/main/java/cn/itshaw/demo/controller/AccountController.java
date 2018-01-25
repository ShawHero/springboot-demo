package cn.itshaw.demo.controller;

import cn.itshaw.demo.bean.BaseRequest;
import cn.itshaw.demo.bean.BaseResponse;
import cn.itshaw.demo.service.AccountService;
import cn.itshaw.demo.util.PropUtils;
import cn.itshaw.demo.domain.Account;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "账号管理")
@RestController
@RequestMapping("/account/")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ApiOperation("查询账号信息(作为单个应用提供服务时)")
    @GetMapping("/{id}")
    public @ApiParam("账号信息")
    Account get(@PathVariable @ApiParam("账号id") long id) {
        try{
            return accountService.findById(id);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
        }
        return null;
    }

    @ApiOperation("查询账号信息(作为服务接口，对多个应用提供服务时)")
    @PostMapping("/")
    public @ApiParam("账号信息查询响应参数")
    BaseResponse<Account> get(@RequestBody @ApiParam("账号信息查询请求参数")BaseRequest<Long> baseRequest) {
        BaseResponse<Account> baseResponse = new BaseResponse<>(baseRequest.getSeqNo());
        try{
            Account account = accountService.findById(baseRequest.getRequest());
            baseResponse.setResponse(account);
        }catch (Exception ex){
            baseResponse.setCode(101);
            baseResponse.setDesc(PropUtils.getProp(101, new String[]{ex.getMessage()}));
            log.error(ex.getMessage(), ex);
        }
        return baseResponse;
    }
}