package cn.hfanmo.lzspa.controller.care;


import cn.hfanmo.lzspa.pojo.care.SpaAppCare;
import cn.hfanmo.lzspa.pojo.common.BaseResult;
import cn.hfanmo.lzspa.service.care.SpaAppCareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 我的关注表 前端控制器
 * </p>
 *
 * @author KasonZzz
 * @since 2021-03-18
 */
@RestController
@RequestMapping("/spaAppCare")
public class SpaAppCareController {

    @Autowired
    private SpaAppCareService spaAppCareService;


    @PostMapping("add")
    public BaseResult add(SpaAppCare spaAppCare){
        spaAppCareService.save(spaAppCare);
        return new BaseResult(200);
    }

}

