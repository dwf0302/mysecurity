package com.bree.web.controller;

import com.bree.web.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
//模拟文件的上传和下载
@RestController
@RequestMapping("/file")
public class FileController {
    private static  final String folder ="D:\\project\\security\\security-demo\\src\\main\\java\\com\\bree\\web\\controller";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        //参数名
        System.out.println(file.getName());
        //原始文件名
        System.out.println(file.getOriginalFilename());
        //文件尺寸
        System.out.println(file.getSize());



        File localFile = new File(folder,new Date().getTime()+".txt");
        //如果不写入本地，可以采用输入流的方式
        //file.getInputStream()
        //此方法是写入本地
        file.transferTo(localFile);

        return new FileInfo(localFile.getAbsolutePath());

    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (InputStream inputStream = new FileInputStream(new File(folder,id+".txt"));
             OutputStream outputStream = response.getOutputStream();){
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=test.txt");
            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        }
    }
}
