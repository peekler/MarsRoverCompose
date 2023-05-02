package hu.bme.aut.roverphotogallery.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RoverPhotos(
    @SerialName("photos")
    val photos: List<Photo?>? = null
)