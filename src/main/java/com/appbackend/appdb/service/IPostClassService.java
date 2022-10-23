package com.appbackend.appdb.service;

import com.appbackend.appdb.dto.PostClassResp;
import com.appbackend.appdb.entity.PostClass;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
public interface IPostClassService extends IService<PostClass> {

    public PostClassResp postClassResp();

}
