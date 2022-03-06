package icu.shishc.applet.controller;

import icu.shishc.applet.controller.param.ReportParam;
import icu.shishc.applet.entity.Report;
import icu.shishc.applet.service.ReportService;
import icu.shishc.applet.util.ResultJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

// 外来人员报备接口
@RestController
@RequestMapping("/api")
public class ReportController {

    @Resource
    ReportService reportService;

    // 外来人员报备
    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public ResultJson addReport(@RequestBody ReportParam reportParam) {
        Long reportId = reportService.addReport(reportParam);
        return ResultJson.ok(reportId);
    }

    // 查看外来人员报备单
    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public ResultJson getReport(@RequestParam Long reportId) {
        Report report = reportService.getReportById(reportId);
        return ResultJson.ok(report);
    }

}
