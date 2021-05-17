package cn.hfanmo.lzspa.controller.order;


import cn.hfanmo.lzspa.pojo.common.BaseResult;
import cn.hfanmo.lzspa.pojo.product.SpaAppProduct;
import cn.hfanmo.lzspa.service.order.SpaAppOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author KasonZzz
 * @since 2021-05-17
 */
@RestController
@RequestMapping("/spaAppOrder")
public class SpaAppOrderController {

    @Autowired
    private SpaAppOrderService ordersService;

    @PostMapping("addOrder")
    public BaseResult addOrder(@RequestBody List<SpaAppProduct> products) {
        boolean b = ordersService.addOrder(products);
        return new BaseResult(b);
    }

}

