package com.dharamveer.graphqlcountriesapp.data

import com.apollographql.apollo3.ApolloClient
import com.dharamveer.CountriesQuery
import com.dharamveer.CountryQuery
import com.dharamveer.graphqlcountriesapp.domain.CountryClient
import com.dharamveer.graphqlcountriesapp.domain.DetailedCountry
import com.dharamveer.graphqlcountriesapp.domain.SimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
): CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }
}