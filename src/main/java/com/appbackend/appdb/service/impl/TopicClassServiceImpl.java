package com.appbackend.appdb.service.impl;

import com.appbackend.appdb.dto.PostClassResp;
import com.appbackend.appdb.dto.TopicClassResp;
import com.appbackend.appdb.entity.PostClass;
import com.appbackend.appdb.entity.TopicClass;
import com.appbackend.appdb.mapper.PostClassMapper;
import com.appbackend.appdb.mapper.PostMapper;
import com.appbackend.appdb.mapper.TopicClassMapper;
import com.appbackend.appdb.service.ITopicClassService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

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
public class TopicClassServiceImpl extends ServiceImpl<TopicClassMapper, TopicClass> implements ITopicClassService {

    @Autowired
    TopicClassMapper topicClassMapper;

    @Override
    public TopicClassResp topicClassResp(){
        TopicClassResp topicClassResp = new TopicClassResp();
        List<TopicClass> topicClassList = topicClassMapper.selectList(new QueryWrapper<>());
        topicClassResp.setList(topicClassList);
        ;
        return topicClassResp;
    }

}
