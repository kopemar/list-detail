package cz.kopemar.listdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cz.kopemar.listdetail.fragments.RepositoriesFragment
import cz.kopemar.listdetail.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.vFragmentFrame, RepositoriesFragment()).commit()
    }

}
