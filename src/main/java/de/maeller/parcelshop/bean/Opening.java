package de.maeller.parcelshop.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Opening implements Serializable {
    private static final long serialVersionUID = -2789304956453173956L;
    private String dayOfWeek;
    private String openFrom;
    private String openTill;
}
