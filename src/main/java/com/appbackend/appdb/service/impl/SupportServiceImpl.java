package com.appbackend.appdb.service.impl;

import com.appbackend.appdb.entity.Support;
import com.appbackend.appdb.mapper.SupportMapper;
import com.appbackend.appdb.service.ISupportService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class SupportServiceImpl extends ServiceImpl<SupportMapper, Support> implements ISupportService {

    @Autowired
    SupportMapper supportMapper;

    @Override
    public void updateSupport(String token,int postId, int type){
        Support support = supportMapper.selectOne(new QueryWrapper<Support>().
                eq("user_id",Integer.valueOf(token)).eq("post_id",postId));
        if(support != null){
            support.setType(type);
        } else {
            Support addSupport =new Support();
            addSupport.setType(type);
            addSupport.setUserId(Integer.valueOf(token));
            addSupport.setPostId(postId);
            addSupport.setCreateTime((int)System.currentTimeMillis()/1000);

            int add = supportMapper.insert(addSupport);
            System.out.println(add);
        }
    }

}
