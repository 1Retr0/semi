package cn.edu.zucc.controller;

import cn.edu.zucc.domain.entity.FileInfo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

@RestController
@RequestMapping("/file")
public class FileController {
    private static final String folder = "/Users/retr0/Desktop/短学期/upload";

    /**
     * 文件上传
     *
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping
    public FileInfo update(MultipartFile file) throws IOException {
        /**
         * 注意：file名字要和参入的name一致
         */

        System.out.println("file name=" + file.getName());
        System.out.println("origin file name=" + file.getOriginalFilename());
        System.out.println("file size=" + file.getSize());


        /**
         * 这里是写到本地
         * 还可以用file.getInputStrem()
         * 获取输入流，然后存到阿里oss。。或七牛。。
         */
        File localFile = new File(folder, new Date().getTime() + ".docx");

        //把传入的文件写到本地文件
        file.transferTo(localFile);

        return new FileInfo(localFile.getAbsolutePath()); //getAbsolutePath为绝对路径

    }

    /**
     * 文件的下载
     */
    @GetMapping("/{id}") //id为时间戳
    public void download(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {

        try (
                //jdk7新特性，可以直接写到try()括号里面，java会自动关闭
                InputStream inputStream = new FileInputStream(new File(folder, id + ".docx"));
                OutputStream outputStream = response.getOutputStream()
        ) {
            //指明为下载
            response.setContentType("application/x-download");
            String fileName = id+".docx";
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);   // 设置文件名


            //把输入流copy到输出流
            IOUtils.copy(inputStream, outputStream);

            outputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
