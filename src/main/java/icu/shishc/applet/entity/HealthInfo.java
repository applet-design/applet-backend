package icu.shishc.applet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class HealthInfo {
    private Long infoId;
    private Long personId;
    private String submitDate;
    private String realName;
    private String address;
    private Float temperature;
    private Integer symptom;
    private String location;
    // 最后一次核酸时间
    private String lastTime;
}
