package com.appbackend.appdb.service.impl;

import com.appbackend.appdb.entity.Feedback;
import com.appbackend.appdb.mapper.FeedbackMapper;
import com.appbackend.appdb.service.IFeedbackService;
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
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements IFeedbackService {

    @Autowired
    FeedbackMapper feedbackMapper;

    @Override
    public void addFeedback(String token, String data, int toId, int fromId){
        Feedback feedback = new Feedback();
        feedback.setData(data);
        feedback.setToId(toId);
        feedback.setFromId(fromId);
        feedback.setCreateTime((int)System.currentTimeMillis()/1000);

        int add = feedbackMapper.insert(feedback);
        System.out.println(add);

    }

    @Override
    public List<Feedback> getFeedbackList(String token){
        return feedbackMapper.selectList(new QueryWrapper<Feedback>().eq("to_id",Integer.valueOf(token)));
    }

}
