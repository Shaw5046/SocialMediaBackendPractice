package com.appbackend.appdb.mapper;

import com.appbackend.appdb.dto.ImageReq;
import com.appbackend.appdb.entity.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
@Repository("postMapper")
public interface PostMapper extends BaseMapper<Post> {




}
