package com.appbackend.appdb.service.impl;

import com.appbackend.appdb.entity.Follow;
import com.appbackend.appdb.mapper.FollowMapper;
import com.appbackend.appdb.service.IFollowService;
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
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements IFollowService {

    @Autowired
    FollowMapper followMapper;

    @Override
    public void addFollow(String token, int followId){
        Follow checkFollow = followMapper.selectOne(new QueryWrapper<Follow>().
                eq("user_id",Integer.parseInt(token)).eq("follow_id",followId));

        if(checkFollow==null){
            Follow follow = new Follow();
            follow.setUserId(Integer.valueOf(token));
            follow.setFollowId(followId);
            follow.setCreateTime(System.currentTimeMillis()/1000);
            int add = followMapper.insert(follow);
            System.out.println(add);
        }



    }

    @Override
    public void removeFollow(String token, int followId){
        Follow follow = followMapper.selectOne(new QueryWrapper<Follow>().eq("follow_id",followId).
                eq("user_id",Integer.valueOf(token)));
        if(follow!=null){
            int remove = followMapper.deleteById(followId);
            System.out.println(remove+"成功");
        } else {
            System.out.println("不存在此项");
        }
    }

    @Override
    public List<Follow> friendList(String token){
        //关注我的用户list
        List<Follow> followedList = followMapper.selectList(new QueryWrapper<Follow>().
                eq("follow_id",Integer.valueOf(token)));
        //我关注的list
        List<Follow> followingList = followMapper.selectList(new QueryWrapper<Follow>().
                eq("user_id",Integer.valueOf(token)));

        List<Follow> friendList = new ArrayList<>();
        for (Follow followed: followedList){
            for(Follow following:followingList){
                //关注我的用户，我也关注了他
                if(followed.getUserId().equals(following.getFollowId())){
                    friendList.add(following);
                }
            }

        }

        return friendList;
    }

    @Override
    //Following
    public List<Follow> followingList(String token, int page){
        return followMapper.selectList(new QueryWrapper<Follow>().
                eq("user_id",Integer.valueOf(token)));

    }

    @Override
    //关注我的
    public List<Follow> followedList(String token, int page){

        return followMapper.selectList(new QueryWrapper<Follow>().
                eq("follow_id",Integer.valueOf(token)));

    }

}
