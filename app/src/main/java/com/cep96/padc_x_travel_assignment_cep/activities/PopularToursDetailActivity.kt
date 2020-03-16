package com.cep96.padc_x_travel_assignment_cep.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.cep96.padc_x_travel_assignment_cep.R
import com.cep96.padc_x_travel_assignment_cep.adapters.PhotosListAdapter
import com.cep96.padc_x_travel_assignment_cep.data.models.ToursModelImpl
import com.cep96.padc_x_travel_assignment_cep.mvp.presenters.PopularToursDetailPresenterImpl
import com.cep96.padc_x_travel_assignment_cep.mvp.views.PopularToursDetailView
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ToursVO
import kotlinx.android.synthetic.main.activity_popular_tours_detail_actvity.*
import kotlinx.android.synthetic.main.activity_popular_tours_detail_actvity.tvAverageRating

class PopularToursDetailActivity : AppCompatActivity(), PopularToursDetailView{
    override fun displayCountryDetails(country: CountryVO) {
        Glide.with(this)
            .load(country.photos[0])
            .into(ivTours)

        tvAverageRating.text = country.averageRating.toString()
        tvBookingScores.text = "${country.scoresAndReviews[0].maxScore}/${country.scoresAndReviews[0].maxScore}"
        tvBookingTotalReviews.text = "Base on ${country.scoresAndReviews[0].totalReview} reviews"

        tvHotelOutScores.text = "${country.scoresAndReviews[1].score}/${country.scoresAndReviews[1].maxScore}"
        tvHotelOutTotalReviews.text = "Base on ${country.scoresAndReviews[1].totalReview} reviews"

        tvDescription.text = country.description

        setUpPhotosRecyclerView(country.photos)
    }

    override fun displayToursDetails(tour: ToursVO) {
        Glide.with(this)
            .load(tour.photos[0])
            .into(ivTours)

        tvAverageRating.text = tour.averageRating.toString()
        tvBookingScores.text = "${tour.scoresAndReviews[0].maxScore}/${tour.scoresAndReviews[0].maxScore}"
        tvBookingTotalReviews.text = "Base on ${tour.scoresAndReviews[0].totalReview} reviews"

        tvHotelOutScores.text = "${tour.scoresAndReviews[1].score}/${tour.scoresAndReviews[1].maxScore}"
        tvHotelOutTotalReviews.text = "Base on ${tour.scoresAndReviews[1].totalReview} reviews"

        tvDescription.text = tour.description

        setUpPhotosRecyclerView(tour.photos)
    }

    override fun showEmptyView() {
        llView.visibility = View.GONE
        tvEmptyView.visibility = View.VISIBLE

    }

    override fun hideEmptyView() {
        llView.visibility = View.VISIBLE
        tvEmptyView.visibility = View.GONE
    }

    private var photos: List<String> = arrayListOf()

    private lateinit var mPhotoAdapter: PhotosListAdapter

    private lateinit var mPopularToursDetailsPresenter: PopularToursDetailPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular_tours_detail_actvity)

        setUpPresenter()

        val name = intent.getStringExtra(EXTRA_NAME)

        mPopularToursDetailsPresenter.onUIReady(this, name)
//        getToursFromDB(name)

    }

    private fun setUpPresenter() {
        mPopularToursDetailsPresenter = ViewModelProviders.of(this)
            .get(PopularToursDetailPresenterImpl::class.java)
        mPopularToursDetailsPresenter.initPresenter(this)
    }

    private fun setUpPhotosRecyclerView(photos: List<String>) {
        mPhotoAdapter = PhotosListAdapter()
        mPhotoAdapter.setNewData(photos)

        rvPhotos.adapter = mPhotoAdapter
        rvPhotos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }

    private fun getToursFromDB(name: String) {
        ToursModelImpl.getCountryByName(name).observe(
            this, Observer {
                Glide.with(this)
                    .load(it.photos[0])
                    .into(ivTours)

                tvAverageRating.text = it.averageRating.toString()
                tvBookingScores.text = "${it.scoresAndReviews[0].maxScore}/${it.scoresAndReviews[0].maxScore}"
                tvBookingTotalReviews.text = "Base on ${it.scoresAndReviews[0].totalReview} reviews"

                tvHotelOutScores.text = "${it.scoresAndReviews[1].score}/${it.scoresAndReviews[1].maxScore}"
                tvHotelOutTotalReviews.text = "Base on ${it.scoresAndReviews[1].totalReview} reviews"

                tvDescription.text = it.description

                setUpPhotosRecyclerView(it.photos)
            }
        )
    }

    companion object{

        const val EXTRA_NAME = "EXTRA_NAME"

        fun getIntent(context: Context): Intent{
            return Intent(context, PopularToursDetailActivity::class.java)
        }

        fun getIntent(context: Context, name: String): Intent{
            val intent = Intent(context, PopularToursDetailActivity::class.java)
            intent.putExtra(EXTRA_NAME, name)
            return intent
        }
    }
}
