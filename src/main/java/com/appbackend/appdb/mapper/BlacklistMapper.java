package com.appbackend.appdb.mapper;

import com.appbackend.appdb.entity.Blacklist;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
@Repository("blacklistMapper")
public interface BlacklistMapper extends BaseMapper<Blacklist> {

}
