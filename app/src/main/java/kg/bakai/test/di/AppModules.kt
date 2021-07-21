package kg.bakai.test.di

import com.google.gson.Gson
import kg.bakai.test.data.repository.GalleryRepository
import kg.bakai.test.data.repository.InfoRepository
import kg.bakai.test.ui.gallery.GalleryViewModel
import kg.bakai.test.ui.info.InfoViewModel
import kg.bakai.test.utils.Converter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { Gson() }
    single { Converter() }
}
val repositoryModule = module {
    single { InfoRepository(get(), get()) }
    single { GalleryRepository() }
}

val viewModelModule = module {
    viewModel { InfoViewModel(get()) }
    viewModel { GalleryViewModel(get()) }
}