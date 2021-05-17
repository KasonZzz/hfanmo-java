package cn.hfanmo.lzspa.service.product;

import cn.hfanmo.lzspa.pojo.product.SpaAppDomicile;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 住址表 服务类
 * </p>
 *
 * @author KasonZzz
 * @since 2021-04-22
 */
public interface SpaAppDomicileService extends IService<SpaAppDomicile> {

    boolean addDomicile(SpaAppDomicile spaAppDomicile);

    boolean updateDomicile(SpaAppDomicile spaAppDomicile);

    List<SpaAppDomicile> queryDomicile(SpaAppDomicile spaAppDomicile);

    List<SpaAppDomicile> queryDomicileByIdAndStatus(SpaAppDomicile spaAppDomicile);



}
