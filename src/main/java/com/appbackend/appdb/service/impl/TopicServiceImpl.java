package com.appbackend.appdb.service.impl;

import com.appbackend.appdb.dto.TopicListReq;
import com.appbackend.appdb.dto.TopicReq;
import com.appbackend.appdb.entity.Topic;
import com.appbackend.appdb.mapper.TopicMapper;
import com.appbackend.appdb.service.ITopicService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements ITopicService {

    @Autowired
    TopicMapper topicMapper;

    @Override
    public List<Topic> selectAll(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Topic> topicList = topicMapper.selectAll();
        PageInfo<Topic> topicPageInfo = new PageInfo<>(topicList);
        return topicPageInfo.getList();
    }

    @Override
    public TopicListReq hotTopicResp(){
        TopicListReq topicListReq = new TopicListReq();
        List<Topic> topicList = topicMapper.selectList(new QueryWrapper<Topic>());
        List<TopicReq> topicReqList = new ArrayList<>();
        for (Topic topic:topicList){
            TopicReq topicReq = new TopicReq();
            topicReq.setTopicReq(topic);
            topicReqList.add(topicReq);
        }
        topicListReq.setList(topicReqList);

        return topicListReq;
    }

    @Override
    public TopicListReq selectTopic(int id, int page){
        TopicListReq topicListReq = new TopicListReq();

        PageHelper.startPage(page,5);
        List<Topic> topicList = topicMapper.selectList(new QueryWrapper<Topic>().eq("topic_class_id",id));
        PageInfo<Topic> topicPageInfo = new PageInfo<>(topicList);
        List<TopicReq> topicReqList = new ArrayList<>();

        for (Topic topic:topicPageInfo.getList()){
            TopicReq topicReq = new TopicReq();
            topicReq.setTopicReq(topic);
            topicReqList.add(topicReq);
        }
        topicListReq.setList(topicReqList);

        return topicListReq;
    }

    @Override
    public TopicListReq searchTopic(String keyword, int pageNum){

        TopicListReq topicListReq = new TopicListReq();


        List<Topic> topicList = topicMapper.selectList(new QueryWrapper<Topic>().
                and(postQueryWrapper -> postQueryWrapper.
                        like("title",keyword).or().
                        like("description",keyword)));
        PageInfo<Topic> topicPageInfo = new PageInfo<>(topicList);
        List<TopicReq> topicReqList = new ArrayList<>();

        int index = 0;
        for (Topic topic:topicPageInfo.getList()){
            index++;
            if( index < ( pageNum - 1 ) * 10 + 1 || index > pageNum * 10 ){
                continue;
            }
            TopicReq topicReq = new TopicReq();
            topicReq.setTopicReq(topic);
            topicReqList.add(topicReq);
        }

        topicListReq.setList(topicReqList);

        return topicListReq;
    }
}
