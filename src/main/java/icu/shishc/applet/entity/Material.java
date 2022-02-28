package icu.shishc.applet.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Material implements Serializable {
    private Long materialId;
    private String materialName;
}
