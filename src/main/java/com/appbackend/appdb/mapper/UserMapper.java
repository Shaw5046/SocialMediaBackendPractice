package com.appbackend.appdb.mapper;

import com.appbackend.appdb.entity.Topic;
import com.appbackend.appdb.entity.User;
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
@Repository("userMapper")
public interface UserMapper extends BaseMapper<User> {


}
