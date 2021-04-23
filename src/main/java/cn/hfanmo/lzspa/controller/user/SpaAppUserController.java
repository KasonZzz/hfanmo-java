package cn.hfanmo.lzspa.controller.user;


import cn.hfanmo.lzspa.pojo.common.BaseResult;
import cn.hfanmo.lzspa.pojo.user.SpaAppUser;
import cn.hfanmo.lzspa.service.user.SpaAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author kason
 * @since 2021-03-22
 */
@RestController
@RequestMapping("/spaAppUser")
public class SpaAppUserController {

    @Autowired
    private SpaAppUserService spaAppUserService;

    @PostMapping("register")
    public BaseResult register(@RequestBody SpaAppUser spaAppUser) {
        spaAppUserService.register(spaAppUser);
        return null;
    }


}

