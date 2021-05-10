package cn.hfanmo.lzspa.pojo.common;

import lombok.Data;

@Data
public class AliSms {

    /**
     * 区域id
     */
    private String regionId;

    /**
     * 手机号
     */
    private String phoneNumbers;

    /**
     * 签名
     */
    private String SignName;

    /**
     * 模板代码
     */
    private String TemplateCode;
    /**
     * 模板
     */
    private String TemplateParam;

    /**
     * 外部流水扩展字段
     */
    private String OutId;

    /**
     * 上行短信扩展码
     */
    private String SmsUpExtendCode;
}
