package cn.smart.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传
 */
@RestController
public class FileUploadController {

    /**
     * 单文件上传
     * @param file
     */
    /*@PostMapping("/up")
    public String fileUpload(MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        file.transferTo(new File("c:/" + file.getOriginalFilename()));
        return "OK";
    }*/

    /**
     * 多文件上传
     * @param files
     * @return
     * @throws IOException
     */
    @PostMapping("/up")
    public String filesUpload(MultipartFile[] files) throws IOException {
        System.out.println(files.length);
        for (MultipartFile file : files) file.transferTo(new File("c:/" + file.getOriginalFilename()));
        return "OK";
    }

}
