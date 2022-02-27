package icu.shishc.applet.service;

import icu.shishc.applet.controller.param.ReportParam;
import icu.shishc.applet.entity.Report;

import java.util.List;

public interface ReportService {

    // 添加一条报备记录
    Long addReport(ReportParam reportParam);

    // 查看报备记录通过id
    Report getReportById(Long reportId);

    // 通过报备
    List<Report> getReportList();
}
