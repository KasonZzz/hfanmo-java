package cn.hfanmo.lzspa.service.massagist.impl;

import cn.hfanmo.lzspa.pojo.massagist.SpaAppMassProduct;
import cn.hfanmo.lzspa.mapper.massagist.SpaAppMassProductMapper;
import cn.hfanmo.lzspa.pojo.product.SpaAppProduct;
import cn.hfanmo.lzspa.service.massagist.SpaAppMassProductService;
import cn.hfanmo.lzspa.service.product.SpaAppProductService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author KasonZzz
 * @since 2021-05-16
 */
@Service
public class SpaAppMassProductServiceImpl extends ServiceImpl<SpaAppMassProductMapper, SpaAppMassProduct> implements SpaAppMassProductService {

    @Autowired
    private SpaAppProductService spaAppProductService;

    @Override
    public List<SpaAppProduct> getProductByMassId(Long massId) {
        //查询条件
        QueryWrapper<SpaAppMassProduct> sampQr = new QueryWrapper<>();
        sampQr.eq("mass_id", massId);
        List<SpaAppMassProduct> spaAppMassProductList = this.list(sampQr);
        //获取ID集合
        List<Long> idList = spaAppMassProductList.stream().map(SpaAppMassProduct::getProductId).collect(Collectors.toList());

        //查询商品条件
        QueryWrapper<SpaAppProduct> sapQr = new QueryWrapper<>();
        sapQr.in("id",idList);
        List<SpaAppProduct> list = spaAppProductService.list(sapQr);


        return list;
    }
}
