package cz.kopemar.listdetail.application
import cz.kopemar.listdetail.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.*

val applicationModule: Module = module {
    viewModel { MainViewModel() }
}
