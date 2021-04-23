package cn.hfanmo.lzspa.service.care.impl;

import cn.hfanmo.lzspa.pojo.care.SpaAppCare;
import cn.hfanmo.lzspa.mapper.care.SpaAppCareMapper;
import cn.hfanmo.lzspa.pojo.product.SpaAppProduct;
import cn.hfanmo.lzspa.service.care.SpaAppCareService;
import cn.hfanmo.lzspa.service.product.SpaAppProductService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 我的关注表 服务实现类
 * </p>
 *
 * @author KasonZzz
 * @since 2021-04-22
 */
@Service
public class SpaAppCareServiceImpl extends ServiceImpl<SpaAppCareMapper, SpaAppCare> implements SpaAppCareService {
    @Autowired
    private SpaAppProductService spaAppProductService;

    @Override
    public List<SpaAppProduct> queryProductsByUserId(Long id) {
        QueryWrapper<SpaAppCare> qr = new QueryWrapper<>();
        qr.eq("user_id",id);
        List<SpaAppCare> appCares = this.list(qr);
        List<Long> productIds = new ArrayList<>();
        for (SpaAppCare appCare : appCares) {
            productIds.add(appCare.getCareId());
        }
        List<SpaAppProduct> products = spaAppProductService.listByIds(productIds);
        return products;
    }
}
