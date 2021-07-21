package kg.bakai.test.data.repository

import android.net.Uri
import kg.bakai.test.utils.Resource

class GalleryRepository {
    private val images = mutableListOf<Uri>()

    fun getImages(): Resource<List<Uri>> {
        return Resource.success(images)
    }

    fun setImages(list: List<Uri>) {
        images.addAll(list)
    }
}