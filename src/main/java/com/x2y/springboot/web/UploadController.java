package com.x2y.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class UploadController {
    @RequestMapping("/uploadPage")
    public String uploadPage()throws Exception{
        return "uploadPage";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest req, @RequestParam("file") MultipartFile file,Model m) {
        try {
            String fileName = System.currentTimeMillis()+file.getOriginalFilename();
            String destFileName=req.getServletContext().getRealPath("")+"uploaded"+File.separator+fileName;

            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            file.transferTo(destFile);

            m.addAttribute("fileName",fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }

        return "showImg";
    }
}
