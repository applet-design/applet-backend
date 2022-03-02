package icu.shishc.applet.mapper;

import icu.shishc.applet.entity.Material;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MaterialMapper {

    List<Material> getMaterialList();

    Long getMaterial(String materialName);

    Long addMaterial(Material material);

    Integer deleteMaterial(Long materialId);
}
