package cn.hfanmo.lzspa.service.user.impl;

import cn.hfanmo.lzspa.mapper.user.SpaAppUserMapper;
import cn.hfanmo.lzspa.pojo.common.AliSms;
import cn.hfanmo.lzspa.pojo.common.SetData;
import cn.hfanmo.lzspa.pojo.user.SpaAppUser;
import cn.hfanmo.lzspa.service.user.SpaAppUserService;
import cn.hfanmo.lzspa.util.AliSmsUtil;
import cn.hfanmo.lzspa.util.RedisUtils;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Random;

import static cn.hfanmo.lzspa.constant.SysConstant.EXPIRE_WEEK;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author kason
 * @since 2021-03-22
 */
@Service
@Slf4j
public class SpaAppUserServiceImpl extends ServiceImpl<SpaAppUserMapper, SpaAppUser> implements SpaAppUserService {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private AliSmsUtil aliSmsUtil;


    @Value("${ali.templateCode}")
    private String templateCode;

    @Value("${ali.signName}")
    private String signName;

    @Value("${ali.regionId}")
    private String regionId;


    @Override
    public SpaAppUser register(SpaAppUser spaAppUser) {
        SetData setData = new SetData();
        setData.setTime(EXPIRE_WEEK);
        if (!ObjectUtils.isEmpty(spaAppUser.getMobile())) {
            String redisKey = "register_code_" + spaAppUser.getMobile();
            String value = redisUtils.getByKey(redisKey);
            //如果redis中没有验证码，注册失败
            if (ObjectUtils.isEmpty(value)) return null;
            //如果验证码和redis中的数值不匹配，验证失败
            if (!value.equals(spaAppUser.getSmsCode())) return null;
            //通过手机号查询是否注册
            SpaAppUser mobile = this.getOne(new QueryWrapper<SpaAppUser>().eq("mobile", spaAppUser.getMobile()));
            //返回用户信息判断是否存在用户
            if (!ObjectUtils.isEmpty(mobile)) {
                log.info("【用户注册】用户已经注册，用户id：{}", mobile.getId());
                setData.setKey("userInfo_" + mobile.getMobile());
                setData.setValue(JSON.toJSONString(mobile));
                redisUtils.set(setData);
                return mobile;
            } else {
                spaAppUser.setAvatar("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=3100338932,2256022770&os=2464126392,3600747117&simid=3316973702,185302547&pn=15&rn=1&di=74910&ln=1622&fr=&fmq=1620219228761_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&hs=2&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%253A%252F%252Fimg.zcool.cn%252Fcommunity%252F011e1855ed01ce6ac7251df877053e.png%26refer%3Dhttp%253A%252F%252Fimg.zcool.cn%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1622811227%26t%3Db97429eaffea925d5dc8099c71213f20&rpstart=0&rpnum=0&adpicid=0&force=undefined");
                spaAppUser.setNickName(spaAppUser.getMobile());
                spaAppUser.setSignature("用户很懒未设置个性签名");
                this.save(spaAppUser);
                log.info("【用户注册】用户未注册，用户id：{}", spaAppUser.getId());
                setData.setKey("userInfo_" + spaAppUser.getMobile());
                setData.setValue(JSON.toJSONString(spaAppUser));
                redisUtils.set(setData);
                return spaAppUser;
            }
        }


        return null;
    }

    @Override
    public boolean getSmsCode(String mobile) {
        //验证码
        String code = createSmsCode();
        //构造发送信息的参数
        AliSms aliSms = new AliSms();
        aliSms.setRegionId(regionId);
        aliSms.setSignName(signName);
        aliSms.setTemplateCode(templateCode);
        aliSms.setPhoneNumbers(mobile);
        aliSms.setTemplateParam("{\"code\":\"" + code + "\"}");

        //将验证码存入redis中，并设置过期时间
        SetData setData = new SetData();
        setData.setKey("register_code_" + mobile);
        setData.setValue(code);
        setData.setTime(120l);
        redisUtils.set(setData);

        aliSmsUtil.sendSms(aliSms);
        return true;
    }

    private String createSmsCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }
}
