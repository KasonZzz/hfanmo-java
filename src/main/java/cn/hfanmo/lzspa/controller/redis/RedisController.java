package cn.hfanmo.lzspa.controller.redis;

import cn.hfanmo.lzspa.pojo.user.SpaAppUser;
import cn.hfanmo.lzspa.util.RedisUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisUtils redisUtils;


    @GetMapping("getUserInfo")
    public SpaAppUser getUserInfo(String key){
        String byKey = redisUtils.getByKey(key);
        SpaAppUser spaAppUser = JSON.parseObject(byKey, SpaAppUser.class);
        return spaAppUser;
    }
}
