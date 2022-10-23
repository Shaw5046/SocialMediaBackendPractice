package com.appbackend.appdb.controller;


import com.alibaba.fastjson.JSONObject;
import com.appbackend.appdb.dto.*;
import com.appbackend.appdb.entity.Follow;
import com.appbackend.appdb.entity.Post;
import com.appbackend.appdb.mapper.FollowMapper;
import com.appbackend.appdb.mapper.PostMapper;
import com.appbackend.appdb.service.impl.CommentServiceImpl;
import com.appbackend.appdb.service.impl.PostServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/appdb/")
public class PostController {

    @Autowired
    PostServiceImpl postService;
    @Autowired
    CommentServiceImpl commentService;
    @Autowired
    FollowMapper followMapper;
    @Autowired
    PostMapper postMapper;

    @PostMapping("post/create")
    public RespBean createPost(@RequestHeader("token") String token,
                               @RequestBody CreatePostReqBody createPostReqBody){
        Post post =  postService.addPost(token, createPostReqBody);
        return new RespBean("succeed", postService.getPostDetailReqByPostId(post.getId()));
    }


    @GetMapping("post/{id}")
    public RespBean getPost(@PathVariable("id") int id){
        JSONObject detail = new JSONObject();
        detail.put("detail", postService.getPostDetailReqByPostId(id));
        return new RespBean("succeed",detail);
    }

    @GetMapping("topic/{id}/post/{page}")
    public RespBean getTopicPost(@PathVariable("id") int topicId,
                                 @PathVariable("page") int page){
        return new RespBean("succeed", postService.getPostListByTopic(topicId,page));
    }

    @GetMapping("postclass/{id}/post/{page}")
    public RespBean getClassPost(@RequestHeader("token") String token,
                                 @PathVariable("id") int classId,
                                 @PathVariable("page") int page){
        return new RespBean("succeed",postService.getPostListByClass(classId,page));
    }

    @GetMapping("user/{id}/post/{page}")
    public RespBean getUserPost(@PathVariable("id") int userId,
                                @PathVariable("page") int page){
        return new RespBean("succeed",postService.getPostListByUser(userId,page));
    }

    @GetMapping("user/post/{page}")
    public RespBean getMyPost(@RequestHeader("token") String token,
                              @PathVariable("page") int page){
        return new RespBean("succeed",postService.getPostListByUser(Integer.parseInt(token),page));
    }

    @PostMapping("post/comment")
    public RespBean addComment(@RequestHeader("token") String token,
                               @RequestBody AddCommentReq addCommentReq){

        int fid = addCommentReq.getFid();
        String data = addCommentReq.getData();
        int postId = addCommentReq.getPost_id();

        commentService.addComment(token,fid,data,postId);
        return new RespBean("succeed",null);

    }

    @GetMapping("post/{id}/comment")
    public RespBean getCommentList(@PathVariable("id") int postId){
        return new RespBean("succeed",commentService.getCommonListReq(postId));
    }



    @GetMapping("followpost/{page}")
    public RespBean getFollowPost(@RequestHeader String token,
                                  @PathVariable("page") int page){
        List<Follow> followList = followMapper.selectList(new QueryWrapper<Follow>().eq("user_id",Integer.parseInt(token)));
        List<PostDetailReq> postDetailReqList = new ArrayList<>();

        int index = 0;
        for(Follow follow : followList) {
            index++;
            if (index < (page - 1) * 10 + 1 || index > page * 10) {
                continue;
            }
            List<Post> postList = postMapper.selectList(new QueryWrapper<Post>().eq("user_id", follow.getUserId()).orderByDesc("id"));
            //post list 依次构建post req

            for (Post post : postList) {

                PostDetailReq postDetailReq = postService.getPostDetailReqByPostId(post.getId());
                postDetailReqList.add(postDetailReq);
            }
        }
        PostListResp postListResp = new PostListResp();
        postListResp.setList(postDetailReqList);
        return new RespBean("succeed",postListResp);
    }





}

