package icu.shishc.applet.service;

import icu.shishc.applet.controller.param.MaterialApplicationParam;
import icu.shishc.applet.entity.MaterialApplication;

import java.util.List;

public interface ApplicationService {

    Long addMaterialApplication(MaterialApplicationParam materialApplicationParam);

    MaterialApplication getMaterialApplicationById(Long materialApplicationId);

    Integer cancelMaterialApplicationById(Long materialApplicationId);

    List<MaterialApplication> getUserMaterialApplication(Long userId);

}
