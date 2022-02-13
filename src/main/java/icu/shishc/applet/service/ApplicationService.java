package icu.shishc.applet.service;

import icu.shishc.applet.controller.param.MaterialApplicationParam;
import icu.shishc.applet.entity.MaterialApplication;

public interface ApplicationService {

    Long addMaterialApplication(MaterialApplicationParam materialApplicationParam);

    MaterialApplication getMaterialApplicationById(Long materialApplicationId);

    Integer cancelMaterialApplicationById(Long materialApplicationId);

}
