package com.excel.infra.utils;

import com.alibaba.excel.metadata.Sheet;
import com.excel.model.Account;
import com.excel.model.MultipleSheelPropety;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
        ExcelUtils.writeBySimple(path, data, head);
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
        List<String> headers = new ArrayList<String>();
        headers.add("游戏id");
        headers.add("游戏区服id");
        headers.add("游戏名");
        headers.add("游戏等级");
        List<List<Object>> data = new ArrayList<List<Object>>();
        List<Object> list1 = new ArrayList<>();
        list1.add("1001");
        list1.add("1002");
        list1.add("1003");
        list1.add(30);
        List<Object> list2 = new ArrayList<>();
        list2.add("1001");
        list2.add("1002");
        list2.add("1003");
        list2.add(40);
        data.add(list1);
        data.add(list2);
        List<String> headerList = new ArrayList<>();
        headerList.add("游戏编号");
        headerList.add("游戏名称");
        headerList.add("区服名称");
        headerList.add("区服状态");
        headerList.add("创建时间");
        ExcelUtils.writeBySimple(path, data, headers);
    }

    @Test
    public void test() {
        String date1 = new SimpleDateFormat("yyyyMMdd").format(new Date(1563502860000L));
        String date2 = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
        Long diff = System.currentTimeMillis() - 1563502860000L;
        System.err.println((int) (diff / (24 * 60 * 60 * 1000)));
        System.err.println(Integer.valueOf(date2) - Integer.valueOf(date1));
        Date date = new Date();
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getDayOfMonth());
    }
}