package icu.shishc.applet.service.impl;

import icu.shishc.applet.entity.Material;
import icu.shishc.applet.entity.MaterialStatistics;
import icu.shishc.applet.mapper.MaterialMapper;
import icu.shishc.applet.mapper.MaterialStatisticsMapper;
import icu.shishc.applet.service.MaterialStatisticsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MaterialStatisticsServiceImpl implements MaterialStatisticsService {

    @Resource
    MaterialMapper materialMapper;
    @Resource
    MaterialStatisticsMapper materialStatisticsMapper;

    @Override
    public List<MaterialStatistics> getAllMaterialStatistics() {
        return materialStatisticsMapper.getAllStatistics();
    }

    @Override
    public MaterialStatistics getSomeMaterialStatistics(String materialName) {
        return materialStatisticsMapper.getMaterialStatisticsByName(materialName);
    }

    @Override
    public List<Material> getAllMaterial() {
        return materialMapper.getMaterialList();
    }

    @Override
    public Long addMaterial(String materialName) {
        Material material = new Material();
        material.setMaterialName(materialName);
        Long materialId = materialMapper.getMaterial(materialName);
        if (materialId != null) {
            return 0L;
        }
        MaterialStatistics materialStatistics = new MaterialStatistics();
        materialStatistics.setMaterialName(materialName);
        materialStatistics.setMaterialNum(0);
        materialStatistics.setCost(0F);
        materialStatisticsMapper.addMaterialStatistics(materialStatistics);
        return materialMapper.addMaterial(material);
    }

    @Override
    public Integer deleteMaterial(Long materialId) {
        return materialMapper.deleteMaterial(materialId);
    }
}
