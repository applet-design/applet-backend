package icu.shishc.applet.entity;

import lombok.Data;

@Data
public class User {
    private Long userId;
    private Long unionId;
    private String wxName;
    private String realName;
    private String address;
    private String phone;
    private int age;
    private int gender;
}
