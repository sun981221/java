package com.example.demo;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ResultData <T> {
    //获取当前Time时间
    private LocalDateTime localDateTime = LocalDateTime.now();
    //返回状态码
    private String status;
    //返回消息
    private String message;
    //Success结果
    public static  <T> ResultData<T> success(){
        ResultData<T> resultData=new ResultData<>();
        resultData.setStatus("成功");
        resultData.setMessage("操作成功");
        return resultData;
    }
    //Fail结果
    public static <T> ResultData<T> fail(int code, String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus("失败");
        resultData.setMessage(message);
        return resultData;
    }
}