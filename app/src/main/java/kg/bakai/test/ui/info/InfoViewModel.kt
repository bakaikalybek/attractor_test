package kg.bakai.test.ui.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.bakai.test.data.repository.InfoRepository
import kg.bakai.test.domain.model.User
import kg.bakai.test.utils.Resource
import kotlinx.coroutines.launch

class InfoViewModel(private val repository: InfoRepository): ViewModel() {
    private val _user = MutableLiveData<Resource<User>>()
    val user: LiveData<Resource<User>> = _user

    fun getUser() {
        viewModelScope.launch {
            _user.postValue(repository.getUser())
        }
    }
}