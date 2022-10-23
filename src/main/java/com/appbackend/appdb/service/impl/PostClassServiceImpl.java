package com.appbackend.appdb.service.impl;

import com.appbackend.appdb.dto.PostClassResp;
import com.appbackend.appdb.entity.PostClass;
import com.appbackend.appdb.mapper.PostClassMapper;
import com.appbackend.appdb.service.IPostClassService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
@Service
public class PostClassServiceImpl extends ServiceImpl<PostClassMapper, PostClass> implements IPostClassService {

    @Autowired
    PostClassMapper postClassMapper;

    @Override
    public PostClassResp postClassResp(){
        PostClassResp postClassResp = new PostClassResp();
        List<PostClass> postClassList = postClassMapper.selectList(new QueryWrapper<>());
        postClassResp.setList(postClassList);

        return postClassResp;
    }


}
