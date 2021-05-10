package cn.hfanmo.lzspa.controller.product;


import cn.hfanmo.lzspa.pojo.common.BaseResult;
import cn.hfanmo.lzspa.pojo.product.SpaAppDomicile;
import cn.hfanmo.lzspa.service.product.SpaAppDomicileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 住址表 前端控制器
 * </p>
 *
 * @author KasonZzz
 * @since 2021-04-22
 */
@RestController
@RequestMapping("/spaAppDomicile")
public class SpaAppDomicileController {
    @Autowired
    private SpaAppDomicileService spaAppDomicileService;

    @PostMapping("getById")
    public BaseResult getById(@RequestBody SpaAppDomicile spaAppDomicile){
        SpaAppDomicile byId = spaAppDomicileService.getById(spaAppDomicile.getId());
        return new BaseResult(byId);
    }


    @PostMapping("queryDomicile")
    public BaseResult queryDomicile(@RequestBody SpaAppDomicile spaAppDomicile){
         List<SpaAppDomicile> domiciles =spaAppDomicileService.queryDomicile(spaAppDomicile);
        return new BaseResult(domiciles);
    }


    @PostMapping("add")
    public boolean addDomicile(@RequestBody SpaAppDomicile spaAppDomicile){
        spaAppDomicile.setCreateTime(LocalDateTime.now());
        return spaAppDomicileService.addDomicile(spaAppDomicile);
    }

    @PostMapping("delById")
    public boolean delByIds(@RequestBody SpaAppDomicile spaAppDomicile){
        return spaAppDomicileService.removeById(spaAppDomicile.getId());
    }

    @PostMapping("update")
    public boolean updateDomicile(@RequestBody SpaAppDomicile spaAppDomicile){
        return spaAppDomicileService.updateDomicile(spaAppDomicile);
    }
}

