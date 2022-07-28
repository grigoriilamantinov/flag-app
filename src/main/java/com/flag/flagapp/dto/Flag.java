package com.flag.flagapp.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Flag {
    private String svg;
    private String png;

    @Override
    public String toString() {
        return "Flag{" +
            "svg='" + svg + '\'' +
            ", png='" + png + '\'' +
            '}';
    }
}
