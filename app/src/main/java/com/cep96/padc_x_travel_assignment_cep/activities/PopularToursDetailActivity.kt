package com.cep96.padc_x_travel_assignment_cep.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.cep96.padc_x_travel_assignment_cep.R
import com.cep96.padc_x_travel_assignment_cep.adapters.PhotosListAdapter
import com.cep96.padc_x_travel_assignment_cep.data.models.ToursModelImpl
import com.cep96.padc_x_travel_assignment_cep.viewmodels.ToursDetailViewModel
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ToursVO
import kotlinx.android.synthetic.main.activity_popular_tours_detail_actvity.*
import kotlinx.android.synthetic.main.activity_popular_tours_detail_actvity.tvAverageRating

class PopularToursDetailActivity : AppCompatActivity() {

    private lateinit var mPhotoAdapter: PhotosListAdapter
    private lateinit var mToursViewModel: ToursDetailViewModel
    private lateinit var toursName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular_tours_detail_actvity)

        toursName = intent.getStringExtra(EXTRA_NAME)
        val toursType = intent.getStringExtra(TOURS_TYPE)

        setUpViewModel()

        setUpToursData(toursType)

    }

    private fun setUpViewModel() {
        mToursViewModel = ViewModelProviders.of(this).get(ToursDetailViewModel::class.java)
    }

    private fun setUpToursData(toursType: String?) {
        if (toursType == "country") {
            mToursViewModel.getCountryByName(toursName)
                .observe(this, Observer {
                    it.apply {
                        setUpCountryData(it)
                    }
                })
        } else {
            mToursViewModel.getPopularToursByName(toursName)
                .observe(this, Observer {
                    it.apply {
                        setUpPopularToursData(it)
                    }
                })
        }
    }

    private fun setUpPopularToursData(it: ToursVO) {
        Glide.with(this)
            .load(it.photos[0])
            .into(ivTours)

        tvAverageRating.text = it.averageRating.toString()
        tvBookingScores.text =
            "${it.scoresAndReviews[0].maxScore}/${it.scoresAndReviews[0].maxScore}"
        tvBookingTotalReviews.text = "Base on ${it.scoresAndReviews[0].totalReview} reviews"

        tvHotelOutScores.text = "${it.scoresAndReviews[1].score}/${it.scoresAndReviews[1].maxScore}"
        tvHotelOutTotalReviews.text = "Base on ${it.scoresAndReviews[1].totalReview} reviews"

        tvDescription.text = it.description

        setUpPhotosRecyclerView(it.photos)
    }

    private fun setUpCountryData(it: CountryVO) {
        Glide.with(this)
            .load(it.photos[0])
            .into(ivTours)

        tvAverageRating.text = it.averageRating.toString()
        tvBookingScores.text =
            "${it.scoresAndReviews[0].maxScore}/${it.scoresAndReviews[0].maxScore}"
        tvBookingTotalReviews.text = "Base on ${it.scoresAndReviews[0].totalReview} reviews"

        tvHotelOutScores.text = "${it.scoresAndReviews[1].score}/${it.scoresAndReviews[1].maxScore}"
        tvHotelOutTotalReviews.text = "Base on ${it.scoresAndReviews[1].totalReview} reviews"

        tvDescription.text = it.description

        setUpPhotosRecyclerView(it.photos)
    }

    private fun setUpPhotosRecyclerView(photos: List<String>) {
        mPhotoAdapter = PhotosListAdapter()
        mPhotoAdapter.setNewData(photos)

        rvPhotos.adapter = mPhotoAdapter
        rvPhotos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }

    companion object {

        const val EXTRA_NAME = "EXTRA_NAME"
        const val TOURS_TYPE = "TOURS_TYPE"

        fun getIntent(context: Context): Intent {
            return Intent(context, PopularToursDetailActivity::class.java)
        }

        fun getIntent(context: Context, name: String): Intent {
            val intent = Intent(context, PopularToursDetailActivity::class.java)
            intent.putExtra(EXTRA_NAME, name)
            return intent
        }
    }
}
