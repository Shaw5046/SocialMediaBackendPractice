package com.appbackend.appdb.service.impl;

import com.appbackend.appdb.entity.Blacklist;
import com.appbackend.appdb.entity.User;
import com.appbackend.appdb.mapper.BlacklistMapper;
import com.appbackend.appdb.service.IBlacklistService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
@Service
public class BlacklistServiceImpl extends ServiceImpl<BlacklistMapper, Blacklist> implements IBlacklistService {

    @Autowired
    BlacklistMapper blacklistMapper;

    @Override
    public void addBlack(String token, int blackUserId){
        Blacklist addBlackList = new Blacklist();
        addBlackList.setUserId(Integer.valueOf(token));
        addBlackList.setBlackId(blackUserId);
        addBlackList.setCreateTime((int)System.currentTimeMillis()/1000);
        int add = blacklistMapper.insert(addBlackList);
        System.out.println(add);
    }

    @Override
    public void removeBlack(String token, int blackUserId,int phone){
        Blacklist blacklistItem = blacklistMapper.selectOne(new QueryWrapper<Blacklist>().
                eq("black_id",blackUserId).eq("user_id",Integer.valueOf(token)));
        if(blacklistItem!=null){
            int remove = blacklistMapper.deleteById(blacklistItem);
            System.out.println(remove+"成功");
        } else {
            System.out.println("失败");
        }

    }

}
