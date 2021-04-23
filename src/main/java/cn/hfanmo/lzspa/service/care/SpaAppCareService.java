package cn.hfanmo.lzspa.service.care;

import cn.hfanmo.lzspa.pojo.care.SpaAppCare;
import cn.hfanmo.lzspa.pojo.product.SpaAppProduct;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 我的关注表 服务类
 * </p>
 *
 * @author KasonZzz
 * @since 2021-04-22
 */
public interface SpaAppCareService extends IService<SpaAppCare> {

    List<SpaAppProduct> queryProductsByUserId(Long id);
}
