package com.lcl.hw.controller;

import com.lcl.hw.utils.RetObj;
import com.lcl.hw.utils.ValidateCodeUtil;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Rain on 2017/1/4 15:36.
 */
@Controller
@RequestMapping("/validateCode")
public class ValidateCodeController {
    @Resource
    private ValidateCodeUtil validateCodeUtil;

    private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/getValidateCode")
    public void getValidateCode(HttpServletResponse response){
        Map map = validateCodeUtil.produceValidateCode();
        BufferedImage bufferedImage = (BufferedImage)map.get("pic");
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");

        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos = null;
        try {
            sos = response.getOutputStream();
            ImageIO.write(bufferedImage, "jpeg", sos);
            sos.close();
        } catch (IOException e) {
            logger.error("验证码返回失败",e);
        }
    }

    public RetObj checkValidateCode(String validateCode){
        RetObj retObj = new RetObj();
       
        return retObj;
    }

}
