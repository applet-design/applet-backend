package icu.shishc.applet.mapper;

import icu.shishc.applet.entity.MaterialApplication;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ApplicationMapper {

    Long addMaterialApplication(MaterialApplication materialApplication);

    MaterialApplication getMaterialApplicationById(Long materialApplicationId);

    Integer cancelMaterialApplicationById(Long materialApplicationId);

}
