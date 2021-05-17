package cn.hfanmo.lzspa.pojo.massagist;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * 
 * </p>
 *
 * @author KasonZzz
 * @since 2021-05-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_spa_app_mass_product")
@ApiModel(value="SpaAppMassProduct对象", description="")
public class SpaAppMassProduct extends Model<SpaAppMassProduct> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "技师ID")
    private Long massId;

    @ApiModelProperty(value = "商品ID")
    private Long productId;

    @ApiModelProperty(value = "创建日期")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改日期")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建人")
    private Long createBy;

    @ApiModelProperty(value = "修改人")
    private Long updateBy;




    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
