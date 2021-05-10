package cn.hfanmo.lzspa.pojo.file;

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
 * 系统图片表
 * </p>
 *
 * @author KasonZzz
 * @since 2021-04-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_spa_app_img")
@ApiModel(value="SpaAppImg对象", description="系统图片表")
public class SpaAppImg extends Model<SpaAppImg> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一ID")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "图片地址")
    private String url;

    @ApiModelProperty(value = "图片类型")
    private String type;

    @ApiModelProperty(value = "绑定ID可能是user也可能是其他")
    private Long bindId;

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
