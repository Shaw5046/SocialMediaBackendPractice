package com.appbackend.appdb.service;

import com.appbackend.appdb.dto.*;
import com.appbackend.appdb.entity.Post;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
public interface IPostService extends IService<Post> {

    public List<ImageReq> setImageList(String token, List<?> imgList);

    public ImageListReq getImageListReq(List<ImageReq> list);

    public Post addPost(String token,  CreatePostReqBody createPostReqBody);

    public PostDetailReq getPostDetailReqByPostId(int postId);

    public PostListResp getPostListByTopic(int topic, int pageNum);

    public PostListResp getPostListByClass(int classId, int pageNum);

    public PostListResp getPostListByUser(int userId, int pageNum);

    public PostListResp searchPost(String keyword, int page);


}
