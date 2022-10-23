package com.appbackend.appdb.mapper;

import com.appbackend.appdb.entity.Userinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
@Repository("userinfoMapper")
public interface UserinfoMapper extends BaseMapper<Userinfo> {

}
