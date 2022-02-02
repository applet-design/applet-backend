package icu.shishc.applet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User implements Serializable {
    private Long userId;
    private String openId;
    private String wxName;
    private String avatar;
    private String realName;
    private String address;
    private String phone;
    private Integer age;
    private Integer gender;
}
