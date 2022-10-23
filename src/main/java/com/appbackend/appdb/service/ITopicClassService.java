package com.appbackend.appdb.service;

import com.appbackend.appdb.dto.TopicClassResp;
import com.appbackend.appdb.entity.TopicClass;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
public interface ITopicClassService extends IService<TopicClass> {

    public TopicClassResp topicClassResp();

}
