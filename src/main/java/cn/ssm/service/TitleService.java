package cn.ssm.service;

import cn.ssm.dao.TitleMapper;
import cn.ssm.domain.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleService {
    @Autowired
    private TitleMapper titleMapper;

    public Title findTitle(String title){
        return titleMapper.selectByPrimaryKey(title);
    }

    public List<Title> findAll(){
        return titleMapper.selectByExample(null);
    }
    public void addTitle(String title){
        titleMapper.insertSelective(new Title(title));
    }
}
