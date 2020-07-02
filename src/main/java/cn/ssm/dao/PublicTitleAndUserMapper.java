package cn.ssm.dao;

import cn.ssm.domain.PublicTitleAndUser;
import cn.ssm.domain.PublicTitleAndUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PublicTitleAndUserMapper {
    long countByExample(PublicTitleAndUserExample example);

    int deleteByExample(PublicTitleAndUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PublicTitleAndUser record);

    int insertSelective(PublicTitleAndUser record);

    List<PublicTitleAndUser> selectByExample(PublicTitleAndUserExample example);

    PublicTitleAndUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PublicTitleAndUser record, @Param("example") PublicTitleAndUserExample example);

    int updateByExample(@Param("record") PublicTitleAndUser record, @Param("example") PublicTitleAndUserExample example);

    int updateByPrimaryKeySelective(PublicTitleAndUser record);

    int updateByPrimaryKey(PublicTitleAndUser record);
}