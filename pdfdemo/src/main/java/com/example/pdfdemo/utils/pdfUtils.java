package com.example.pdfdemo.utils;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-6-30 下午7:00
 */
public class pdfUtils {

    public void htmlToPdf(String strline, String fontPath) throws IOException, DocumentException {
        String htmlString = "";
        //替换成这样的字体，如果不设置中文有可能显示不出来
        htmlString = strline.toString().replaceAll("\"", "'").replaceAll("<style>", "<style>body{font-family:SimSun;font-size:14px;}");
        //pdf生成路径
        OutputStream os = new FileOutputStream("/home/zhourui/down/ee.pdf");
        ITextRenderer renderer = new ITextRenderer();
        ITextFontResolver font = renderer.getFontResolver();
        //添加中文识别，这里是设置的宋体
        font.addFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        renderer.setDocumentFromString(htmlString);
        renderer.layout();
        renderer.createPDF(os);
        renderer.finishPDF();
    }
}
