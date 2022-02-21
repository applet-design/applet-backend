package icu.shishc.applet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

/**
 *
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Report {
    private Long reportId;
    private String name;
    // 身份证
    private String idNum;
    private String phone;
    // 来前住址
    private String location;
    // 来后住处
    private String address;
    //0自驾，1火车，2高铁，3动车，4飞机
    private Integer way;
    private Date createTime;
    // 物业id
    private Long approverId;
}
