package cn.hfanmo.lzspa.service.order.impl;

import cn.hfanmo.lzspa.mapper.order.SpaAppOrderMapper;
import cn.hfanmo.lzspa.pojo.order.SpaAppOrder;
import cn.hfanmo.lzspa.pojo.product.SpaAppProduct;
import cn.hfanmo.lzspa.service.order.SpaAppOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author KasonZzz
 * @since 2021-05-17
 */
@Service
public class SpaAppOrderServiceImpl extends ServiceImpl<SpaAppOrderMapper, SpaAppOrder> implements SpaAppOrderService {


    @Override
    public boolean addOrder(List<SpaAppProduct> products) {
        List<SpaAppOrder> orders = new ArrayList<>();
        for (SpaAppProduct product : products) {
            SpaAppOrder order = new SpaAppOrder();
            order.setProductId(product.getId());
            // todo 通知技师
            order.setOUserId(product.getMassId());


            order.setUserId(product.getUserId());
            order.setStatus(0);
            order.setCount(product.getNumber());
            order.setCreateTime(LocalDateTime.now());

            order.setDomId(product.getDomId());
            orders.add(order);
        }
        return this.saveBatch(orders);
    }
}
