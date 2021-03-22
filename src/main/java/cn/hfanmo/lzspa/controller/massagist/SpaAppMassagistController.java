package cn.hfanmo.lzspa.controller.massagist;


import cn.hfanmo.lzspa.pojo.common.BaseResult;
import cn.hfanmo.lzspa.pojo.massagist.SpaAppMassPic;
import cn.hfanmo.lzspa.pojo.massagist.SpaAppMassagist;
import cn.hfanmo.lzspa.service.massagist.SpaAppMassPicService;
import cn.hfanmo.lzspa.service.massagist.SpaAppMassagistService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 按摩师 前端控制器
 * </p>
 *
 * @author KasonZzz
 * @since 2021-03-18
 */
@RestController
@RequestMapping("/spaAppMassagist")
@Api(value = "SpaAppMassagistController", tags = "技师")
public class SpaAppMassagistController {

    @Autowired
    private SpaAppMassagistService spaAppMassagistService;
    @Autowired
    private SpaAppMassPicService spaAppMassPicService;


    @PostMapping("add")
    @ApiOperation("新增")
    public BaseResult add(@RequestBody List<SpaAppMassagist> spaAppMassagists) {
        spaAppMassagistService.saveBatch(spaAppMassagists);
        return new BaseResult(200);
    }

    @PostMapping("delByIds")
    @ApiOperation("批量删除")
    public BaseResult delByIds(@RequestBody List<Long> ids) {
        spaAppMassagistService.removeByIds(ids);
        return new BaseResult(200);
    }

    @PostMapping("updateById")
    @ApiOperation("更新")
    public BaseResult updateById(@RequestBody SpaAppMassagist spaAppMassagist) {
        spaAppMassagistService.updateById(spaAppMassagist);
        return new BaseResult(200);
    }

    @GetMapping("queryById")
    @ApiOperation("通过ID查询")
    public BaseResult queryById(Long id) {
        SpaAppMassagist byId = spaAppMassagistService.getById(id);
        QueryWrapper<SpaAppMassPic> spaAppMassPicQueryWrapper = new QueryWrapper<>();
        spaAppMassPicQueryWrapper.eq("mass_id",id);
        List<SpaAppMassPic> SpaAppMassPics = spaAppMassPicService.list(spaAppMassPicQueryWrapper);
        byId.setSpaAppMassPics(SpaAppMassPics);
        return new BaseResult(byId);
    }

    @GetMapping("queryByPage")
    @ApiOperation("分页查询")
    public BaseResult queryByPage(Integer page, Integer pageSize) {
        Page<SpaAppMassagist> spaAppMassagistPage = new Page<>(page, pageSize);
        Page<SpaAppMassagist> massagistPage = spaAppMassagistService.page(spaAppMassagistPage);
        List<SpaAppMassagist> records = massagistPage.getRecords();
        return new BaseResult(records);
    }
}

