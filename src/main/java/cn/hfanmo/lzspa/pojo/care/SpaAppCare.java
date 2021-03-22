package cn.hfanmo.lzspa.pojo.care;

import cn.hfanmo.lzspa.util.serializer.LongJsonDeserializer;
import cn.hfanmo.lzspa.util.serializer.LongJsonSerializer;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 我的关注表
 * </p>
 *
 * @author KasonZzz
 * @since 2021-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_spa_app_care")
@ApiModel(value="SpaAppCare对象", description="我的关注表")
public class SpaAppCare extends Model<SpaAppCare> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一ID")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "名字")
    private String name;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
