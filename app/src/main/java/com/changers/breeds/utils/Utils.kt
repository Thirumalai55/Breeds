package com.changers.breeds.utils
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.view.LayoutInflater
import com.changers.breeds.BreedsApplication
import com.changers.breeds.R
import android.content.Context as Context1

/*
* Util class for keep hold common methods
* */
class Utils {

    companion object {
        private var mProgressDialog: Dialog? = null
    }

    /*
    * Show progress bar
    * */
    fun showProgressDialog(context: Context1) {
        mProgressDialog = Dialog(context)
        val inflate = LayoutInflater.from(context).inflate(R.layout.progress_layout, null)
        mProgressDialog?.setContentView(inflate)
        mProgressDialog?.setCancelable(false)
        mProgressDialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        mProgressDialog?.show()
    }

    /*
    * Cancel progress bar
    **/
    fun cancelProgressDialog() {
        if(mProgressDialog != null) {
            mProgressDialog?.dismiss()
            mProgressDialog = null
        }
    }

    /*
    * Check internet connection status
    * */
    fun isNetworkConnected(): Boolean {
        val cm: ConnectivityManager =
            BreedsApplication.mApplicationContext.getSystemService(Context1.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null
    }

}