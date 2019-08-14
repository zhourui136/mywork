package com.example.pdfdemo.utils;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-7-1 下午6:36
 */
public class DemoTest {
    @Test
    public void Test() {
//        Long a = Long.valueOf("1");
//        System.err.println(a);
//        Long[] array = {a, 2L, 3L};
//        List<Long> list = Arrays.asList(array);
//        list.forEach(System.out::println);
//        Long[] arr=null;
//        List<Long> list=Arrays.asList(arr);
//        for(Long l:list){
//            System.out.println(l);
//        }
        Long time1=1561966140000L;
        Long time2=1561967520000L;
        Long time=time2-time1;
        System.err.println(new SimpleDateFormat("yyyyMMdd").format(new Date(time)));
        List<Integer> failDatas= Lists.newArrayList();
        failDatas.add(0);
        failDatas.add(1);
        List<Integer> successDatas= Lists.newArrayList();
        successDatas.add(2);
        successDatas.add(3);
        List<Integer> datas=Lists.newArrayList();
        datas.addAll(failDatas);
        datas.addAll(successDatas);
        datas.forEach(System.err::println);
        System.err.println(datas.size());
    }
}
