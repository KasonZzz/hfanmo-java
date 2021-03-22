package cn.hfanmo.lzspa.controller.banner;


import cn.hfanmo.lzspa.pojo.banner.SpaAppBanner;
import cn.hfanmo.lzspa.pojo.common.BaseResult;
import cn.hfanmo.lzspa.service.banner.SpaAppBannerService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 滚动图 前端控制器
 * </p>
 *
 * @author KasonZzz
 * @since 2021-03-17
 */
@RestController
@RequestMapping("/spaAppBanner")
@Api(value = "SpaAppBannerController", tags = "导航图")
public class SpaAppBannerController {

    @Autowired
    private SpaAppBannerService spaAppBannerService;


    @GetMapping("queryByStatus")
    public BaseResult queryByStatus(Integer status) {
        QueryWrapper<SpaAppBanner> wrapper = new QueryWrapper<>();
        wrapper.eq("status", status);
        return new BaseResult(spaAppBannerService.list(wrapper));
    }

    @PostMapping("add")
    @ApiOperation("新增")
    public BaseResult add(@RequestBody List<SpaAppBanner> spaAppBanners) {
        spaAppBannerService.saveBatch(spaAppBanners);
        return new BaseResult(200);
    }

    @PostMapping("delById")
    @ApiOperation("通过ID删除")
    public BaseResult delById(@RequestBody List<Long> ids) {
        spaAppBannerService.removeByIds(ids);
        return new BaseResult(200);
    }

    @PostMapping("update")
    @ApiOperation("更新")
    public BaseResult update(SpaAppBanner spaAppBanner) {
        spaAppBannerService.updateById(spaAppBanner);
        return new BaseResult(200);
    }

    @GetMapping("queryByPage")
    @ApiOperation("分页查询")
    public BaseResult queryByPage(Integer page, Integer pageSize) {
        Page<SpaAppBanner> spaAppBannerPage = new Page<>(page, pageSize);
        Page<SpaAppBanner> bannerPage = spaAppBannerService.page(spaAppBannerPage);
        return new BaseResult(bannerPage);
    }


}

