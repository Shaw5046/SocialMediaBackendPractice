package com.appbackend.appdb.service;

import com.appbackend.appdb.entity.Feedback;
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
public interface IFeedbackService extends IService<Feedback> {

    public void addFeedback(String token, String data, int toId, int fromId);

    public List<Feedback> getFeedbackList(String token);
}
