package com.flag.flagapp.service;


import com.flag.flagapp.dto.Country;

import java.util.List;

public interface FlagService {
    List<Country> getCountries(String countriesCodes);

    void saveFlags(String countriesCodes);
}
