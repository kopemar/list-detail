package cz.kopemar.listdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cz.kopemar.listdetail.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        vm.doSomething()
    }

}
