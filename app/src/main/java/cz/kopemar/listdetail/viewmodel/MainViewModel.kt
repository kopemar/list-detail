package cz.kopemar.listdetail.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    fun doSomething() {
        Log.e("MainVM", "doing something")
    }

}