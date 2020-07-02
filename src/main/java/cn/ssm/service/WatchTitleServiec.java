package cn.ssm.service;

import cn.ssm.dao.WatchtitleMapper;
import cn.ssm.domain.Watchtitle;
import cn.ssm.domain.WatchtitleExample;
import com.sun.javafx.binding.StringFormatter;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchTitleServiec {
    @Autowired
    private Watchtitle watchtitle;
    @Autowired
    private WatchtitleMapper watchtitleMapper;
    public boolean IsHave(String email,String text){
        WatchtitleExample watchtitleExample = new WatchtitleExample();
        WatchtitleExample.Criteria criteria = watchtitleExample.createCriteria();
        criteria.andEmailEqualTo(email).andTextEqualTo(text);
        List<Watchtitle> watchtitles = watchtitleMapper.selectByExample(watchtitleExample);
        System.out.println(watchtitles);
        if(watchtitles==null||watchtitles.size()==0){
            return false;
        }
        return true;
    }
    public void InsertWatch(String email, String text){
        watchtitle.setEmail(email);
        watchtitle.setText(text);
        System.out.println(watchtitle);
        watchtitleMapper.insertSelective(watchtitle);
    }
    public void DeleteWatch(String email, String text){
        WatchtitleExample watchtitleExample = new WatchtitleExample();
        WatchtitleExample.Criteria criteria = watchtitleExample.createCriteria();
        criteria.andEmailEqualTo(email).andTextEqualTo(text);
        watchtitleMapper.deleteByExample(watchtitleExample);
    }
    public List<Watchtitle> getAllWatch(String email){
        WatchtitleExample watchtitleExample = new WatchtitleExample();
        WatchtitleExample.Criteria criteria = watchtitleExample.createCriteria();
        criteria.andEmailEqualTo(email);
        List<Watchtitle> watchtitles = watchtitleMapper.selectByExample(watchtitleExample);
        return watchtitles;
    }
}
