package com.coxtunes.datastorejetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import com.coxtunes.datastorejetpack.manager.UserManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var userManager: UserManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize user Manager with Configuration object
        userManager = UserManager(this)


            // Click event to Store Data into DataStore
            btn.setOnClickListener {
                GlobalScope.launch(Dispatchers.IO) {
                    userManager.storeUser(name.text.toString(), email.text.toString())
                }
            }

            // Clear Name
            button_delete_name.setOnClickListener {
                GlobalScope.launch(Dispatchers.IO) {
                    userManager.clearName()
                }
            }

            // Clear Name
            button_delete_email.setOnClickListener {
                GlobalScope.launch(Dispatchers.IO) {
                    userManager.clearEmail()
                }
            }

        // Observe data realtime using flow
        observeData()
    }

    private fun observeData() {

        //Realtime update name data to show in result
        userManager.userNameFlow.asLiveData().observe(this) {
            if (it != null) {
                result_txt_name.text = it.toString()
            }
        }

        //Realtime update email data to show in result
        userManager.userEmailFlow.asLiveData().observe(this) {
            if (it != null) {
                result_txt_email.text = it
            }
        }

    }

}