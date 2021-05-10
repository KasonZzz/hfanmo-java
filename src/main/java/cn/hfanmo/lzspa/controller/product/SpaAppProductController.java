package cn.hfanmo.lzspa.controller.product;


import cn.hfanmo.lzspa.pojo.common.BaseResult;
import cn.hfanmo.lzspa.pojo.product.SpaAppProduct;
import cn.hfanmo.lzspa.service.product.SpaAppProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 产品表 前端控制器
 * </p>
 *
 * @author KasonZzz
 * @since 2021-04-22
 */
@Api(tags = "商品表")
@RestController
@RequestMapping("/spaAppProduct")
public class SpaAppProductController {
    @Autowired
    private SpaAppProductService spaAppProductService;

    @PostMapping("add")
    public boolean add(@RequestBody List<SpaAppProduct> spaAppProducts){
        return spaAppProductService.saveBatch(spaAppProducts);
    }


    @PostMapping("delByIds")
    public boolean delByIds(@RequestBody List<Long> ids){
        return spaAppProductService.removeByIds(ids);
    }

    @PostMapping("updateById")
    public boolean updateById(@RequestBody SpaAppProduct spaAppProduct){
        return spaAppProductService.updateById(spaAppProduct);
    }

//    @PostMapping("queryByPage")


}

