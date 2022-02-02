package icu.shishc.applet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Community implements Serializable {
    private Long communityId;
    private String communityName;
    private String address;
}
