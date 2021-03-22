package cn.hfanmo.lzspa.pojo.feedback;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 反馈表
 * </p>
 *
 * @author kason
 * @since 2021-03-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_spa_app_feedback")
@ApiModel(value="SpaAppFeedback对象", description="反馈表")
public class SpaAppFeedback extends Model<SpaAppFeedback> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "反馈内容")
    private String fdInfo;

    @ApiModelProperty(value = "反馈者")
    private Long userId;

    @ApiModelProperty(value = "描述")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "创建人")
    private String createBy;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
