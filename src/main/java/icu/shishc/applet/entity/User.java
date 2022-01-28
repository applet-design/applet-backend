package icu.shishc.applet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    private Long userId;
    private String openId;
    private String wxName;
    private String realName;
    private String address;
    private String phone;
    private int age;
    private int gender;
}
