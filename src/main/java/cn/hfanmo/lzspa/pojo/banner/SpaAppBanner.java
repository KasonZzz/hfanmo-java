package cn.hfanmo.lzspa.pojo.banner;

import cn.hfanmo.lzspa.util.serializer.LongJsonDeserializer;
import cn.hfanmo.lzspa.util.serializer.LongJsonSerializer;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 滚动图
 * </p>
 *
 * @author KasonZzz
 * @since 2021-03-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_spa_app_banner")
@ApiModel(value = "SpaAppBanner对象", description = "滚动图")
public class SpaAppBanner extends Model<SpaAppBanner> {

    @ApiModelProperty(value = "唯一ID",example = "01372355291265462274")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "图片地址")
    private String imgUrl;

    @ApiModelProperty(value = "描述")
    private String remark;

    @ApiModelProperty(value = "是否启用，0启用，1禁用，")
    private String status;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "创建人")
    private String createBy;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
