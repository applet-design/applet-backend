package icu.shishc.applet.service.impl;

import icu.shishc.applet.controller.param.ReportParam;
import icu.shishc.applet.entity.Report;
import icu.shishc.applet.mapper.ReportMapper;
import icu.shishc.applet.service.ReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Resource
    ReportMapper reportMapper;

    @Override
    public Long addReport(ReportParam reportParam) {
        Report report = new Report();
        report.setName(reportParam.getName());
        report.setIdNum(reportParam.getIdNum());
        report.setPhone(reportParam.getPhone());
        report.setLocation(reportParam.getLocation());
        report.setAddress(reportParam.getAddress());
        report.setWay(reportParam.getWay());
        report.setApproverId(reportParam.getApproverId());
        return reportMapper.addReport(report);
    }

    @Override
    public Report getReportById(Long reportId) {
        return reportMapper.selectReportById(reportId);
    }

    @Override
    public List<Report> getReportList() {
        return reportMapper.getReportList();
    }
}
