package com.cep96.padc_x_travel_assignment_cep.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cep96.padc_x_travel_assignment_cep.R
import com.cep96.padc_x_travel_assignment_cep.activities.PopularToursDetailActivity
import com.cep96.padc_x_travel_assignment_cep.adapters.CountryListAdapter
import com.cep96.padc_x_travel_assignment_cep.adapters.PopularToursListAdapter
import com.cep96.padc_x_travel_assignment_cep.mvp.presenters.HomePresenter
import com.cep96.padc_x_travel_assignment_cep.mvp.presenters.HomePresenterImpl
import com.cep96.padc_x_travel_assignment_cep.mvp.views.HomeView
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ToursVO
import kotlinx.android.synthetic.main.fragment_nav_home.*


/**
 * A simple [Fragment] subclass.
 */
class BottomNavHomeFragment : Fragment(), HomeView {
    override fun displayToursList(tours: List<ToursVO>) {
        mPopularToursAdapter.setNewData(tours)
    }

    override fun displayCountriesList(countries: List<CountryVO>) {
        mCountryAdapter.setNewData(countries)
    }

    override fun navigateToTourDetails(toursName: String) {
        startActivity(PopularToursDetailActivity.getIntent(this.requireContext(), toursName))
    }

    override fun navigateToCountryDetails(countryName: String) {
        startActivity(PopularToursDetailActivity.getIntent(this.requireContext(), countryName))
    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun displayToursEmpty() {

    }

    override fun displayCountriesEmpty() {

    }

    private lateinit var mCountryAdapter: CountryListAdapter
    private lateinit var mPopularToursAdapter: PopularToursListAdapter

    private lateinit var mPresenter: HomePresenter

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

        setUpPresenter()

        setUpDataFromDB()

        setUpSwipeRefresh()
        setUpRecyclerView()

//        requestData()
        mPresenter.onToursUIReady(this)

    }

    @SuppressLint("CheckResult")
    private fun setUpDataFromDB() {


    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this.requireActivity()).get(HomePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

//    private fun requestData() {
//
//        ToursModelImpl.getAllCountries {}
//            .observe(this, Observer {
//                it.let {
//                    mCountryAdapter.setNewData(it)
//                }
//            })
//
//        ToursModelImpl.getAllTours {}
//            .observe(this, Observer {
//                it.let {
//                    mPopularToursAdapter.setNewData(it)
//                }
//            })
//
//    }

    private fun setUpRecyclerView() {
        // for country list
        mCountryAdapter = CountryListAdapter { name ->
//            startActivity(PopularToursDetailActivity.getIntent(context!!, name))
            mPresenter.onTapCountryItem(name)
        }

        rvCountry.adapter = mCountryAdapter
        rvCountry.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // for popular tours list
        mPopularToursAdapter = PopularToursListAdapter{ name ->
//            startActivity(PopularToursDetailActivity.getIntent(context!!, name))
            mPresenter.onTapTourItem(name)
        }

        rvPopularTours.adapter = mPopularToursAdapter
        rvPopularTours.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }

    private fun setUpSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener {
//            requestData()
            mPresenter.onToursUIReady(this)
        }
    }

    companion object{
        fun newInstance(): BottomNavHomeFragment{
            val fragment = BottomNavHomeFragment()
            return fragment
        }
    }

}
