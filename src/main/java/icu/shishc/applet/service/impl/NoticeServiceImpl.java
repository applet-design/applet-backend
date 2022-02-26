package icu.shishc.applet.service.impl;

import icu.shishc.applet.controller.param.NoticeParam;
import icu.shishc.applet.entity.Notice;
import icu.shishc.applet.mapper.NoticeMapper;
import icu.shishc.applet.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Resource
    NoticeMapper noticeMapper;

    @Override
    public Long addNotice(NoticeParam noticeParam) {
        Notice notice = new Notice();
        notice.setSponsorId(noticeParam.getSponsorId());
        notice.setCreateTime(new Date());
        notice.setNoticeTitle(noticeParam.getTitle());
        notice.setNoticeContent(noticeParam.getContent());
        return noticeMapper.addNotice(notice);
    }

    @Override
    public Notice getNoticeById(Long noticeId) {
        return noticeMapper.getNoticeByNoticeId(noticeId);
    }

    @Override
    public List<Notice> getNoticeList() {
        List<Notice> list = noticeMapper.getNoticeList();
        return list;
    }
}
