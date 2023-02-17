package com.plcoding.stockmarketapp.data.remote

import com.plcoding.stockmarketapp.data.remote.dto.CompanyInfoDto
import com.plcoding.stockmarketapp.domain.model.CompanyInfo
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface StockApi {

    @GET ("query?function=LISTING_STATUS")
    suspend fun getListings(
        @Query ("apikey") apiKey: String = API_KEY
    ):ResponseBody

     @GET("query?function=TIME_SERIES_INTRADAY&interval=60min&datatype=csv")
     suspend fun getIntradayInfo(
         @Query("symbol") symbol: String,
         @Query("apikey") apiKey: String= API_KEY
     ): ResponseBody

     @GET("query?function=OVERVIEW")
     suspend fun getCompanyInfo(
         @Query("symbol") symbol: String,
         @Query("apikey") apiKey: String= API_KEY
     ): CompanyInfoDto

    companion object{
        const val API_KEY = "PYTEJUR5IX2YBNFK"
        const val BASE_URL = "https://www.alphavantage.co"
    }
}