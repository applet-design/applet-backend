package icu.shishc.applet.mapper;

import icu.shishc.applet.entity.Report;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReportMapper {

    Long addReport(Report report);

    Report selectReportById(Long reportId);

    List<Report> getReportList();
}
