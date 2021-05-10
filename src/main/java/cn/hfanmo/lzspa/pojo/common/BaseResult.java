package cn.hfanmo.lzspa.pojo.common;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

/**
 * @Author KasonZzz
 * @Description //TODO
 * @Date 10:21 2020/7/22
 */
@Data
@ToString
@ApiModel(value = "统一返回格式：BaseResult")
public class BaseResult<T> {
    public static final int SUCCESS_CODE = 200;

    public static final int FAIL_CODE = 500;

    /**
     * 响应中的数据
     */
    private T data;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 响应业务状态
     */
    private Integer code;

    public BaseResult(T data, String msg, int code) {
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

    public BaseResult(String msg, Integer code) {
        this(null, msg, code);
    }

    public BaseResult(T data) {
        this.data = data;
        msg = "success";
        code = 200;
    }

    public BaseResult(Integer code) {
        String msg;
        switch (code) {
            case 200:
                msg = "success";
                break;
            case 400:
                msg = "bad request";
                break;
            case 401:
                msg = "401 Unauthorized";
                break;
            case 403:
                msg = "403 Forbidden";
                break;
            case 404:
                msg = "404 Not Found";
                break;
            case 4041:
                msg="用户不存在";
                break;
            case 500:
                msg = " Internal Server Error ";
                break;
            case 601:
                msg="验证码输入错误或验证码已过期";
                break;
            case 4001:
                msg = "Parameter verification failed";
                break;
            default:
                msg = "fail";
                break;
        }
        this.msg = msg;
        this.code = code;
    }

    /**
     * 快速创建成功结果，并返回数据
     *
     * @param data
     * @param message
     * @return
     */
    public static BaseResult success(Object data, String message) {
        return new BaseResult(data, message, SUCCESS_CODE);
    }

    /**
     * 快速创建失败结果，并返回数据
     *
     * @param data
     * @param message
     * @return
     */
    public static BaseResult fail(Object data, String message) {
        return new BaseResult(data, message, FAIL_CODE);
    }
}
