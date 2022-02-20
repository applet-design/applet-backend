package icu.shishc.applet.controller.param;

import lombok.Data;

import java.io.Serializable;

/**
 * 生活物资申请表需要参数.
 */
@Data
public class MaterialApplicationParam implements Serializable {
    private Long applicantId;
    private String applicantName;
    private String applicantReason;
    private String materialName;
    private Integer materialNum;
    private Integer isUrgency;
    private String location;
    private Long approverId;
}
