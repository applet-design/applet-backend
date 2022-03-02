package icu.shishc.applet.controller.admin;

import icu.shishc.applet.controller.param.admin.AdoptMaterialApplicationParam;
import icu.shishc.applet.controller.param.admin.RefuseMaterialApplicationParam;
import icu.shishc.applet.entity.MaterialStatistics;
import icu.shishc.applet.service.ApplicationService;
import icu.shishc.applet.service.MaterialStatisticsService;
import icu.shishc.applet.util.ResultJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminMaterialController {

    @Resource
    ApplicationService applicationService;
    @Resource
    MaterialStatisticsService materialStatisticsService;

    // 查看所有的物资申请 + sumCost
    @RequestMapping(value = "/materialStatistics/list", method = RequestMethod.GET)
    public ResultJson getAllMaterialStatistics() {
        List<MaterialStatistics> materialStatisticsList = materialStatisticsService.getAllMaterialStatistics();
        return ResultJson.ok(materialStatisticsList);
    }

    // 查看某一种物资申请 + cost
    @RequestMapping(value = "/materialStatistics", method = RequestMethod.GET)
    public ResultJson getSomeMaterialStatistics(@RequestParam String materialName) {
        return ResultJson.ok(materialStatisticsService.getSomeMaterialStatistics(materialName));
    }

    @RequestMapping(value = "/material/y", method = RequestMethod.PUT)
    public ResultJson adoptMaterialApplication(@RequestBody AdoptMaterialApplicationParam param) {
        return ResultJson.ok(applicationService.adoptMaterialApplication(param));
    }

    @RequestMapping(value = "/material/n", method = RequestMethod.PUT)
    public ResultJson refuseMaterialApplication(@RequestBody RefuseMaterialApplicationParam param) {
        return ResultJson.ok(applicationService.refuseMaterialApplication(param.getMaterialApplicationId(), param.getRefuseReason()));
    }

    // 添加一种物资
    @RequestMapping(value = "/material", method = RequestMethod.POST)
    public ResultJson addMaterial(@RequestParam String materialName) {
        return ResultJson.ok(materialStatisticsService.addMaterial(materialName));
    }

    // 删除一种物资
    @RequestMapping(value = "/material", method = RequestMethod.DELETE)
    public ResultJson deleteMaterial(@RequestParam Long materialId) {
        return ResultJson.ok(materialStatisticsService.deleteMaterial(materialId));
    }
}
