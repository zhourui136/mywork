package com.example.pdfdemo.utils;

import com.itextpdf.text.DocumentException;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * @author zhourui
 * @version 1.0
 * @date 19-6-30 下午7:08
 */
public class pdfUtilsTest {

    @Test
    public void htmlToPdf() throws IOException, DocumentException {
        String html = "<html lang=\"en\">\n" +
                "                                    <head>\n" +
                "                                        <meta charset=\"UTF-8\"/>\n" +
                "                                        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n" +
                "                                        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\"/>\n" +
                "                                        <title>Document</title>\n" +
                "                                    </head>\n" +
                "                                    <body>\n" +
                "                                        <div data-v-a4b238b4=\"\" class=\"daily_elfo\" style=\"margin: 10px 0px; padding-bottom: 20px; border: 1px dashed rgb(153, 153, 153); text-align: center; background: rgb(255, 255, 255);\"><div data-v-a4b238b4=\"\" style=\"border: none; outline: medium; width: 100%; height: 36px; line-height: 36px; text-align: center; margin: 5px 0px; font-size: 16px;\">\n" +
                "                                        ut nisi elit nulla\n" +
                "                                    </div><div data-v-a4b238b4=\"\" style=\"border: 1px dashed rgb(153, 153, 153); margin-left: 10px; margin-right: 10px;\"></div><div data-v-a4b238b4=\"\"><div data-v-a4b238b4=\"\" style=\"width: 80%; margin-left: 10%; margin-top: 20px; border: 1px dashed rgb(204, 204, 204); text-align: left;\"><div data-v-a4b238b4=\"\" style=\"width: 72%; margin-left: 8%; align-items: center;\"><div data-v-a4b238b4=\"\" style=\"border: none; outline: medium; width: 30%; height: 36px; line-height: 36px; margin: 5px 0px; font-size: 16px;\">\n" +
                "                                                    axs\n" +
                "                                                </div></div><div data-v-a4b238b4=\"\" style=\"text-indent: 1em; width: 72%; height: 30px; line-height: 30px; margin-bottom: 10px; margin-left: 8%; border: 1px solid rgb(204, 204, 204);\">\n" +
                "                                                哪里能放到拉萨\n" +
                "                                            </div></div><!----><!----></div><div data-v-a4b238b4=\"\"><!----><div data-v-a4b238b4=\"\" style=\"width: 80%; margin-left: 10%; margin-top: 20px; border: 1px dashed rgb(204, 204, 204); text-align: left; padding-bottom: 8px;\"><div data-v-a4b238b4=\"\" style=\"width: 72%; margin-left: 8%; align-items: center;\"><div data-v-a4b238b4=\"\" style=\"border: none; outline: medium; width: 30%; height: 36px; line-height: 36px; margin: 5px 0px; font-size: 16px;\">\n" +
                "                                                    axs\n" +
                "                                                </div></div><div data-v-a4b238b4=\"\"><div data-v-a4b238b4=\"\" style=\"width: 72%; margin-left: 8%; align-items: center;\"><div data-v-a4b238b4=\"\" style=\"border: none; outline: medium; width: 30%; height: 36px; line-height: 36px; margin: 1px 0px; font-size: 16px;\">\n" +
                "                                                        wenti\n" +
                "                                                    </div></div><div data-v-a4b238b4=\"\" style=\"text-indent: 1em; width: 72%; height: 30px; line-height: 30px; margin-bottom: 10px; margin-left: 8%; border: 1px solid rgb(204, 204, 204);\">\n" +
                "                                                    v 发送打开女方克里斯蒂\n" +
                "                                                </div></div><div data-v-a4b238b4=\"\"><div data-v-a4b238b4=\"\" style=\"width: 72%; margin-left: 8%; align-items: center;\"><div data-v-a4b238b4=\"\" style=\"border: none; outline: medium; width: 30%; height: 36px; line-height: 36px; margin: 1px 0px; font-size: 16px;\">\n" +
                "                                                        xsavy\n" +
                "                                                    </div></div><div data-v-a4b238b4=\"\" style=\"text-indent: 1em; width: 72%; height: 30px; line-height: 30px; margin-bottom: 10px; margin-left: 8%; border: 1px solid rgb(204, 204, 204);\">\n" +
                "                                                    不是 v 风刀霜剑方便\n" +
                "                                                </div></div></div><!----></div><div data-v-a4b238b4=\"\"><!----><!----><div data-v-a4b238b4=\"\" style=\"width: 80%; margin-left: 10%; margin-top: 20px; border: 1px dashed rgb(204, 204, 204); text-align: left;\"><div data-v-a4b238b4=\"\" style=\"width: 72%; margin-left: 8%; align-items: center;\"><div data-v-a4b238b4=\"\" style=\"border: none; outline: medium; width: 30%; height: 36px; line-height: 36px; margin: 5px 0px; font-size: 16px;\">\n" +
                "                                                    axs\n" +
                "                                                </div></div><div data-v-a4b238b4=\"\" style=\"width: 72%; min-height: 30px; margin-bottom: 10px; margin-left: 8%;\"><!----></div></div></div></div>\n" +
                "                                    </body>\n" +
                "                                </html>";
        Properties properties = new Properties();
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("application.properties");
        properties.load(in);
        String fontPath = properties.getProperty("fontPath");
        new pdfUtils().htmlToPdf(html, fontPath);
    }
}