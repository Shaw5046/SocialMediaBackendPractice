package com.appbackend.appdb.service.impl;

import com.appbackend.appdb.dto.UserCountsReq;
import com.appbackend.appdb.dto.*;
import com.appbackend.appdb.entity.*;
import com.appbackend.appdb.mapper.*;
import com.appbackend.appdb.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserinfoMapper userinfoMapper;
    @Autowired
    UserBindMapper userBindMapper;
    @Autowired
    SupportMapper supportMapper;
    @Autowired
    PostMapper postMapper;
    @Autowired
    FollowMapper followMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    FollowServiceImpl followService;
    @Autowired
    BlacklistMapper blacklistMapper;


    public int code;//4位验证码

    //发送验证码
    @Override
    public SendCodeReq sendCode(String phone){

        SendCodeReq sendCodeReq = new SendCodeReq();
        if(!phone.isEmpty()){
            if(Pattern.matches("^1[3-9]\\d{9}$",phone)){

                code = (int) Math.round((Math.random()) * 10000);

                String codeStr = String.valueOf(code);
                sendCodeReq.setMsg("验证码："+codeStr);
                sendCodeReq.setErrorCode(false);

            }else {
                sendCodeReq.setMsg("格式错误");
                sendCodeReq.setErrorCode(true);
            }
        } else {
            sendCodeReq.setMsg("请输入手机号码");
            sendCodeReq.setErrorCode(true);
        }
        return sendCodeReq;
    }

    //手机号登录
    @Override
    public PhoneLoginReq phoneLogin(String phone, int inputCode){
        PhoneLoginReq phoneLoginReq = new PhoneLoginReq();
        //验证判断
        if(inputCode==code){
            User checkUser = userMapper.selectOne(new QueryWrapper<User>().eq("phone",phone));

            if (checkUser ==null){//没有账号则创建账号

                User addUser = new User();

                addUser.setPhone(phone);
                addUser.setUsername(phone);
                addUser.setCreateTime((int)System.currentTimeMillis()/1000);
                addUser.setStatus(1);

                int userUpdate = userMapper.insert(addUser);
                System.out.println(userUpdate);

                User addedUser = userMapper.selectOne(new QueryWrapper<User>().eq("phone",phone));

                Userinfo userinfo = new Userinfo();
                userinfo.setUserId(addedUser.getId());
                userinfo.setAge(0);
                userinfo.setQg(0);
                userinfo.setSex(0);


                int userInfoUpdate = userinfoMapper.insert(userinfo);
                System.out.println(userInfoUpdate);

            }

            User user = userMapper.selectOne(new QueryWrapper<User>().eq("phone",phone));
            Userinfo userinfo = userinfoMapper.selectOne(new QueryWrapper<Userinfo>().eq("user_id",user.getId()));

            UserReq userReq = new UserReq();
            UserInfoReq userInfoReq = new UserInfoReq();

            userInfoReq.setUserInfoReq(userinfo);

            userReq.setUserReq(user,userInfoReq);

            phoneLoginReq.setMsg("登录成功");
            phoneLoginReq.setData(userReq);

        } else {
            phoneLoginReq.setMsg("验证码错误");
            phoneLoginReq.setData(null);
        }
        return phoneLoginReq;
    }

    //用户名密码登录
    @Override
    public UserNameLoginReq userNameLoginReq(String username, String password){
        UserNameLoginReq userNameLoginReq = new UserNameLoginReq();

        //检查用户是否存在
        User checkUser = userMapper.selectOne(
                new QueryWrapper<User>().eq("username",username).or().
                        eq("email",username).or().
                        eq("phone",username));
        if (checkUser!=null){
            //检查密码
            if (checkUser.getPassword()!=null && checkUser.getPassword().equals(password)){

                Userinfo userinfo = userinfoMapper.selectOne(new QueryWrapper<Userinfo>().eq("user_id", checkUser.getId()));

                UserReq userReq = new UserReq();
                UserInfoReq userInfoReq = new UserInfoReq();

                userInfoReq.setUserInfoReq(userinfo);

                userReq.setUserReq(checkUser,userInfoReq);

                userNameLoginReq.setMsg("登录成功");
                userNameLoginReq.setData(userReq);

            } else {
                userNameLoginReq.setMsg("密码错误或未设置密码");
                userNameLoginReq.setData(null);
            }

        } else {
            userNameLoginReq.setMsg("账号不存在");
            userNameLoginReq.setData(null);
        }
        return userNameLoginReq;
    }

    //退出
    @Override
    public LogoutReq logoutReq(String token){
        LogoutReq logoutReq = new LogoutReq();
        logoutReq.setMsg("退出成功");
        logoutReq.setData(null);
        return logoutReq;
    }

    @Override
    public UserListReq searchUser(String keyword, int page){

        UserListReq userListReq = new UserListReq();
        List<UserReq> userReqList= new ArrayList<>();

        List<User> userList = userMapper.selectList(new QueryWrapper<User>().
                and(postQueryWrapper -> postQueryWrapper.
                        like("username",keyword).or().
                        like("phone",keyword)));

        for (User user:userList){
            Userinfo userinfo = userinfoMapper.selectOne(new QueryWrapper<Userinfo>().eq("user_id", user.getId()));

            UserReq userReq = new UserReq();
            UserInfoReq userInfoReq = new UserInfoReq();

            userInfoReq.setUserInfoReq(userinfo);
            userReq.setUserReq(user, userInfoReq);

            userReqList.add(userReq);
        }

        userListReq.setList(userReqList);

        return userListReq;
    }

    @Override
    public UserReq bindPhone(String token, String phone, int inputCode){
        if(inputCode==code){
            User user = userMapper.selectOne(new QueryWrapper<User>().eq("id",Integer.valueOf(token)));
            user.setPhone(phone);
            int update = userMapper.updateById(user);
            System.out.println(update);
        } else {
            System.out.println("失败");
        }

        return null;
    }

    @Override
    public UserReq bindEmail(String token, String email){

        User user = userMapper.selectOne(new QueryWrapper<User>().eq("id",Integer.valueOf(token)));
        user.setEmail(email);
        int update = userMapper.updateById(user);
        System.out.println(update);
        return null;
    }

    @Override
    public UserCountsReq getUserCounts(int userId){

        UserCountsReq userCountsReq = new UserCountsReq();
        //评论的数量
        userCountsReq.setComments_count(commentMapper.selectCount(new QueryWrapper<Comment>().eq("user_id",userId)));
        //发布文章数量
        userCountsReq.setPost_count(postMapper.selectCount(new QueryWrapper<Post>().eq("user_id",userId)));
        //今天发布文章数量
        userCountsReq.setToday_posts_count(postMapper.selectCount(new QueryWrapper<Post>().
                eq("user_id",userId).
                gt("create_time",(System.currentTimeMillis()-(System.currentTimeMillis()+60*60*8*1000)% (long) (60 * 60 * 24 * 1000)))));
        //收到点赞数
        int ding = 0;
        for(Post post:postMapper.selectList(new QueryWrapper<Post>().eq("user_id",userId))){
            ding = ding + supportMapper.selectCount(new QueryWrapper<Support>().eq("post_id",post.getId()));
        }
        userCountsReq.setTotal_ding_count(ding);
        //粉丝数量
        userCountsReq.setWithfen_count(followMapper.selectCount(new QueryWrapper<Follow>().
                eq("follow_id", userId)));
        //关注数量
        userCountsReq.setWithfollow_count(followMapper.selectCount(new QueryWrapper<Follow>().
                eq("user_id",userId)));
        //好友数量
        userCountsReq.setFriend_count(followService.friendList(String.valueOf(userId)).size());

        return userCountsReq;
    }

    @Override
    public boolean resetPassword(String token, String oldPw, String newPw, String newPw2){
        User user = userMapper.selectById(Integer.valueOf(token));

        if(newPw.equals(newPw2)){
            user.setPassword(newPw);
            int refresh = userMapper.updateById(user);
            System.out.println(refresh+"成功");
            return true;
        } else {
            System.out.println("两次密码不一致");
        }

        return false;
    }

    @Override
    public void resetUserPic(String token, File userPic){
        User user = userMapper.selectById(Integer.parseInt(token));
        user.setUserpic(userPic.getAbsolutePath());
        int refresh = userMapper.updateById(user);
        System.out.println(refresh);
    }

    @Override
    public UserReq getUserById(int id){
        User user = userMapper.selectById(id);
        Userinfo userinfo = userinfoMapper.selectOne(new QueryWrapper<Userinfo>().eq("user_id",id));
        List<Follow> followList = followMapper.selectList(new QueryWrapper<Follow>().eq("follow_id",id));
        List<Blacklist> blackListList = blacklistMapper.selectList(new QueryWrapper<Blacklist>().eq("user_id",id));

        UserInfoReq userInfoReq = new UserInfoReq();
        userInfoReq.setUserInfoReq(userinfo);

        List<UserReq> followUserReqList = new ArrayList<>();
        for(Follow follow : followList){
            User followUser = userMapper.selectById(follow.getFollowId());
            Userinfo followUserInfo = userinfoMapper.selectOne(new QueryWrapper<Userinfo>().eq("user_id",followUser.getId()));
            UserInfoReq followUserInfoReq = new UserInfoReq();
            followUserInfoReq.setUserInfoReq(followUserInfo);
            UserReq followUserReq = new UserReq();
            followUserReq.setUserReq(followUser,followUserInfoReq);
            followUserReqList.add(followUserReq);
        }

        List<UserReq> blackUserReqList = new ArrayList<>();
        for(Blacklist blacklist : blackListList){
            User blackUser = userMapper.selectById(blacklist.getBlackId());
            Userinfo blackUserInfo = userinfoMapper.selectOne(new QueryWrapper<Userinfo>().eq("user_id",blackUser.getId()));
            UserInfoReq blackUserInfoReq = new UserInfoReq();
            blackUserInfoReq.setUserInfoReq(blackUserInfo);
            UserReq blackUserReq = new UserReq();
            blackUserReq.setUserReq(blackUser,blackUserInfoReq);
            blackUserReqList.add(blackUserReq);
        }

        UserReq userReq = new UserReq();
        userReq.setUserReq(user,userInfoReq,followUserReqList,blackUserReqList);

        return userReq;
    }
}
