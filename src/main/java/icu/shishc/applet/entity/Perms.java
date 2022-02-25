package icu.shishc.applet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Perms {
    Integer userIdentity;
    String entity;
    String perm;
}
