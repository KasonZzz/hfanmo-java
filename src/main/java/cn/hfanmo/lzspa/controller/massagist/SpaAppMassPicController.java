package cn.hfanmo.lzspa.controller.massagist;


import cn.hfanmo.lzspa.pojo.common.BaseResult;
import cn.hfanmo.lzspa.pojo.massagist.SpaAppMassPic;
import cn.hfanmo.lzspa.service.massagist.SpaAppMassPicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 技师图片表 前端控制器
 * </p>
 *
 * @author KasonZzz
 * @since 2021-03-19
 */
@RestController
@Api(value = "SpaAppMassPicController", tags = "技师相册表")
@RequestMapping("/spaAppMassPic")
public class SpaAppMassPicController {

    @Autowired
    private SpaAppMassPicService spaAppMassPicService;


    @PostMapping("add")
    @ApiOperation("技师相册新增")
    public BaseResult add(@RequestBody List<SpaAppMassPic> spaAppMassPics) {
        spaAppMassPicService.saveBatch(spaAppMassPics);
        return new BaseResult(200);
    }

    @PostMapping("delByIds")
    @ApiOperation("批量删除")
    public BaseResult delByIds(@RequestBody List<Long> ids) {
        spaAppMassPicService.removeByIds(ids);
        return new BaseResult(200);
    }

    @PostMapping("updateById")
    @ApiOperation("通过ID更新")
    public BaseResult updateById(@RequestBody SpaAppMassPic spaAppMassPic) {
        spaAppMassPicService.updateById(spaAppMassPic);
        return new BaseResult(200);
    }

    @GetMapping("queryById")
    @ApiOperation("通过ID查询")
    public BaseResult queryById(Long id) {
        SpaAppMassPic byId = spaAppMassPicService.getById(id);
        return new BaseResult(byId);
    }


}

