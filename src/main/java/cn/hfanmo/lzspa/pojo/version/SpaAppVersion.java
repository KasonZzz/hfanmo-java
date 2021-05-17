package cn.hfanmo.lzspa.pojo.version;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2021-05-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_spa_app_version")
@ApiModel(value="SpaAppVersion对象", description="")
public class SpaAppVersion extends Model<SpaAppVersion> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "版本")
    private String version;

    @ApiModelProperty(value = "安卓升级地址")
    @TableField("wgtUrl")
    private String wgtUrl;

    @ApiModelProperty(value = "ios升级地址")
    @TableField("pkgUrl")
    private String pkgUrl;

    @ApiModelProperty(value = "创建日期")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改日期")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建人")
    private Long createBy;

    @ApiModelProperty(value = "修改人")
    private Long updateBy;

    @TableField(exist = false)
    private boolean update;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
