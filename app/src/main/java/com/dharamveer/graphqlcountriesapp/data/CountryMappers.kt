package com.dharamveer.graphqlcountriesapp.data

import com.dharamveer.CountriesQuery
import com.dharamveer.CountryQuery
import com.dharamveer.graphqlcountriesapp.domain.DetailedCountry
import com.dharamveer.graphqlcountriesapp.domain.SimpleCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
        currency = currency ?: "No currency",
        languages = languages.mapNotNull { it.name },
        continent = continent.name
    )
}

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital"
    )
}