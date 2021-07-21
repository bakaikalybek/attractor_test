package kg.bakai.test.domain.model

import com.google.gson.annotations.SerializedName

enum class Education {
    @SerializedName("1")
    HIGH_SCHOOL,
    @SerializedName("2")
    BACHELOR,
    @SerializedName("3")
    MASTER,
    @SerializedName("4")
    DOCTORAL

}