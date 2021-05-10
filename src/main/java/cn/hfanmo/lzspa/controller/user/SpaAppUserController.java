package cn.hfanmo.lzspa.controller.user;


import cn.hfanmo.lzspa.pojo.common.BaseResult;
import cn.hfanmo.lzspa.pojo.common.SetData;
import cn.hfanmo.lzspa.pojo.user.SpaAppUser;
import cn.hfanmo.lzspa.service.user.SpaAppUserService;
import cn.hfanmo.lzspa.util.RedisUtils;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import static cn.hfanmo.lzspa.constant.SysConstant.EXPIRE_WEEK;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author kason
 * @since 2021-03-22
 */
@Api(tags = "用户表")
@RestController
@RequestMapping("/spaAppUser")
public class SpaAppUserController {

    @Autowired
    private SpaAppUserService spaAppUserService;
    @Autowired
    private RedisUtils redisUtils;

    @ApiOperation("注册登录")
    @PostMapping("register")
    public BaseResult register(@RequestBody SpaAppUser spaAppUser) {
        SpaAppUser register = spaAppUserService.register(spaAppUser);
        if (ObjectUtils.isEmpty(register)) return new BaseResult(601);
        return new BaseResult(register);
    }


    @ApiOperation("获取验证码")
    @PostMapping("getSmsCode")
    public BaseResult getSmsCode(@RequestBody SpaAppUser spaAppUser) {
        boolean b = spaAppUserService.getSmsCode(spaAppUser.getMobile());
        return new BaseResult(b);
    }

    @ApiOperation("获取验证码")
    @GetMapping("updateRedisInfo")
    public BaseResult updateRedisInfo(Long userId) {
        SpaAppUser appUser = spaAppUserService.getById(userId);
        if (ObjectUtils.isEmpty(appUser)) return new BaseResult(4041);
        SetData setData = new SetData();
        setData.setTime(EXPIRE_WEEK);
        setData.setKey("userInfo_" + appUser.getMobile());
        setData.setValue(JSON.toJSONString(appUser));
        redisUtils.set(setData);
        return new BaseResult(appUser);
    }


    @PostMapping("add")
    public BaseResult add(@RequestBody SpaAppUser spaAppUser){
        spaAppUserService.save(spaAppUser);
        return new BaseResult(200);
    }


}

