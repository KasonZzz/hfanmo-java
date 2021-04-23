package cn.hfanmo.lzspa.controller.comment;


import cn.hfanmo.lzspa.pojo.comment.SpaAppComment;
import cn.hfanmo.lzspa.pojo.common.BaseResult;
import cn.hfanmo.lzspa.service.comment.SpaAppCommentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 我的评论 前端控制器
 * </p>
 *
 * @author KasonZzz
 * @since 2021-04-22
 */
@RestController
@RequestMapping("/spaAppComment")
public class SpaAppCommentController {
    @Autowired
    private SpaAppCommentService spaAppCommentService;

    @PostMapping("add")
    public BaseResult add(@RequestBody SpaAppComment spaAppComment) {
        spaAppCommentService.save(spaAppComment);
        return new BaseResult(200);
    }

    @PostMapping("delByIds")
    public BaseResult delByIds(@RequestBody List<Long> ids) {
        spaAppCommentService.removeByIds(ids);
        return new BaseResult(200);
    }

    @PostMapping("updateById")
    public BaseResult updateById(@RequestBody SpaAppComment spaAppComment) {
        spaAppCommentService.updateById(spaAppComment);
        return new BaseResult(200);
    }

    @PostMapping("getCommentByProductId")
    public BaseResult getCommentByProductId(@RequestBody Long productId) {
        QueryWrapper<SpaAppComment> qr = new QueryWrapper<>();
        qr.eq("comment_id", productId);
        List<SpaAppComment> list = spaAppCommentService.list(qr);
        return new BaseResult(list);
    }

}

