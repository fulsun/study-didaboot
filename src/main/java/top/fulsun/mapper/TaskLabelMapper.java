package top.fulsun.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.fulsun.entity.TaskLabel;
import top.fulsun.entity.TaskLabelExample;

public interface TaskLabelMapper {
    long countByExample(TaskLabelExample example);

    int deleteByExample(TaskLabelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskLabel record);

    int insertSelective(TaskLabel record);

    List<TaskLabel> selectByExample(TaskLabelExample example);

    TaskLabel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaskLabel record, @Param("example") TaskLabelExample example);

    int updateByExample(@Param("record") TaskLabel record, @Param("example") TaskLabelExample example);

    int updateByPrimaryKeySelective(TaskLabel record);

    int updateByPrimaryKey(TaskLabel record);
}