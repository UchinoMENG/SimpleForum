package cn.ssm.service;

import cn.ssm.dao.PublicTitleAndUserMapper;
import cn.ssm.domain.PublicTitleAndUser;
import cn.ssm.domain.PublicTitleAndUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicTitleAndUserService {
    @Autowired
    private PublicTitleAndUserMapper publicTitleAndUserMapper;
    public PublicTitleAndUser getTitleUser(String msg){
        PublicTitleAndUserExample publicTitleAndUserExample = new PublicTitleAndUserExample();
        PublicTitleAndUserExample.Criteria criteria = publicTitleAndUserExample.createCriteria();
        criteria.andPublicTitleEqualTo(msg);
        return publicTitleAndUserMapper.selectByExample(publicTitleAndUserExample).get(0);
    }
    public void InsertTitle(PublicTitleAndUser publicTitleAndUser){
        publicTitleAndUserMapper.insertSelective(publicTitleAndUser);
    }
}
