package com.appbackend.appdb.service.impl;

import com.appbackend.appdb.entity.Userinfo;
import com.appbackend.appdb.mapper.UserinfoMapper;
import com.appbackend.appdb.service.IUserinfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements IUserinfoService {

    @Autowired
    UserinfoMapper userinfoMapper;

    @Override
    public void updateUserInfo(String token, String name, int sex, int qg, String job, String birthday, String path){
        Userinfo userinfo = userinfoMapper.selectOne(new QueryWrapper<Userinfo>().eq("user_id",Integer.valueOf(token)));
        userinfo.setSex(sex);
        userinfo.setQg(qg);
        userinfo.setJob(job);
        userinfo.setPath(path);
        userinfo.setBirthday(birthday);
        userinfo.setAge(0);

        int add = userinfoMapper.updateById(userinfo);
        System.out.println(add);
    }



}
