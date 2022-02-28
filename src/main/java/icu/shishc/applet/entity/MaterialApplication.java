package icu.shishc.applet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 生活物资申请实体类.
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MaterialApplication implements Serializable {
    private Long applicationId;
    private Long applicantId;
    private String applicantName;
    private String applicantReason;
    private String materialName;
    private Integer materialNum;
    private Float price;
    private Float cost;
    private Integer isUrgency;
    private Integer isCancel;
    private String location;
    private Long approverId;
    private Integer result;
    private Date createTime;
    private Date approvalTime;
    private String refuseReason;
}
