package id.slava.nt.pruebatecnicasergiocaseroapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://sergiocasero.es/"
private const val END_POINT = "pois.json"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(JacksonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface PoiListApiService{

    @GET(END_POINT)
    suspend fun getPoiList(): MainPoiListData?

}

object PoiApi{
    val retrofitService : PoiListApiService by lazy {
        retrofit.create(PoiListApiService::class.java) }
}