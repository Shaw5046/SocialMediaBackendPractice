package com.appbackend.appdb.service.impl;

import com.appbackend.appdb.dto.CommentListReq;
import com.appbackend.appdb.dto.CommentReq;
import com.appbackend.appdb.dto.UserReq;
import com.appbackend.appdb.entity.Comment;
import com.appbackend.appdb.entity.User;
import com.appbackend.appdb.mapper.CommentMapper;
import com.appbackend.appdb.mapper.PostMapper;
import com.appbackend.appdb.mapper.UserMapper;
import com.appbackend.appdb.service.ICommentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    PostMapper postMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public void addComment(String token, int fid, String data, int postId){
        Comment comment = new Comment();
        comment.setData(data);
        comment.setFid(fid);
        comment.setUserId(Integer.valueOf(token));
        comment.setFnum(0);
        comment.setCreateTime(System.currentTimeMillis()/1000);
        comment.setPostId(postId);
        if(fid!=0){
            Comment commented = commentMapper.selectById(fid);
            commented.setFnum(commented.getFnum()+1);
            int refresh = commentMapper.updateById(commented);
            System.out.println(refresh);
        }
        int add = commentMapper.insert(comment);
        System.out.println(add);
    }

    @Override
    public CommentListReq getCommonListReq(int postId){
        List<Comment> commentList = commentMapper.selectList(new QueryWrapper<Comment>().
                eq("post_id",postId));
        List<CommentReq> commentReqList = new ArrayList<>();
        for(Comment comment:commentList){
            User user = userMapper.selectById(comment.getUserId());
            UserReq userReq = new UserReq();
            userReq.setUserReq(user);

            CommentReq commentReq = new CommentReq();
            commentReq.setCommentReq(comment,userReq);
            commentReqList.add(commentReq);
        }

        CommentListReq commentListReq = new CommentListReq();
        commentListReq.setList(commentReqList);
        return commentListReq;
    }





}
