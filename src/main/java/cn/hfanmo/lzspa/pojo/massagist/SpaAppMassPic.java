package cn.hfanmo.lzspa.pojo.massagist;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 技师图片表
 * </p>
 *
 * @author KasonZzz
 * @since 2021-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_spa_app_mass_pic")
@ApiModel(value = "SpaAppMassPic对象", description = "技师图片表")
public class SpaAppMassPic extends Model<SpaAppMassPic> {

    @ApiModelProperty(value = "唯一ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "图片地址")
    private String url;

    @ApiModelProperty(value = "技师ID")
    private Long massId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "创建人")
    private String createBy;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
