package com.appbackend.appdb.service;

import com.appbackend.appdb.dto.TopicListReq;
import com.appbackend.appdb.dto.TopicReq;
import com.appbackend.appdb.entity.Topic;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
public interface ITopicService extends IService<Topic> {

    public List<Topic> selectAll(int pageNum, int pageSize);

    public TopicListReq hotTopicResp();

    public TopicListReq selectTopic(int id, int page);

    public TopicListReq searchTopic(String keyword, int page);
}
