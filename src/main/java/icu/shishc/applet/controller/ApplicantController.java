package icu.shishc.applet.controller;

import icu.shishc.applet.controller.param.MaterialApplicationParam;
import icu.shishc.applet.entity.MaterialApplication;
import icu.shishc.applet.service.ApplicationService;
import icu.shishc.applet.util.ResultJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/apply")
public class ApplicantController {

    @Resource
    ApplicationService applicationService;

    @RequestMapping(value = "/material", method = RequestMethod.POST)
    public ResultJson addMaterialApplication(@RequestBody MaterialApplicationParam materialApplicationParam) {
        Long applicationId = applicationService.addMaterialApplication(materialApplicationParam);
        return ResultJson.ok(applicationId);
    }

    @RequestMapping(value = "/material", method = RequestMethod.GET)
    public ResultJson getMaterialApplicationById(@RequestParam Long materialApplicationId) {
        MaterialApplication materialApplication = applicationService.getMaterialApplicationById(materialApplicationId);
        return ResultJson.ok(materialApplication);
    }

    @RequestMapping(value = "/material", method = RequestMethod.DELETE)
    public ResultJson cancelMaterialApplication(@RequestParam Long materialApplicationId) {
        Integer result = applicationService.cancelMaterialApplicationById(materialApplicationId);
        return ResultJson.ok(result);
    }

}
