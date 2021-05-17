package cn.hfanmo.lzspa.service.order;

import cn.hfanmo.lzspa.pojo.order.SpaAppOrder;
import cn.hfanmo.lzspa.pojo.product.SpaAppProduct;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author KasonZzz
 * @since 2021-05-17
 */
public interface SpaAppOrderService extends IService<SpaAppOrder> {

    boolean addOrder(List<SpaAppProduct> products);
}
