package cz.kopemar.listdetail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class RepositoryActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("RepositoryActivity", "onCreate() called")

        actionBar?.setDisplayHomeAsUpEnabled(true)

        setContentView(R.layout.activity_repository)
    }

}