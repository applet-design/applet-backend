package icu.shishc.applet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
// 已发放物资统计
public class MaterialStatistics {
    private Long materialFormId;
    private String materialName;
    private Integer materialNum;
    private Float price;
    private Long receiveId;
    private Long fromId;
    private Date createTime;
    private Float cost;
}
