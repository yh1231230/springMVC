package controller;

import org.apache.commons.lang.xwork.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.UploadedImageFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


@Controller
public class UploadController {

    @RequestMapping("/uploadImage")
    public ModelAndView upload(HttpServletRequest request, UploadedImageFile file) throws IllegalStateException,IOException {
        String name = RandomStringUtils.randomAlphanumeric(10);  //生成指定长度的字母和数字的随机组合字符串
        String newFileName = name + ".jpg"; //新文件名为该字符串.jpg

        File newFile = new File(request.getServletContext().getRealPath("/image"),newFileName);
        //获取到web目录下的image目录，用于存放上传后的文件。

        newFile.getParentFile().mkdirs();
        //创建文件

        file.getImage().transferTo(newFile);
        //复制文件

        ModelAndView mav = new ModelAndView("showUpload");
        mav.addObject("imageName", newFileName);
        return mav;
    }
}
