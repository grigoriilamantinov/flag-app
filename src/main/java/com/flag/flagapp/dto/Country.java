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
public class Country {
    private String name;
    private Flag flags;

    @Override
    public String toString() {
        return "Country{" +
            "name='" + name + '\'' +
            ", flags=" + flags +
            '}';
    }
}
