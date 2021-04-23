package cn.hfanmo.lzspa.service.user.impl;

import cn.hfanmo.lzspa.pojo.user.SpaAppUser;
import cn.hfanmo.lzspa.mapper.user.SpaAppUserMapper;
import cn.hfanmo.lzspa.service.user.SpaAppUserService;
import cn.hfanmo.lzspa.util.RedisUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author kason
 * @since 2021-03-22
 */
@Service
public class SpaAppUserServiceImpl extends ServiceImpl<SpaAppUserMapper, SpaAppUser> implements SpaAppUserService {
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public SpaAppUser register(SpaAppUser spaAppUser) {

        if (!ObjectUtils.isEmpty(spaAppUser.getMobile())) {
            String redisKey = "register_code_" + spaAppUser.getMobile();
            String value = redisUtils.getByKey(redisKey);
        }


        return null;
    }
}
