package com.appbackend.appdb.controller;


import com.appbackend.appdb.dto.RespBean;
import com.appbackend.appdb.dto.UserInfoReq;
import com.appbackend.appdb.dto.UserListReq;
import com.appbackend.appdb.dto.UserReq;
import com.appbackend.appdb.entity.Follow;
import com.appbackend.appdb.entity.User;
import com.appbackend.appdb.entity.Userinfo;
import com.appbackend.appdb.mapper.UserMapper;
import com.appbackend.appdb.mapper.UserinfoMapper;
import com.appbackend.appdb.service.impl.FollowServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/appdb")
public class FollowController {

    @Autowired
    FollowServiceImpl followService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserinfoMapper userinfoMapper;

    @PostMapping("follow")
    public RespBean addFollow(@RequestHeader String token,
                             @RequestBody Map<String,String> params){

        int userId = Integer.parseInt(params.get("follow_id"));
        followService.addFollow(token,userId);
        return new RespBean("成功",null);
    }

    @PostMapping("unfollow")
    public RespBean removeFollow(@RequestHeader String token,
                              @RequestBody Map<String,Integer> params){
        int userId = params.get("id");
        followService.removeFollow(token,userId);
        return new RespBean("成功",null);
    }

    @GetMapping("friends/{page}")
    public RespBean getFriendList(@RequestHeader String token,
                                 @PathVariable("page") int pageNum){

        List<Follow> followList = followService.friendList(token);

        return new RespBean("成功",getListByFollowList(followList,pageNum));
    }

    @GetMapping("fens/{page}")
    public RespBean getFensList(@RequestHeader String token,
                                 @PathVariable("page") int pageNum){

        List<Follow> followList = followService.followedList(token,pageNum);

        return new RespBean("成功",getListByFollowList(followList,pageNum));
    }

    @GetMapping("follows/{page}")
    public RespBean getFollowingList(@RequestHeader String token,
                                    @PathVariable("page") int pageNum){
        List<Follow> followList = followService.followingList(token,pageNum);
        return new RespBean("成功",getListByFollowList(followList,pageNum));
    }

    public UserListReq getListByFollowList(List<Follow> followList,int pageNum){
        List<UserReq> userReqList = new ArrayList<>();
        int index = 0;
        for(Follow follow : followList){
            index++;
            if( index < ( pageNum - 1 ) * 10 + 1 || index > pageNum * 10 ){
                continue;
            }
            User user = userMapper.selectById(follow.getFollowId());
            Userinfo userinfo = userinfoMapper.selectOne(new QueryWrapper<Userinfo>().eq("user_id",user.getId()));
            UserInfoReq userInfoReq = new UserInfoReq();
            userInfoReq.setUserInfoReq(userinfo);
            UserReq userReq = new UserReq();
            userReq.setUserReq(user,userInfoReq);
            userReqList.add(userReq);
        }
        UserListReq userListReq = new UserListReq();
        userListReq.setList(userReqList);
        return userListReq;
    }


}

