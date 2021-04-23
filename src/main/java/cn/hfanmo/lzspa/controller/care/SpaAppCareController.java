package cn.hfanmo.lzspa.controller.care;


import cn.hfanmo.lzspa.pojo.care.SpaAppCare;
import cn.hfanmo.lzspa.pojo.common.BaseResult;
import cn.hfanmo.lzspa.pojo.product.SpaAppProduct;
import cn.hfanmo.lzspa.service.care.SpaAppCareService;
import cn.hfanmo.lzspa.service.product.SpaAppProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 我的关注表 前端控制器
 * </p>
 *
 * @author KasonZzz
 * @since 2021-04-22
 */
@RestController
@RequestMapping("/spaAppCare")
public class SpaAppCareController {

    @Autowired
    private SpaAppCareService spaAppCareService;

    @Autowired
    private SpaAppProductService spaAppProductService;


    @PostMapping("add")
    public BaseResult add(@RequestBody SpaAppCare spaAppCare) {
        spaAppCareService.save(spaAppCare);
        return new BaseResult(200);
    }

    @PostMapping("delByIds")
    public BaseResult delByIds(@RequestBody List<Long> ids) {
        spaAppCareService.removeByIds(ids);
        return new BaseResult(200);
    }

    @PostMapping("updateById")
    public BaseResult updateById(@RequestBody SpaAppCare spaAppCare) {
        spaAppCareService.updateById(spaAppCare);
        return new BaseResult(20);
    }

    @PostMapping("queryProductByCare")
    public BaseResult queryProductByCare(@RequestBody SpaAppCare spaAppCare) {
        SpaAppCare appCare = spaAppCareService.getById(spaAppCare.getId());
        SpaAppProduct appProduct = spaAppProductService.getById(appCare.getCareId());
        return new BaseResult(appProduct);
    }

    @PostMapping("queryProductsByUserId")
    public BaseResult queryProductsByUserId(@RequestBody Long id){
        List<SpaAppProduct> products = spaAppCareService.queryProductsByUserId(id);
        return new BaseResult(products);
    }




}

