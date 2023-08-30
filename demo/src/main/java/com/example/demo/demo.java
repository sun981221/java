package com.example.demo;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/demo")
public class demo {
    @RequestMapping("/buildPhone")
    public ResultData buildPhone(@RequestBody Person person) throws IOException {
        try {
            // key 转 List
            person.setRowName(new ArrayList<>(person.getVariable().keySet()));
            // value 转 List
            person.setRowValue(new ArrayList<>(person.getVariable().values()));
            // 创建表格对象
            Workbook workbook = new SXSSFWorkbook();
            Sheet sheet = workbook.createSheet("个人信息表");
            //判断行头大小
            int size = person.getRowName().size();
            // 自定义表头
            String[] headers = new String[size+2];
            headers[0] = "客户名";
            headers[1] = "联系电话";
            for (int i = 2; i < size+2; i++) {
                headers[i] = person.getRowName().get(i-2);
            }
            // 格式化表头单元格
            CellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());

            // 创建表头行
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
                headerRow.getCell(i).setCellStyle(style);
            }

            // 随机生成测试数据列表
            List<RowData> dataList = generateData(person);

            // 将数据写入表格
            for (int i = 0; i < dataList.size(); i++) {
                RowData row = dataList.get(i);
                Row dataRow = sheet.createRow(i + 1);
                dataRow.createCell(0).setCellValue(row.getRow1());
                dataRow.createCell(1).setCellValue(row.getRow2());
                dataRow.createCell(2).setCellValue(row.getRow3());
                dataRow.createCell(3).setCellValue(row.getRow4());
                dataRow.createCell(4).setCellValue(row.getRow5());
                dataRow.createCell(5).setCellValue(row.getRow6());
                dataRow.createCell(6).setCellValue(row.getRow7());
                dataRow.createCell(7).setCellValue(row.getRow8());
                dataRow.createCell(8).setCellValue(row.getRow9());
                dataRow.createCell(9).setCellValue(row.getRow10());
            }

            // 将表格写入文件
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddHHmmss");
            FileOutputStream outputStream = new FileOutputStream("\\Users\\sun\\Desktop\\导入客户数据表_"
                    + now.format(formatter)+".xls");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        }catch (Exception e){
            return ResultData.fail(0,e.getMessage());
        }
        return ResultData.success();
}

    public static List<RowData> generateData(Person person) {
        List<String> value=person.getRowValue();
        int size=person.getRowValue().size();
        for(int i=10;i>size+2;i--){
            value.add(null);
        }
        List<RowData> dataList = new ArrayList<>();
        long telephone= Long.parseLong(person.getInitialPhone());
        for(long i=0;i<person.getNum();i++) {
            RowData rowData=new RowData();
            rowData.setRow1((null==person.getCustomerName()||"".equals(person.getCustomerName())) ? null:person.getCustomerName());
            if(i!=0) {
                rowData.setRow2(String.valueOf(telephone+i));
            }else{
                rowData.setRow2(String.valueOf(telephone));
            }
            rowData.setRow3((null==value.get(0)||"".equals(value.get(0))) ? null:value.get(0));
            rowData.setRow4((null==value.get(1)||"".equals(value.get(1))) ? null:value.get(1));
            rowData.setRow5((null==value.get(2)||"".equals(value.get(2))) ? null:value.get(2));
            rowData.setRow6((null==value.get(3)||"".equals(value.get(3))) ? null:value.get(3));
            rowData.setRow7((null==value.get(4)||"".equals(value.get(4))) ? null:value.get(4));
            rowData.setRow8((null==value.get(5)||"".equals(value.get(5))) ? null:value.get(5));
            rowData.setRow9((null==value.get(6)||"".equals(value.get(6))) ? null:value.get(6));
            rowData.setRow10((null==value.get(7)||"".equals(value.get(7))) ? null:value.get(7));
            dataList.add(rowData);
        }
        return dataList;
    }
}