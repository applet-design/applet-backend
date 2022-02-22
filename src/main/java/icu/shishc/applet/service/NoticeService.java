package icu.shishc.applet.service;

import icu.shishc.applet.controller.param.NoticeParam;
import icu.shishc.applet.entity.Notice;

import java.util.List;

public interface NoticeService {

    Long addNotice(NoticeParam noticeParam);

    Notice getNoticeById(Long noticeId);

    List<Notice> getNoticeList();

}
