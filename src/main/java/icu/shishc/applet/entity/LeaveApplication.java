package icu.shishc.applet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

/**
 * 出小区申请表
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class LeaveApplication {
    private Long leaveId;
    private Long applicantId;
    private String applicantName;
    private String address;
    private Date leaveTime;
    private Date backTime;
    private Integer way;
    private String destination;
    private Integer isCancel;
    private String Reason;
    private Date createTime;
    private Long approverId;
    private Integer result;
    private String refuseReason;
    private Date approvalTime;
}
