package com.gs.utils;

import org.junit.Test;

import java.io.InputStream;
import java.util.*;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-6-24 下午7:53
 */
public class PDFUtilTest {

    @Test
    public void createPDF() throws Exception {
        Map map = new HashMap<String, Object>();
        map.put("test", "测试");
        Properties prop = new Properties();
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("application.properties");
        prop.load(in);
        String file = prop.getProperty("html.path");
        // ByteArrayOutputStream baos = PDFUtil.createPDF(file, map);
    }

    @Test
    public void test() throws Exception {
        Properties prop = new Properties();
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("application.properties");
        prop.load(in);
        String KEY = prop.getProperty("pwd_key");
        String iv = prop.getProperty("pwd_iv");
        String content = "yushi123";
        System.out.println("加密前：" + content);
        String encrypt = AESUtils.aesEncrypt(content, KEY, iv);
        System.out.println("加密后：" + encrypt);
        String decrypt = AESUtils.aesDecrypt("z88+PYJSt+hW6kGr/Y3EEA==", KEY, iv);
        System.out.println("解密后：" + decrypt);
    }

    @Test
    public void test2() {
        List<String> oldPath = new ArrayList<String>();
        String pwd = "P8dbajKutLuQdGkBjXcEsg==";
        oldPath.add("/home/zhourui/down/a1.pdf");
        oldPath.add("/home/zhourui/down/a2.pdf");
        oldPath.add("/home/zhourui/down/test.pdf");
        String newPath = "/home/zhourui/down/pdf";
        String zipPath = newPath + ".zip";
        ZipUtils.copyResource(oldPath, newPath);
        ZipUtils.createZip(newPath, zipPath);
    }
    @Test
    public void testw(){
        String a="1001";
        System.out.println(Integer.valueOf(a)+1);
        String prefix="^[a-zA-z]+[A-Za-z0-9]{5,18}+$";
        //纯小写字母
        String p1="abcdef";
        //大写加小写字母
        String p2="Abcdef";
        //小写加数字
        String p3="abcdef123";
        //大写加数字
        String p4="ABC123";
        //大写小写加数字
        String p5="ABCdef123";
        //纯数字
        String p6="123456";
        //纯大写
        String p7="ABCDEF";
        String p8="acbadjdj123iididos";
        String p9="12daf";
        if(("aaaaaaa").matches(prefix)) {
            System.out.println("密码为6至18位小写字母, 大写字母和数字的组合");
        } else {
            System.out.println("匹配失败");
        }
        Double d=3645.9340;
        System.out.println(String.format("%.2f",d));
    }
}