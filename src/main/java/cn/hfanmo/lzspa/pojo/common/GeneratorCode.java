package cn.hfanmo.lzspa.pojo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "generatorcode", description = "代码生成")
public class GeneratorCode {

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "表名称。支持多个表名拼接，如：t_user_info,t_log", required = true)
    private String tableName;

    @ApiModelProperty(value = "包名称")
    private String packageName;

}