package com.appbackend.appdb.service;

import com.appbackend.appdb.entity.Image;
import com.appbackend.appdb.entity.PostImage;
import com.appbackend.appdb.mapper.PostImageMapper;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.annotation.Resource;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
public interface IImageService extends IService<Image> {

    public int saveReturnId(int uid, String iUrl) ;
}
