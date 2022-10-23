package com.appbackend.appdb.service;

import com.appbackend.appdb.entity.Userinfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
public interface IUserinfoService extends IService<Userinfo> {

    public void updateUserInfo(String token, String name, int sex, int qg, String job, String birthday, String path);

}
