package com.cep96.padc_x_travel_assignment_cep.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cep96.padc_x_travel_assignment_cep.R
import com.cep96.padc_x_travel_assignment_cep.activities.PopularToursDetailActivity
import com.cep96.padc_x_travel_assignment_cep.activities.PopularToursDetailActivity.Companion.TOURS_TYPE
import com.cep96.padc_x_travel_assignment_cep.adapters.CountryListAdapter
import com.cep96.padc_x_travel_assignment_cep.adapters.PopularToursListAdapter
import com.cep96.padc_x_travel_assignment_cep.data.models.ToursModelImpl
import com.cep96.padc_x_travel_assignment_cep.viewmodels.ToursViewModel
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ToursVO
import kotlinx.android.synthetic.main.fragment_nav_home.*


/**
 * A simple [Fragment] subclass.
 */
class BottomNavHomeFragment : Fragment() {

    private lateinit var mCountryAdapter: CountryListAdapter
    private lateinit var mPopularToursAdapter: PopularToursListAdapter

    private var toursList: List<ToursVO> = arrayListOf()
    private var countryList: List<CountryVO> = arrayListOf()

    private lateinit var mToursViewModel: ToursViewModel

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

        setUpViewModel()

        setUpSwipeRefresh()
        setUpRecyclerView()
        setUpDataFromDB()
        setUpDataObservations()

    }

    private fun setUpDataFromDB() {
        mToursViewModel.getData()
    }

    private fun setUpDataObservations() {
        mToursViewModel.getPopularToursLiveData()
            .observe(this, Observer {
                it.let {
                    mPopularToursAdapter.setNewData(it)

                }
            })

        mToursViewModel.getCountriesLiveData()
            .observe(this, Observer {
                it.let {
                    mCountryAdapter.setNewData(it)
                }
            })

        mToursViewModel.getErrorLiveData()
            .observe(this, Observer {
                Toast.makeText(this.requireContext(), it, Toast.LENGTH_LONG).show()
            })

    }

    private fun setUpViewModel() {
        mToursViewModel =
            ViewModelProviders.of(this.requireActivity()).get(ToursViewModel::class.java)

    }

    private fun setUpRecyclerView() {
        // for country list
        mCountryAdapter = CountryListAdapter { name ->
            val intent = PopularToursDetailActivity.getIntent(context!!, name)
            intent.putExtra(TOURS_TYPE, "country")
            startActivity(intent)
        }

        rcCountry.adapter = mCountryAdapter
        rcCountry.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // for popular tours list
        mPopularToursAdapter = PopularToursListAdapter { name ->
            val intent = PopularToursDetailActivity.getIntent(context!!, name)
            intent.putExtra(TOURS_TYPE, "popular")
            startActivity(intent)
        }

        rcPopularTours.adapter = mPopularToursAdapter
        rcPopularTours.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }

    private fun setUpSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener {
            //            requestData()
            setUpDataObservations()
        }
    }

    companion object {
        fun newInstance(): BottomNavHomeFragment {
            val fragment = BottomNavHomeFragment()
            return fragment
        }
    }

}
