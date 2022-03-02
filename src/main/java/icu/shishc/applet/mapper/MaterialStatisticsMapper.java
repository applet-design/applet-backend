package icu.shishc.applet.mapper;

import icu.shishc.applet.entity.MaterialStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MaterialStatisticsMapper {

    // 获取某个物资的统计情况
    MaterialStatistics getMaterialStatisticsByName(String materialName);

    // 更新某个物资的情况
    Integer updateMaterialStatistics(MaterialStatistics materialStatistics);

    // 获取所有物资统计
    List<MaterialStatistics> getAllStatistics();

    // 新增一个物资统计
    Long addMaterialStatistics(MaterialStatistics materialStatistics);
}
