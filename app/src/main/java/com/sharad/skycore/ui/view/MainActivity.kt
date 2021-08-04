package com.sharad.skycore.ui.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatSeekBar
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sharad.skycore.data.model.Businesses
import com.sharad.skycore.data.viewmodel.MainViewModel
import com.sharad.skycore.data.viewmodel.ViewModelFactory
import com.sharad.skycore.ui.adapter.MainAdapter
import com.sharad.skycore.utils.Status
import com.sharad.skycore.R
import com.sharad.skycore.data.api.ApiHelper
import com.sharad.skycore.data.api.RetrofitBuilder

/**
 * Created by Sharad-Ubuntu on 07/05/2021.
 */
class MainActivity : AppCompatActivity() {

    private var mDistance: Int = 200
    private lateinit var seekBar: AppCompatSeekBar
    private lateinit var textViewCurrentDistance: AppCompatTextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: MainAdapter
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
        setupUI()
        setupObservers()
    }


    private fun setupUI() {

        textViewCurrentDistance = findViewById(R.id.textViewCurrentDistance)
        progressBar = findViewById(R.id.progressBar)
        seekBar = findViewById(R.id.seekBar)
        recyclerView = findViewById(R.id.recyclerView)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                setupObservers()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                mDistance = progress
                if (progress < 1000) {
                    "$progress Meter".also { textViewCurrentDistance.text = it }
                } else {
                    val progressInKm = progress / 1000
                    val progressInMeter = progress % 1000
                    "$progressInKm.$progressInMeter KM".also { textViewCurrentDistance.text = it }
                }

            }
        })
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                0
            )
        )
        recyclerView.adapter = adapter
    }
    private fun setupObservers() {
        progressBar.visibility = View.VISIBLE


    viewModel.getRestaurants(mDistance).observe(this, Observer {
        it?.let { resource ->
            when (resource.status) {
                Status.SUCCESS -> {
                    recyclerView.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                    resource.data?.let { users -> retrieveList(users.businesses) }
                }
                Status.ERROR -> {
                    recyclerView.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
            }
        }
    })
    }

    private fun retrieveList(users: ArrayList<Businesses>) {
        adapter.apply {
            addUsers(users)
            notifyDataSetChanged()
        }
    }
}
