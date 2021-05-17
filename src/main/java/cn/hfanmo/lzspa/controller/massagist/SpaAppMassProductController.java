package cn.hfanmo.lzspa.controller.massagist;


import cn.hfanmo.lzspa.pojo.common.BaseResult;
import cn.hfanmo.lzspa.pojo.massagist.SpaAppMassProduct;
import cn.hfanmo.lzspa.pojo.product.SpaAppProduct;
import cn.hfanmo.lzspa.service.massagist.SpaAppMassProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author KasonZzz
 * @since 2021-05-16
 */
@RestController
@RequestMapping("/spaAppMassProduct")
public class SpaAppMassProductController {


    @Autowired
    private SpaAppMassProductService spaAppMassProductService;


    @PostMapping("add")
    public BaseResult add(@RequestBody SpaAppMassProduct spaAppMassProduct) {
        boolean save = spaAppMassProductService.save(spaAppMassProduct);
        return new BaseResult(save);
    }

    @PostMapping("getProductByMassId")
    public BaseResult getProductByMassId(@RequestBody SpaAppMassProduct spaAppMassProduct) {
        List<SpaAppProduct> productByMassId = spaAppMassProductService.getProductByMassId(spaAppMassProduct.getMassId());
        return new BaseResult(productByMassId);
    }

}

