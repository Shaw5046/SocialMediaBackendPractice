package com.appbackend.appdb.service;

import com.appbackend.appdb.entity.Support;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
public interface ISupportService extends IService<Support> {

    public void updateSupport(String token,int postId, int type);

}
