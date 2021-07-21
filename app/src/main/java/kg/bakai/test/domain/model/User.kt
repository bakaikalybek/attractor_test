package kg.bakai.test.domain.model

import com.beust.klaxon.Json
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("second_name")
    val secondName: String,
    val photo: String,
    val education: Education,
    val company: List<Company>
)