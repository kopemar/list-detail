package cz.kopemar.listdetail.activities

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cz.kopemar.listdetail.R

abstract class BaseActivity : AppCompatActivity() {

    companion object {
        fun checkConnection(app: Activity): Boolean {
            val cm = app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val net = cm.activeNetworkInfo
            if (net != null && net.isConnected) {
                return true
            }
            Toast.makeText(app, app.resources.getText(R.string.no_connection), Toast.LENGTH_SHORT).show()
            return false
        }
    }

}