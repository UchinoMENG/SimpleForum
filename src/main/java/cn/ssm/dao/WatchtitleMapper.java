package cn.ssm.dao;

import cn.ssm.domain.Watchtitle;
import cn.ssm.domain.WatchtitleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WatchtitleMapper {
    long countByExample(WatchtitleExample example);

    int deleteByExample(WatchtitleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Watchtitle record);

    int insertSelective(Watchtitle record);

    List<Watchtitle> selectByExample(WatchtitleExample example);

    Watchtitle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Watchtitle record, @Param("example") WatchtitleExample example);

    int updateByExample(@Param("record") Watchtitle record, @Param("example") WatchtitleExample example);

    int updateByPrimaryKeySelective(Watchtitle record);

    int updateByPrimaryKey(Watchtitle record);
}