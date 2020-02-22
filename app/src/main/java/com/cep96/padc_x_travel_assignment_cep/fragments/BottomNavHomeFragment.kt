package com.cep96.padc_x_travel_assignment_cep.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.cep96.padc_x_travel_assignment_cep.R
import com.cep96.padc_x_travel_assignment_cep.activities.PopularToursDetailActvity
import com.cep96.padc_x_travel_assignment_cep.adapters.CountryListAdapter
import com.cep96.padc_x_travel_assignment_cep.adapters.PopularToursListAdapter
import com.cep96.padc_x_travelapp_assignment_cep.data.models.ToursModelImpl
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_nav_home.*

/**
 * A simple [Fragment] subclass.
 */
class BottomNavHomeFragment : Fragment() {

    private lateinit var mCountryAdapter: CountryListAdapter
    private lateinit var mPopularToursAdapter: PopularToursListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpSwipeRefresh()
        setUpRecyclerView()

        requestData()

    }

    private fun requestData() {
        ToursModelImpl.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.countries.let {
                    mCountryAdapter.setNewData(it)
                }

                it.tours.let {
                    mPopularToursAdapter.setNewData(it)
                }

                swipeRefreshLayout.isRefreshing = false
            },{
                swipeRefreshLayout.isRefreshing = false
                Log.i("Error", it.localizedMessage)
            })
    }

    private fun setUpRecyclerView() {
        // for country list
        mCountryAdapter = CountryListAdapter {
            startActivity(PopularToursDetailActvity.getIntent(context!!))
        }

        rcCountry.adapter = mCountryAdapter
        rcCountry.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // for popular tours list
        mPopularToursAdapter = PopularToursListAdapter{
            startActivity(PopularToursDetailActvity.getIntent(context!!))
        }

        rcPopularTours.adapter = mPopularToursAdapter
        rcPopularTours.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }

    private fun setUpSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener {
            requestData()
        }
    }

    companion object{
        fun newInstance(): BottomNavHomeFragment{
            val fragment = BottomNavHomeFragment()
            return fragment
        }
    }

}
