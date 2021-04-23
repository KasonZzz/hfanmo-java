package cn.hfanmo.lzspa.pojo.massagist;

import cn.hfanmo.lzspa.util.serializer.LongJsonDeserializer;
import cn.hfanmo.lzspa.util.serializer.LongJsonSerializer;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 按摩师
 * </p>
 *
 * @author KasonZzz
 * @since 2021-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_spa_app_massagist")
@ApiModel(value="SpaAppMassagist对象", description="按摩师")
public class SpaAppMassagist extends Model<SpaAppMassagist> {

    @ApiModelProperty(value = "唯一ID",example = "01372355291265462274")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "真实姓名")
    private String name;

    @ApiModelProperty(value = "头像")
    private String massAvatar;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "联系方式")
    private String massTel;

    @ApiModelProperty(value = "居住地址")
    private String adress;

    @ApiModelProperty(value = "经验")
    private String experience;

    @ApiModelProperty(value = "标签")
    private String tag;

    @ApiModelProperty(value = "个性签名")
    private String signature;

    @ApiModelProperty(value = "纬度")
    private String lat;

    @ApiModelProperty(value = "经度")
    private String lon;

    @ApiModelProperty(value = "健康码")
    private String healthCode;

    @ApiModelProperty(value = "状态（0正常，1封禁）",example = "1")
    private Integer status;

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

    @TableField(exist = false)
    private List<SpaAppMassPic> spaAppMassPics;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
