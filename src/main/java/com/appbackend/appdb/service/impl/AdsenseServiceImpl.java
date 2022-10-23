package com.appbackend.appdb.service.impl;

import com.appbackend.appdb.dto.AdSenseListReq;
import com.appbackend.appdb.dto.AdSenseReq;
import com.appbackend.appdb.entity.Adsense;
import com.appbackend.appdb.mapper.AdsenseMapper;
import com.appbackend.appdb.service.IAdsenseService;
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
public class AdsenseServiceImpl extends ServiceImpl<AdsenseMapper, Adsense> implements IAdsenseService {

    @Autowired
    AdsenseMapper adsenseMapper;

    @Override
    public AdSenseListReq getList(int type){

        List<Adsense> adsenseList = adsenseMapper.selectList(new QueryWrapper<Adsense>().eq("type",type));

        List<AdSenseReq> adSenseReqList = new ArrayList<>();


        for(Adsense adsense:adsenseList){
            AdSenseReq adSenseReq = new AdSenseReq();
            adSenseReq.setAdSenseReq(adsense);
            adSenseReqList.add(adSenseReq);
        }

        AdSenseListReq adSenseListReq = new AdSenseListReq();
        adSenseListReq.setAdSenseListReq(adSenseReqList);

        return adSenseListReq;
    }

}
