package cn.hfanmo.lzspa.util;

import cn.hfanmo.lzspa.pojo.common.AliSms;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;


@Component
@Slf4j
public class AliSmsUtil {

    private String ACCESSKEY = "LTAI4GBfuSJUsnuYoHZXfNyF";
    private String ACCESSSECRET = "cuN9l2ocFN8PebdAhHTSFK1kjklDqv";

    /**
     * ak
     */
    @Value("${ali.accessKey}")
    private String accessKey;
    /**
     * sk
     */
    @Value("${ali.secretKey}")
    private String secretKey;


    public void sendSms(AliSms aliSms) {
        IAcsClient iAcsClient = getIAcsClient();
        CommonRequest request = getRequest(aliSms);
        try {
            CommonResponse response = iAcsClient.getCommonResponse(request);
            log.info("阿里云短信返回：{}", response.getData());
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    public IAcsClient getIAcsClient() {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKey, secretKey);
        return new DefaultAcsClient(profile);
    }

    public CommonRequest getRequest(AliSms aliSms) {
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");

        if (!ObjectUtils.isEmpty(aliSms.getRegionId())) {
            request.putQueryParameter("RegionId", aliSms.getRegionId());
        }
        if (!ObjectUtils.isEmpty(aliSms.getPhoneNumbers())) {
            request.putQueryParameter("PhoneNumbers", aliSms.getPhoneNumbers());
        }
        if (!ObjectUtils.isEmpty(aliSms.getSignName())) {
            request.putQueryParameter("SignName", aliSms.getSignName());
        }
        if (!ObjectUtils.isEmpty(aliSms.getTemplateCode())) {
            request.putQueryParameter("TemplateCode", aliSms.getTemplateCode());
        }
        if (!ObjectUtils.isEmpty(aliSms.getTemplateParam())) {
            request.putQueryParameter("TemplateParam", aliSms.getTemplateParam());
        }
        if (!ObjectUtils.isEmpty(aliSms.getSmsUpExtendCode())) {
            request.putQueryParameter("SmsUpExtendCode", aliSms.getSmsUpExtendCode());
        }
        if (!ObjectUtils.isEmpty(aliSms.getOutId())) {
            request.putQueryParameter("OutId", aliSms.getOutId());
        }

        return request;
    }


    public static CommonRequest getAliCommonRequest(String regionId, String phoneNumbers, String SignName, String TemplateCode, String TemplateParam, String OutId, String SmsUpExtendCode) {
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        if (!ObjectUtils.isEmpty(regionId)) {
            request.putQueryParameter("RegionId", regionId);
        }
        if (!ObjectUtils.isEmpty(phoneNumbers)) {
            request.putQueryParameter("PhoneNumbers", phoneNumbers);
        }
        if (!ObjectUtils.isEmpty(SignName)) {
            request.putQueryParameter("SignName", SignName);
        }
        if (!ObjectUtils.isEmpty(TemplateCode)) {
            request.putQueryParameter("TemplateCode", TemplateCode);
        }
        if (!ObjectUtils.isEmpty(TemplateParam)) {
            request.putQueryParameter("TemplateParam", TemplateParam);
        }
        if (!ObjectUtils.isEmpty(SmsUpExtendCode)) {
            request.putQueryParameter("SmsUpExtendCode", SmsUpExtendCode);
        }
        if (!ObjectUtils.isEmpty(OutId)) {
            request.putQueryParameter("OutId", OutId);
        }

        return request;
    }


    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4GBfuSJUsnuYoHZXfNyF", "cuN9l2ocFN8PebdAhHTSFK1kjklDqv");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "18351964001");
        request.putQueryParameter("SignName", "cutenine");
        request.putQueryParameter("TemplateCode", "SMS_206535433");
        request.putQueryParameter("TemplateParam", "{\"code\":\"666666\"}");
//        request.putQueryParameter("SmsUpExtendCode", "963852");
//        request.putQueryParameter("OutId", "55559847");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }


}
