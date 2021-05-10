package cn.hfanmo.lzspa.pojo.product;

import java.math.BigDecimal;

import cn.hfanmo.lzspa.util.serializer.LongJsonDeserializer;
import cn.hfanmo.lzspa.util.serializer.LongJsonSerializer;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 产品表
 * </p>
 *
 * @author KasonZzz
 * @since 2021-04-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_spa_app_product")
@ApiModel(value="SpaAppProduct对象", description="产品表")
public class SpaAppProduct extends Model<SpaAppProduct> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一ID")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "描述")
    private String productDesc;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "时长")
    private Integer time;

    @ApiModelProperty(value = "创建日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT-8")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT-8")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建人")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long createBy;

    @ApiModelProperty(value = "修改人")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long updateBy;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
