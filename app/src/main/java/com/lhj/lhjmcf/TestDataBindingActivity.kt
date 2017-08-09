package com.lhj.lhjmcf

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lhj.lhjmcf.databinding.TestBinding

class TestDataBindingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_test_data_binding)

        val dataBinding : TestBinding = DataBindingUtil.setContentView(this, R.layout.test)

//        val user = User("Kuma", 23)
//        dataBinding.setVariable(BR.user, user)

        val viewModel = TestModel()
        dataBinding.setVariable(BR.viewModel, viewModel)

        dataBinding.executePendingBindings()
    }

    data class User(val name: String, val age: Int)
}
