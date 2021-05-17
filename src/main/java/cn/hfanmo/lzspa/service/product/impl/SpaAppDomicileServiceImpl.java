package cn.hfanmo.lzspa.service.product.impl;

import cn.hfanmo.lzspa.mapper.product.SpaAppDomicileMapper;
import cn.hfanmo.lzspa.pojo.product.SpaAppDomicile;
import cn.hfanmo.lzspa.service.product.SpaAppDomicileService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * <p>
 * 住址表 服务实现类
 * </p>
 *
 * @author KasonZzz
 * @since 2021-04-22
 */
@Service
public class SpaAppDomicileServiceImpl extends ServiceImpl<SpaAppDomicileMapper, SpaAppDomicile> implements SpaAppDomicileService {

    @Override
    @Transactional
    public boolean addDomicile(SpaAppDomicile spaAppDomicile) {
        if (spaAppDomicile.getStatus().equals("true")) {
            QueryWrapper<SpaAppDomicile> statusQr = new QueryWrapper<>();
            statusQr.eq("status", spaAppDomicile.getStatus());
            statusQr.eq("user_id", spaAppDomicile.getUserId());
            SpaAppDomicile one = this.getOne(statusQr);
            if (!ObjectUtils.isEmpty(one)) {
                one.setStatus("false");
                this.updateById(one);
            }
        }
        if (spaAppDomicile.getType().equals("edit")) {
            return this.updateById(spaAppDomicile);
        }
        return this.save(spaAppDomicile);
    }

    @Override
    @Transactional
    public boolean updateDomicile(SpaAppDomicile spaAppDomicile) {
        if (spaAppDomicile.getStatus().equals("1")) {
            QueryWrapper<SpaAppDomicile> statusQr = new QueryWrapper<>();
            statusQr.eq("status", spaAppDomicile.getStatus());
            statusQr.eq("userId", spaAppDomicile.getUserId());
            SpaAppDomicile one = this.getOne(statusQr);
            if (!ObjectUtils.isEmpty(one)) {
                one.setStatus("0");
                this.updateById(one);
            }
        }
        return this.updateById(spaAppDomicile);
    }

    @Override
    public List<SpaAppDomicile> queryDomicile(SpaAppDomicile spaAppDomicile) {
        QueryWrapper<SpaAppDomicile> qr = new QueryWrapper<>();
        qr.eq("user_id", spaAppDomicile.getUserId());
        qr.orderByDesc("status");
        List<SpaAppDomicile> list = this.list(qr);
        return list;
    }

    @Override
    public List<SpaAppDomicile> queryDomicileByIdAndStatus(SpaAppDomicile spaAppDomicile) {
        QueryWrapper<SpaAppDomicile> qr = new QueryWrapper<>();
        qr.eq("status",spaAppDomicile.getStatus());
        qr.eq("user_id",spaAppDomicile.getUserId());
        List<SpaAppDomicile> list = this.list(qr);
        return list;
    }
}
