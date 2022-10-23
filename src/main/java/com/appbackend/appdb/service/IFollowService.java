package com.appbackend.appdb.service;

import com.appbackend.appdb.entity.Follow;
import com.appbackend.appdb.mapper.FollowMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
public interface IFollowService extends IService<Follow> {

    public void addFollow(String token, int followId);

    public void removeFollow(String token, int followId);

    public List<Follow> friendList(String token);

    public List<Follow> followingList(String token, int page);

    public List<Follow> followedList(String token, int page);
}
