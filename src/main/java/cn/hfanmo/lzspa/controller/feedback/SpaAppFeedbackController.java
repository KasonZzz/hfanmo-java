package cn.hfanmo.lzspa.controller.feedback;


import cn.hfanmo.lzspa.pojo.common.BaseResult;
import cn.hfanmo.lzspa.pojo.feedback.SpaAppFeedback;
import cn.hfanmo.lzspa.service.feedback.SpaAppFeedbackService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 反馈表 前端控制器
 * </p>
 *
 * @author kason
 * @since 2021-03-22
 */
@Api(value = "SpaAppFeedbackController", tags = "反馈表")
@RestController
@RequestMapping("/spaAppFeedback")
public class SpaAppFeedbackController {

    @Autowired
    private SpaAppFeedbackService spaAppFeedbackService;


    @ApiOperation("增")
    @PostMapping("add")
    public BaseResult add(List<SpaAppFeedback> spaAppFeedbacks) {
        spaAppFeedbackService.saveBatch(spaAppFeedbacks);
        return new BaseResult(200);
    }

    @ApiOperation("删")
    @PostMapping("del")
    public BaseResult delByIds(List<Long> ids) {
        spaAppFeedbackService.removeByIds(ids);
        return new BaseResult(200);
    }

    @ApiOperation("改")
    @PostMapping("updateById")
    public BaseResult updateById(SpaAppFeedback spaAppFeedback) {
        spaAppFeedbackService.updateById(spaAppFeedback);
        return new BaseResult(200);
    }

    @ApiOperation("分页查询")
    @GetMapping("getByPage")
    public BaseResult getByPage(Integer page, Integer pageSize) {
        Page<SpaAppFeedback> spaAppFeedbackPage = new Page<>(page, pageSize);
        Page<SpaAppFeedback> feedbackPage = spaAppFeedbackService.page(spaAppFeedbackPage);
        return new BaseResult(feedbackPage);
    }
}

