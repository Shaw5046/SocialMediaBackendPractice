package com.appbackend.appdb.mapper;

import com.appbackend.appdb.entity.TopicPost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
@Repository("topicPostMapper")
public interface TopicPostMapper extends BaseMapper<TopicPost> {

}
