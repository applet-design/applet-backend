package icu.shishc.applet.mapper;

import icu.shishc.applet.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NoticeMapper {

    Long addNotice(Notice notice);

    Notice getNoticeByNoticeId(Long noticeId);

    List<Notice> getNoticeList();
}
