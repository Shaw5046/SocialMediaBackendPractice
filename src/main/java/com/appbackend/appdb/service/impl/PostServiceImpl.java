package com.appbackend.appdb.service.impl;

import com.appbackend.appdb.dto.*;
import com.appbackend.appdb.entity.*;
import com.appbackend.appdb.mapper.*;
import com.appbackend.appdb.service.IPostService;
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
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

    @Autowired
    PostMapper postMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserinfoMapper userinfoMapper;
    @Autowired
    ImageMapper imageMapper;
    @Autowired
    TopicPostMapper topicPostMapper;
    @Autowired
    SupportMapper supportMapper;
    @Autowired
    PostImageMapper postImageMapper;

    @Override
    public List<ImageReq> setImageList(String token, List<?> imgList){

        //添加img 并返回添加的img list
        List<ImageReq> imageReqList = new ArrayList<>();
        for (int i=1;i<=imgList.size();i++){

            Image image = new Image();

            image.setUrl(imgList.get(i).toString());
            image.setCreateTime(System.currentTimeMillis()/1000);
            image.setUserId(Integer.getInteger(token));
            int addImage = imageMapper.insert(image);
            System.out.println(addImage);

            ImageReq imageReq = new ImageReq();
            imageReq.setUrl(imgList.get(i).toString());
            imageReq.setCreate_time(System.currentTimeMillis()/1000);
            imageReq.setUpdate_time(System.currentTimeMillis()/1000);
            imageReq.setUser_id(Integer.getInteger(token));
            imageReqList.add(imageReq);
        }
        return imageReqList;
    }

    @Override
    public ImageListReq getImageListReq(List<ImageReq> list){
        //img list 返回体
        ImageListReq imageListReq = new ImageListReq();
        imageListReq.setList(list);
        return imageListReq;
    }


    @Override
    //添加一个post
    public Post addPost(String token,  CreatePostReqBody createPostReqBody){

        //构建post实体
        Post addPost = new Post();
        addPost.setUserId(Integer.valueOf(token));
        addPost.setTitle(createPostReqBody.getText());
        addPost.setTitlepic("");
        addPost.setContent(createPostReqBody.getText());
        addPost.setSharenum(0);
        addPost.setPath("未知");
        addPost.setType(0);
        addPost.setCreateTime(System.currentTimeMillis()/1000);
        addPost.setPostClassId(createPostReqBody.getPost_class_id());
        addPost.setShareId(0);
        addPost.setIsopen(true);
        if (!createPostReqBody.getImglist().isEmpty()) {
            addPost.setTitlepic(createPostReqBody.getImglist().get(0).getUrl());
        }
        //添加post记录
        int result = postMapper.insert(addPost);
        System.out.println(result);

        //获取新添的post
        Post post = postMapper.selectOne(new QueryWrapper<Post>().
                eq("user_id",addPost.getUserId()).eq("create_time",addPost.getCreateTime()));

        //在topic-post表中添加记录
        TopicPost topicPost = new TopicPost();
        topicPost.setPostId(post.getId());
        topicPost.setTopicId(createPostReqBody.getTopic_id());
        topicPost.setCreateTime(System.currentTimeMillis()/1000);
        int addTopicPost = topicPostMapper.insert(topicPost);
        System.out.println(addTopicPost);

        //在post-img表中添加记录
        for (CreatePostImgListReqBody createPostImgListReqBody :createPostReqBody.getImglist()){
            PostImage postImage = new PostImage();
            postImage.setImageId(createPostImgListReqBody.getId());
            postImage.setPostId(post.getId());
            postImage.setCreateTime(System.currentTimeMillis()/1000);
            int add = postImageMapper.insert(postImage);
            System.out.println(add);
        }

        //返回新增的post
        return post;
    }


    @Override
    //根据post id返回post返回体
    public PostDetailReq getPostDetailReqByPostId(int postId){

        //获取post
        Post post = postMapper.selectOne(new QueryWrapper<Post>().eq("id",postId));

        //获得user和userinfo，并放置于userReq和userinfoReq中
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("id",post.getUserId()));
        Userinfo userinfo = userinfoMapper.selectOne(new QueryWrapper<Userinfo>().eq("user_id",user.getId()));
        UserInfoReq userInfoReq = new UserInfoReq();
        UserReq userReq = new UserReq();
        userInfoReq.setUserInfoReq(userinfo);
        userReq.setUserReq(user,userInfoReq);

        //获取imageList
        List<PostImage> postImageList = postImageMapper.selectList(new
                QueryWrapper<PostImage>().eq("post_id",post.getId()));
        List<ImageReq> imageReqList = new ArrayList<>();

        for(PostImage postImage : postImageList){
            ImagePivotReq pivotReq = new ImagePivotReq();
            pivotReq.setPostImagePivotReq(postImage);
            Image image = imageMapper.selectOne(new QueryWrapper<Image>().eq("id",postImage.getImageId()));
            ImageReq imageReq = new ImageReq();

            imageReq.setPostImageReq(image,pivotReq);
            imageReqList.add(imageReq);
        }

        //获取顶踩数量
        List<Support> supports = supportMapper.selectList(new QueryWrapper<Support>().eq("post_id",post.getId()));
        int ding = 0;
        for(Support support:supports){
            if(support.getType()==0){
                ding=ding+1;
            }
        }
        int cai = supports.size()-ding;

        //构建post返回体
        PostDetailReq postDetailReq = new PostDetailReq();
        postDetailReq.setPostDetailReq(post,ding,cai,userReq,null,imageReqList);


        //返回
        return postDetailReq;
    }



    @Override
    //post list according to the topic
    public PostListResp getPostListByTopic(int topic, int pageNum){

        //use topic id to get topic-post list
        List<TopicPost> topicPostList = topicPostMapper.selectList(new QueryWrapper<TopicPost>().eq("topic_id",topic).orderByDesc("id"));

        //use topic-post: postId to get post list,and set ti into post Response
        List<PostDetailReq> postDetailReqList = new ArrayList<>();
        //page
        //    p = 1;
        //  1 <= i <= 10
        //    p = 2
        //  11<= i <= 20
        //    p = p
        //  (p-1)*10+1 <= i <=  p*10
        int index = 0;
        for(TopicPost topicPost : topicPostList){
            index++;
            if( index < ( pageNum - 1 ) * 10 + 1 || index > pageNum * 10 ){
                continue;
            }
            Post post = postMapper.selectOne(new QueryWrapper<Post>().eq("id",topicPost.getPostId()).orderByDesc("id"));

            //use post to build PostDetailReq and insert
            PostDetailReq postDetailReq = getPostDetailReqByPostId(post.getId());
            postDetailReqList.add(postDetailReq);
        }
        //build return ResponseBody
        PostListResp postListResp = new PostListResp();
        postListResp.setList(postDetailReqList);
        return postListResp;
    }

    @Override
    //根据class 返回 post list
    public PostListResp getPostListByClass(int classId, int pageNum){

        //使用postId获得post list
        List<Post> postList = postMapper.selectList(new QueryWrapper<Post>().eq("post_class_id",classId).orderByDesc("id"));

        //post list 依次构建post req
        List<PostDetailReq> postDetailReqList = new ArrayList<>();
        int index = 0;
        for (Post post :postList){
            index++;
            if( index < ( pageNum - 1 ) * 10 + 1 || index > pageNum * 10 ){
                continue;
            }
            PostDetailReq postDetailReq = getPostDetailReqByPostId(post.getId());
            postDetailReqList.add(postDetailReq);
        }

        //构建返回体
        PostListResp postListResp = new PostListResp();
        postListResp.setList(postDetailReqList);
        return postListResp;

    }

    @Override
    //根据user 主键返回post list
    public PostListResp getPostListByUser(int userId, int pageNum){

        //使用 user 获得 post list
        List<Post> postList = postMapper.selectList(new QueryWrapper<Post>().eq("user_id",userId).orderByDesc("id"));

        //post list 依次构建post req
        List<PostDetailReq> postDetailReqList = new ArrayList<>();
        int index = 0;
        for (Post post :postList){
            index++;
            if( index < ( pageNum - 1 ) * 10 + 1 || index > pageNum * 10 ){
                continue;
            }
            PostDetailReq postDetailReq = getPostDetailReqByPostId(post.getId());
            postDetailReqList.add(postDetailReq);
        }

        //构建返回体
        PostListResp postListResp = new PostListResp();
        postListResp.setList(postDetailReqList);
        return postListResp;
    }

    @Override
    public PostListResp searchPost(String keyword, int pageNum){

        List<Post> postList = postMapper.selectList(new QueryWrapper<Post>().
                and(postQueryWrapper -> postQueryWrapper.
                        like("title",keyword).or().
                        like("content",keyword)).
                orderByDesc("id"));

        List<PostDetailReq> postDetailReqList = new ArrayList<>();

        int index = 0;
        for (Post post :postList){
            index++;
            if( index < ( pageNum - 1 ) * 10 + 1 || index > pageNum * 10 ){
                continue;
            }
            PostDetailReq postDetailReq = getPostDetailReqByPostId(post.getId());
            postDetailReqList.add(postDetailReq);
        }

        //构建返回体
        PostListResp postListResp = new PostListResp();
        postListResp.setList(postDetailReqList);
        return postListResp;
    }




}
