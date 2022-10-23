package com.appbackend.appdb.service;

import com.appbackend.appdb.entity.Blacklist;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
public interface IBlacklistService extends IService<Blacklist> {

    public void addBlack(String token, int blackUserId);

    public void removeBlack(String token, int blackUserId,int phone);

}
