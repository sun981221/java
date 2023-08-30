package com.example.demo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class Person implements Serializable {
    public List<String> rowName;
    public List<String>  rowValue;
    //姓名
    public String customerName;
    //联系电话
    public String initialPhone;
    //行数
    public long  num;
    //变量
    public Map<String,String> variable;

}
