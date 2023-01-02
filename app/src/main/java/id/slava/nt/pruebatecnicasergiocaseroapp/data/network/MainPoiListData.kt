package id.slava.nt.pruebatecnicasergiocaseroapp.data.network

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import id.slava.nt.pruebatecnicasergiocaseroapp.data.database.PoiDbEntity


@JsonIgnoreProperties(ignoreUnknown = true)
data class MainPoiListData (

        @JsonProperty("list")
        var listPoiData: List<PoiData>

        )

@JsonIgnoreProperties(ignoreUnknown = true)
data class PoiData(

        @JsonProperty("id")
        val id: Int,
        @JsonProperty("title")
        val title: String?,
        @JsonProperty("geocoordinates")
        val coordinates: String?,
        @JsonProperty("image")
        val imageUrl: String?
)

fun MainPoiListData.asDbModel(): List<PoiDbEntity> =
        listPoiData.map { poiData ->

                PoiDbEntity(
                        id = poiData.id,
                        title = poiData.title,
                        coordinates = poiData.coordinates,
                        imageUrl = poiData.imageUrl
                )
        }



