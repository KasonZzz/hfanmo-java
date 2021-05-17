package cn.hfanmo.lzspa.service.massagist;

import cn.hfanmo.lzspa.pojo.massagist.SpaAppMassProduct;
import cn.hfanmo.lzspa.pojo.product.SpaAppProduct;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author KasonZzz
 * @since 2021-05-16
 */
public interface SpaAppMassProductService extends IService<SpaAppMassProduct> {

    List<SpaAppProduct> getProductByMassId(Long massId);
}
