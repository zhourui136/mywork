package com.excel.infra.utils;

import com.alibaba.excel.metadata.Sheet;
import com.excel.enums.WeekEnum;
import com.excel.model.Account;
import com.excel.model.MultipleSheelPropety;
import com.excel.model.Record;
import com.excel.model.User;
import org.apache.poi.hssf.usermodel.*;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class ExcelUtilsTest {

    @Test
    public void readLessThan1000Row() {
        String path = "/home/zhourui/down/account.xlsx";
        Long start = System.currentTimeMillis();
        List<Object> objects = ExcelUtils.readLessThan1000Row(path);
        Long end = System.currentTimeMillis();
        System.err.println("读取excel表数据总用时" + (end - start) + "毫秒");
        objects.forEach(System.out::println);
    }

    @Test
    public void testRead() {
        String path = "/home/zhourui/down/account.xlsx";
        //第一个1代表sheet1, 第二个1代表从第几行开始读取数据，行号最小值为0
        Sheet sheet = new Sheet(1, 1);
        List<Object> objects = ExcelUtils.readLessThan1000Row(path, sheet);
        objects.forEach(System.out::println);
    }

    @Test
    public void readMoreThan1000Row() throws Exception {
        Long poiStart = System.currentTimeMillis();
        String path = "/home/zhourui/down/account.xlsx";
        List list = PoiUtils.readExcel(path);
        Long poiEnd = System.currentTimeMillis();
        System.err.println("poi读取该文件花费时长" + (poiEnd - poiStart) + "毫秒");
        list.forEach(System.out::println);
    }

    @Test
    public void writeBySimple() {
        String path = "/home/zhourui/down/data.xlsx";
        List<List<Object>> data = new ArrayList<>();
        data.add(Arrays.asList("111", "李婷", "21"));
        data.add(Arrays.asList("112", "张娜", "19"));
        data.add(Arrays.asList("113", "汪华", "20"));
        List<String> head = Arrays.asList("id", "name", "age");
        ExcelUtils.writeBySimple(path, data, createHeadList(1L,1L));
    }

    @Test
    public void writeWithTemplate() {
        String path = "/home/zhourui/down/账号表.xlsx";
        List<Account> accountList = new ArrayList<Account>();
        for (int i = 1; i < 1000000; i++) {
            Account account = new Account();
            account.setAccountNumber(1000 + i);
            account.setNickName("test" + i);
            account.setName("wang" + i);
            account.setPhone("1314531248" + i);
            accountList.add(account);
        }
        Long start = System.currentTimeMillis();
        ExcelUtils.writeWithTemplate(path, accountList);
        System.err.println("写100000条数据耗时" + (System.currentTimeMillis() - start) + "毫秒");
        System.err.println("一共" + accountList.size() + "条有效数据");
    }

    @Test
    public void writeWithMultipleSheel() {
        String path = "/home/zhourui/down/王者荣耀账号表.xlsx";
        List<MultipleSheelPropety> list = new ArrayList<>();
        Sheet sheet1 = new Sheet(1, 1);
        sheet1.setSheetName("考勤汇总表");
        Sheet sheet2 = new Sheet(2, 1);
        sheet2.setSheetName("考勤明细表");
        List<List<String>> headList = new ArrayList<>();
        List<String> head = new ArrayList<>();
        Date date= new Date(System.currentTimeMillis());
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int w=calendar.get(Calendar.DAY_OF_WEEK)-1;
        int m=calendar.get(Calendar.MONTH)+1;
        if(w<0){
            w=0;
        }
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        //String  weekDay=weekDays[w];
        Map<String,String> map=new HashMap<>();
        for(int i=w;i<calendar.getActualMaximum(Calendar.DAY_OF_MONTH);i++){
            calendar.add(Calendar.DATE,1);
            String weekDay=weekDays[calendar.get(Calendar.DAY_OF_WEEK-1)];
            map.put(""+calendar.get(Calendar.MONTH)+calendar.get(Calendar.DAY_OF_MONTH),weekDay);
        }
        head.add("日期");
        for (int n = 1; n <= 31; n++) {
            head.add(m + "月" + n + "日");
        }
        List<Map> head2 = new ArrayList<>();
        head2.add(map);
        head.forEach(h -> headList.add(Collections.singletonList(h)));
        sheet2.setHead(headList);
        MultipleSheelPropety multipleSheetPropelsOne = new MultipleSheelPropety();
        multipleSheetPropelsOne.setSheet(sheet1);
        MultipleSheelPropety multipleSheetPropelsTwo = new MultipleSheelPropety();
        multipleSheetPropelsTwo.setSheet(sheet2);
        List<Account> accountList = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            Account account = new Account();
            account.setAccountNumber(100 + i);
            account.setName("name" + i);
            account.setNickName("nickname" + i);
            account.setPhone("1834673" + i);
            accountList.add(account);
        }
        multipleSheetPropelsOne.setData(accountList);
        multipleSheetPropelsTwo.setData(accountList);
        list.add(multipleSheetPropelsOne);
        list.add(multipleSheetPropelsTwo);
        ExcelUtils.writeWithMultipleSheel(path, list);
    }

    @Test
    public void writeBySimple1() {
        String path = "/home/zhourui/down/导出账号表.xlsx";
        List<List<Object>> data = new ArrayList<List<Object>>();
        Long diff=1569389626000L-1566797626000L;
        int day = (int) (diff / (24 * 60 * 60 * 1000));
        List<Record> recordList=new ArrayList<>();
        for(int i=1;i<day;i++){
            Record record=new Record().setCheckType("上班").setOnDutyIsNormal("√").setOffDutyIsNormal("√");
            recordList.add(record);
        }
        User user1=new User();
        user1.setNumber(1001).setName("李华").setDeptName("技术部").setGroup("官网").setInDate("2019-04-12")
                .setOutDate("").setRecordList(recordList);
        User user2=new User();
        user2.setNumber(1002).setName("张强").setDeptName("技术部").setGroup("创新业务部").setInDate("2019-05-12")
                .setOutDate("").setRecordList(recordList);
        List<User> userList=new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        for(User user:userList){
            List<Object> list2 = new ArrayList<>();
            list2.add(user.getNumber());
            list2.add(user.getName());
            list2.add(user.getDeptName());
            list2.add(user.getGroup());
            list2.add(user.getInDate());
            list2.add(user.getOutDate());
            for(int i=0;i<user.getRecordList().size();i++){
                list2.add(user.getRecordList().get(i).getOnDutyIsNormal());
                list2.add(user.getRecordList().get(i).getOffDutyIsNormal());
            }
            data.add(list2);
        }
        Long startTime=System.currentTimeMillis();
        ExcelUtils.writeBySimple(path, data, createHeadList(1566797626000L,1569389626000L));
        Long endTime=System.currentTimeMillis();
        System.out.println("导出excel用时"+(endTime-startTime)+"毫秒");
    }

    @Test
    public void test() {
        String date1 = new SimpleDateFormat("yyyyMMdd").format(new Date(1563502860000L));
        String date2 = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
        Long diff = System.currentTimeMillis() - 1563502860000L;
        System.err.println((int) (diff / (24 * 60 * 60 * 1000)));
        System.err.println(Integer.valueOf(date2) - Integer.valueOf(date1));
        Date date=new Date(1565922134000L);
        Instant instant=date.toInstant();
        ZoneId zoneId=ZoneId.systemDefault();
        LocalDateTime localDateTime= LocalDateTime.ofInstant(instant,zoneId);
        LocalDate localDate=localDateTime.toLocalDate();
        System.out.println(localDate.plusDays(17));
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getDayOfMonth());
    }
    private List<List<String>> createHeadList(Long startTime,Long endTime){
        List<String> headColumn1=  new ArrayList<>();
        List<String> headColumn2 = new ArrayList<>();
        List<String> headColumn3 = new ArrayList<>();
        List<String> headColumn4 = new ArrayList<>();
        List<String> headColumn5 = new ArrayList<>();
        List<String> headColumn6 = new ArrayList<>();

        headColumn1.add("日期");headColumn1.add("星期");headColumn1.add("序号");
        headColumn2.add(" ");headColumn2.add("");headColumn2.add("姓名");
        headColumn3.add("");headColumn3.add(" ");headColumn3.add("部门");
        headColumn4.add(" ");headColumn4.add("");headColumn4.add("组别");
        headColumn5.add("");headColumn5.add(" ");headColumn5.add("入职日期");
        headColumn6.add("");headColumn6.add("");headColumn6.add("离职日期");

        Long diff=endTime-startTime;
        int day = (int) (diff / (24 * 60 * 60 * 1000));
        List<List<String>> headList=new ArrayList<>();

        headList.add(headColumn1);
        headList.add(headColumn2);
        headList.add(headColumn3);
        headList.add(headColumn4);
        headList.add(headColumn5);
        headList.add(headColumn6);

        for(int i=1;i<day;i++){
            List<String> head1=new ArrayList<>();
            List<String> head2=new ArrayList<>();
            Date date=new Date(startTime);
            Instant instant=date.toInstant();
            ZoneId zoneId=ZoneId.systemDefault();
            LocalDateTime localDateTime= LocalDateTime.ofInstant(instant,zoneId);
            LocalDate localDate=localDateTime.toLocalDate();
            localDate=localDate.plusDays(i);
            head1.add(""+localDate.getMonth().getValue()+"月"+localDate.getDayOfMonth()+"日");
            head1.add(""+ WeekEnum.getEnum(localDate.getDayOfWeek().getValue()).getMessage());
            head1.add("上班");
            head2.add(""+localDate.getMonth().getValue()+"月"+localDate.getDayOfMonth()+"日");
            head2.add(""+WeekEnum.getEnum(localDate.getDayOfWeek().getValue()).getMessage());
            head2.add("下班");
            headList.add(head1);
            headList.add(head2);
        }
        return headList;
    }
    @Test
    public void pomExcelOperation(){
        try {
            //获取当前日期
            Calendar calendar = Calendar.getInstance();
            //当前月份
            int month = calendar.get(Calendar.MONTH) + 1;
            //设置现在日期为本月1号
            calendar.set(Calendar.DATE, 1);
            //设置月份为下一个月
            calendar.add(Calendar.MONTH, 1);
            //减一天为上月最后一天
            calendar.add(Calendar.DATE, -1);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            //获取本月有多少天
            int day = Integer.parseInt(df.format(calendar.getTime()).substring(8));
            String filePath = "/home/zhourui/down/考勤表.xlsx";
            HSSFWorkbook workbook = null;
            File file = new File(filePath);
            if (!file.exists()) {
                file = new File(filePath);
                file.createNewFile();
                workbook = new HSSFWorkbook();
                //sheet的名字
                String sheetName = "admin";
                HSSFSheet hssfSheet = workbook.createSheet(sheetName);
                //创建第一行
                HSSFRow hssfRow = hssfSheet.createRow(0);
                String[] firstRow = {"工号", "姓名", "出勤日期", "上班时间", "下班时间", "说明"};
                HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
                HSSFFont hssfFont = workbook.createFont();
                //字体大小
                hssfFont.setFontHeightInPoints((short) 11);
                //加粗
                hssfFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                hssfCellStyle.setFont(hssfFont);
                //左右居中
                hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                //上下居中
                hssfCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
                //hssfRow.setRowStyle(hssfCellStyle);
                //创建单元格
                HSSFCell hssfCell = null;
                for (int i = 0; i < firstRow.length; i++) {
                    hssfCell = hssfRow.createCell(i);
                    hssfCell.setCellValue(firstRow[i]);
                    hssfCell.setCellStyle(hssfCellStyle);
                    //设置列宽，256表示每个字符大小
                    if (i == 0 || i == 2) {
                        hssfSheet.setColumnWidth(i, 15 * 256);
                    } else if (i == 1) {
                        hssfSheet.setColumnWidth(i, 10 * 256);
                    }
                }
                //从第二行开始创建
                for (int i = 1; i < day + 1; i++) {
                    String nowDate = calendar.get(Calendar.YEAR) + "-" + month + "-" + i;
                    hssfRow = hssfSheet.createRow(i);
                    HSSFCellStyle cellStyle = workbook.createCellStyle();
                    //左右居中
                    cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                    //上下居中
                    cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
                    //创建单元格
                    for (int j = 0; j < firstRow.length; j++) {
                        hssfCell = hssfRow.createCell(j);
                        hssfCell.setCellStyle(cellStyle);
                        if (j == 0) {
                            hssfCell.setCellValue("0000060316");
                        } else if (j == 1) {
                            hssfCell.setCellValue(sheetName);
                        } else if (j == 2) {
                            HSSFDataFormat hssfDataFormat = workbook.createDataFormat();
                            //HSSFCellStyle cellStyle = workbook.createCellStyle();
                            //格式化时间
                            //cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
                            //hssfCell.setCellStyle(cellStyle);
                            nowDate = calendar.get(Calendar.YEAR) + "-" + month + "-" + i;
                            hssfCell.setCellValue(df.format(df.parse(nowDate)));
                        } else if (j == 3 || j == 4) {
                            //设置日期
                            calendar.setTime(df.parse(nowDate));
                            //获取随机时间
                            Random random = new Random();
                            //判断周6，周日
                            if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY &&
                                    calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                                if (j == 3) {
                                    String moTime = "8:";
                                    int randomNum = random.nextInt(29);
                                    if (randomNum < 10) {
                                        if (randomNum == 0) {
                                            randomNum = 7;
                                        }
                                        moTime = moTime + "0" + randomNum;
                                    } else {
                                        moTime = moTime + randomNum;
                                    }
                                    hssfCell.setCellValue(moTime);
                                } else {
                                    String afTime = "18:";
                                    int num = random.nextInt(40);
                                    if (num < 10) {
                                        if (num == 0) {
                                            num = 7;
                                        }
                                        afTime = afTime + "0" + num;
                                    } else {
                                        afTime = afTime + num;
                                    }
                                    hssfCell.setCellValue(afTime);
                                }
                            }
                        } else if (j == 5) {
                            //设置日期
                            calendar.setTime(df.parse(nowDate));
                            //判断周6，周日
                            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                                    calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                                hssfCell.setCellValue("周末");
                            }
                        }
                    }
                }
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                workbook.write(fileOutputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}