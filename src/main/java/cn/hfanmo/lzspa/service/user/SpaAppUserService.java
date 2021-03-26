package cn.hfanmo.lzspa.service.user;

import cn.hfanmo.lzspa.pojo.user.SpaAppUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author kason
 * @since 2021-03-22
 */
public interface SpaAppUserService extends IService<SpaAppUser> {

    SpaAppUser register(SpaAppUser spaAppUser);
}
