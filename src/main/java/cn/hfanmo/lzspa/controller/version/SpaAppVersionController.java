package cn.hfanmo.lzspa.controller.version;


import cn.hfanmo.lzspa.pojo.version.SpaAppVersion;
import cn.hfanmo.lzspa.service.version.SpaAppVersionService;
import cn.hfanmo.lzspa.util.QiNiuUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author KasonZzz
 * @since 2021-05-14
 */
@RestController
@RequestMapping("/spaAppVersion")
public class SpaAppVersionController {

    @Autowired
    private SpaAppVersionService spaAppVersionService;
    @Autowired
    private QiNiuUtil qiNiuUtil;

    @PostMapping("update")
    public SpaAppVersion update(@RequestBody SpaAppVersion spaAppVersion) {
        if (!ObjectUtils.isEmpty(spaAppVersion.getName()) && !ObjectUtils.isEmpty(spaAppVersion.getVersion())) {

            QueryWrapper<SpaAppVersion> qr = new QueryWrapper<>();
            qr.orderByDesc("id");
            List<SpaAppVersion> list = spaAppVersionService.list(qr);
            if (!ObjectUtils.isEmpty(list)) {
                SpaAppVersion appVersion = list.get(0);
                appVersion.setUpdate(!appVersion.getVersion().equals(spaAppVersion.getVersion()));
                return appVersion;
            }
        }
        spaAppVersion.setUpdate(false);
        return spaAppVersion;
    }


    @PostMapping("upload")
    public void upload(MultipartFile file,SpaAppVersion spaAppVersion){
        HashMap hashMap = qiNiuUtil.saveFile(file);
        for (Object o : hashMap.keySet()) {
            System.out.println(o);
        }
    }

}

