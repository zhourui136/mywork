package com.example.pdfdemo.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-6-27 下午5:42
 */
public class ZipUtils {

    public static void createZip(String sourcePath, String zipPath) {
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        try {
            fos = new FileOutputStream(zipPath);
            zos = new ZipOutputStream(fos);
            writeZip(new File(sourcePath), "", zos);
        } catch (FileNotFoundException e) {
            System.err.println("ZipUtils createZip  Failed to create ZIP file" + e);
        } finally {
            try {
                if (zos != null) {
                    System.out.println("ZipUtils createZip Create a ZIP file successfully! the path in:{}" + zipPath);
                    zos.close();
                    //压缩成功后，删除打包前的文件
                    deleteFile(new File(sourcePath));
                }
            } catch (IOException e) {
                System.err.println("ZipUtils createZip  Failed to create ZIP file" + e);
            }
        }
    }

    public static void deleteFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                File files[] = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    deleteFile(files[i]);
                }
            }
            file.delete();
        }
    }

    private static void writeZip(File file, String parentPath,
                                 ZipOutputStream zos) {
        if (file.exists()) {
            if (file.isDirectory()) {
                parentPath += file.getName() + File.separator;
                File[] files = file.listFiles();
                for (File f : files) {
                    writeZip(f, parentPath, zos);
                }
            } else {
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(file);
                    ZipEntry ze = new ZipEntry(parentPath + file.getName());
                    zos.putNextEntry(ze);
                    byte[] content = new byte[1024];
                    int len;
                    while ((len = fis.read(content)) != -1) {
                        zos.write(content, 0, len);
                        zos.flush();
                    }
                } catch (FileNotFoundException e) {
                    System.err.println("ZipUtils createZip  Failed to create ZIP file" + e);
                } catch (IOException e) {
                    System.err.println("ZipUtils createZip  Failed to create ZIP file" + e);
                } finally {
                    try {
                        if (fis != null) {
                            fis.close();
                        }
                    } catch (IOException e) {
                        System.err.println("ZipUtils createZip  Failed to create ZIP file" + e);
                    }
                }
            }
        }
    }

    public static void copyResource(List<String> oldResPath, String newResPath) {
        for (int m = 0; m < oldResPath.size(); m++) {
            try {
                // 如果文件夹不存在 则建立新文件夹
                (new File(newResPath)).mkdirs();
                File a = new File(oldResPath.get(m));
                // 如果已经是具体文件，读取
                if (a.isFile()) {
                    FileInputStream input = new FileInputStream(a);
                    FileOutputStream output = new FileOutputStream(newResPath + "/" + (a.getName()).toString());
                    byte[] b = new byte[1024 * 4];
                    int len;
                    while ((len = input.read(b)) != -1) {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                    // 如果文件夹下还存在文件，遍历，直到得到具体的文件
                } else {
                    String[] file = a.list();
                    File temp = null;
                    for (int i = 0; i < file.length; i++) {
                        if (oldResPath.get(m).endsWith(File.separator)) {
                            temp = new File(oldResPath.get(m) + file[i]);
                        } else {
                            temp = new File(oldResPath.get(m) + File.separator + file[i]);
                        }

                        if (temp.isFile()) {
                            FileInputStream input = new FileInputStream(temp);
                            FileOutputStream output = new FileOutputStream(newResPath + "/" + (temp.getName()).toString());
                            byte[] b = new byte[1024 * 4];
                            int len;
                            while ((len = input.read(b)) != -1) {
                                output.write(b, 0, len);
                            }
                            output.flush();
                            output.close();
                            input.close();
                        }
                        if (temp.isDirectory()) {
                            List<String> oldChildPath = new ArrayList<String>();
                            oldChildPath.add(oldResPath.get(m) + "/" + file[i]);
                            newResPath = newResPath + "/" + file[i];
                            // 如果是子文件夹 递归循环
                            copyResource(oldChildPath, newResPath);
                        }
                    }
                }
            } catch (Exception e) {
                System.err.println("copy all files failed" + e);
            }
        }
    }
}
