package kg.bakai.test.ui.gallery

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kg.bakai.test.data.repository.GalleryRepository
import kg.bakai.test.utils.Resource

class GalleryViewModel(private val repository: GalleryRepository): ViewModel() {
    private val _images = MutableLiveData<Resource<List<Uri>>>()
    val images: LiveData<Resource<List<Uri>>> = _images

    fun getImages() {
        _images.value = repository.getImages()
    }

    fun saveImages(list: List<Uri>) {
        repository.setImages(list)
    }
}