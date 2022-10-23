package com.appbackend.appdb.controller;

//import com.appbackend.appdb.service.IImageService;
import com.appbackend.appdb.service.impl.ImageServiceImpl;
//import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/appdb")
public class ImageController {

    @Autowired
    ImageServiceImpl imageService;

    @Value("${backend.fileUpload.path}")
    private String uploadPath;

    @Value("${backend.server.url}")
    private String serverUrl;

    @RequestMapping(value = "/image/uploadmore",method = RequestMethod.POST)
    public String upload(@RequestParam("imglist[]") MultipartFile mf,@RequestHeader String token) throws IOException{

        String	newFilename = UUID.randomUUID().toString().replaceAll("-", "")
                + mf.getOriginalFilename().substring(mf.getOriginalFilename().lastIndexOf("."));
        File path = new File(this.uploadPath);
        if(!path.exists()) {
            path.mkdir();
        }
        // 保存图片上传
        //获得图片id
        String url = serverUrl + "/" +newFilename ;
        int picId = imageService.saveReturnId(Integer.parseInt(token),url);
        mf.transferTo(new File(this.uploadPath+"/"+newFilename));
        return "{\"msg\":\"succeed\",\"data\":{\"list\":[{\"url\":\"" +
                url + "\","+
                "\"user_id\":"+token+",\"create_time\":1651730050,\"update_time\":1651730050,\"id\":\""+picId+"\"}]}}";
    }
}

