package com.appbackend.appdb.service.impl;

import com.appbackend.appdb.entity.TopicPost;
import com.appbackend.appdb.mapper.TopicPostMapper;
import com.appbackend.appdb.service.ITopicPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class TopicPostServiceImpl extends ServiceImpl<TopicPostMapper, TopicPost> implements ITopicPostService {

}
