package com.appbackend.appdb.mapper;

import com.appbackend.appdb.entity.Topic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
@Repository("topicMapper")
public interface TopicMapper extends BaseMapper<Topic> {
    public List<Topic> selectAll();


}
