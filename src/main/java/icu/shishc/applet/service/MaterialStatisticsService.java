package icu.shishc.applet.service;

import icu.shishc.applet.entity.Material;
import icu.shishc.applet.entity.MaterialStatistics;

import java.util.List;

public interface MaterialStatisticsService {

    // 查看所有的物资统计数据
    List<MaterialStatistics> getAllMaterialStatistics();

    // 查看某种物资统计数据
    MaterialStatistics getSomeMaterialStatistics(String materialName);

    // 查看所有可申请的物资
    List<Material> getAllMaterial();

    // 添加一个可申请的物资
    Long addMaterial(String materialName);

    // 删除一个可申请物资
    Integer deleteMaterial(Long materialId);

}
