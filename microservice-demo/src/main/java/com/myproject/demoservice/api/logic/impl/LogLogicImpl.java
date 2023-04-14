package com.myproject.demoservice.api.logic.impl;

import com.myproject.demoservice.api.logic.LogLogic;
import com.myproject.models.demoservice.entity.LogEntity;
import com.myproject.models.demoservice.service.LogService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LogLogicImpl implements LogLogic {

    @Autowired
    LogService logService;


    @Override
    public void export(Map<String, Object> params, HttpServletResponse response) {
        List<LogEntity> list = logService.list();
        String fileName = "日志信息";
        String sheetname = "日志信息";
        String[] title = new String[]{"id", "uid","operate_type","opeate_detail", "create_time"};

        List<List<Object>> content = new ArrayList<>();
        //遍历要导出的数据列表，构造表单内容
        list.forEach(e -> {
            List<Object> row = new ArrayList<>();
            row.add(e.getId());
            row.add(e.getUid());
            row.add(e.getOperateType());
            row.add(e.getOpeateDetail());
            row.add(e.getCreateTime());
            content.add(row);
        });

        Workbook workbook = getWorkbook(sheetname,title,content);

        //声明输出流
        OutputStream outputStream = null;
        //响应到客户端
        try {
            //设置响应头
            response.setHeader("filename", URLEncoder.encode(fileName, "utf-8") + ".xlsx");
            response.addHeader("Access-Control-Expose-Headers", "filename");
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "UTF-8") + ".xlsx" );
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");

            //获取输出流
            outputStream = response.getOutputStream();

            //用文档写输出流
            workbook.write(outputStream);
            //刷新输出流
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭输出流
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Workbook getWorkbook(String sheetname, String[] title, List<List<Object>> content){
        //新建文档实例
        XSSFWorkbook workbook1 = new XSSFWorkbook();
        SXSSFWorkbook workbook = new SXSSFWorkbook(workbook1 , 1000);
        //在文档中添加表单
        SXSSFSheet sheet = workbook.createSheet(sheetname);
        //创建单元格格式，并设置居中
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);

        //创建第一行，用于填充标题
        SXSSFRow titleRow = sheet.createRow(0);
        //填充标题
        for (int i=0 ; i<title.length ; i++) {
            //创建单元格
            Cell cell = titleRow.createCell(i);
            //设置单元格内容
            cell.setCellValue(title[i]);
            //设置单元格样式
            cell.setCellStyle(style);
        }

        //填充内容
        for (int i=0 ; i<content.size() ; i++) {
            //创建行
            SXSSFRow row = sheet.createRow(i+1);
            //遍历某一行
            List<Object> rowContent = content.get(i);
            for (int j=0 ; j<rowContent.size() ; j++) {
                //创建单元格
                Cell cell = row.createCell(j);
                //设置单元格内容
                if (rowContent.get(j) == null) {
                    cell.setCellValue("");
                } else if (rowContent.get(j) instanceof Double) {
                    cell.setCellValue(Double.parseDouble(rowContent.get(j).toString()));
                }else {
                    cell.setCellValue(rowContent.get(j).toString());
                }
                //设置单元格样式
                cell.setCellStyle(style);
            }
        }
        return workbook;
    }

}
