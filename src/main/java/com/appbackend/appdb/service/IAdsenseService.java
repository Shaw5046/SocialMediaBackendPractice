package com.appbackend.appdb.service;

import com.appbackend.appdb.dto.AdSenseListReq;
import com.appbackend.appdb.entity.Adsense;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
public interface IAdsenseService extends IService<Adsense> {


    public AdSenseListReq getList(int type);
}
