package com.appbackend.appdb.service.impl;

import com.appbackend.appdb.entity.Image;
import com.appbackend.appdb.entity.PostImage;
import com.appbackend.appdb.mapper.ImageMapper;
import com.appbackend.appdb.mapper.PostImageMapper;
import com.appbackend.appdb.service.IImageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements IImageService {


    @Autowired
    ImageMapper imageMapper;

    @Override
    public int saveReturnId(int uid, String iUrl) {

        Image image = new Image();
        image.setUserId(uid);
        image.setUrl(iUrl);
        image.setCreateTime(System.currentTimeMillis()/1000);
        imageMapper.insert(image);

        Image image1 = imageMapper.selectOne(new QueryWrapper<Image>().eq("url",iUrl));

        return image1.getId();
    }

    //上传图片

    //获得图片
}
