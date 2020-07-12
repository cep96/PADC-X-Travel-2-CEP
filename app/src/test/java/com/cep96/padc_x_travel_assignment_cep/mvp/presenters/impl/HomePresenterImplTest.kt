package com.cep96.padc_x_travel_assignment_cep.mvp.presenters.impl

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cep96.padc_x_travel_assignment_cep.data.models.MockToursModelImpl
import com.cep96.padc_x_travel_assignment_cep.data.models.ToursModel
import com.cep96.padc_x_travel_assignment_cep.data.models.ToursModelImpl
import com.cep96.padc_x_travel_assignment_cep.dummy.getDummyCountries
import com.cep96.padc_x_travel_assignment_cep.dummy.getDummyTours
import com.cep96.padc_x_travel_assignment_cep.mvp.presenters.HomePresenterImpl
import com.cep96.padc_x_travel_assignment_cep.mvp.views.HomeView
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ScoresAndReviewsVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ToursVO
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@RunWith(AndroidJUnit4::class)
class HomePresenterImplTest {

    private lateinit var mPresenter: HomePresenterImpl

    @RelaxedMockK
    private lateinit var mView: HomeView

    private lateinit var mTourModel: ToursModel

    @Before
    fun setUpPresenter(){
        MockKAnnotations.init(this)

        ToursModelImpl.initModel(ApplicationProvider.getApplicationContext())
        mTourModel = MockToursModelImpl

        mPresenter = HomePresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mViewModel = mTourModel
    }

    @Test
    fun onTapTourItem_navigateToToursDetail(){

        val tour = ToursVO()
        tour.name = "Sea Flower Resort"
        tour.description = "Located in Ko Chang, within 17.7 km of Koh Chang National Park and 19.3 km of Wat Klong Son, Sea Flower Resort provides accommodations with a garden and free WiFi as well as free private parking for guests who drive. The property is around 20.9 km from Ao Sapparot Pier, 4.7 km from Bang Bao Pier and 4.7 km from Bang Bao Fisherman Village. The property has valet parking, a tour desk and ticket service for guests.The resort has a terrace.Klong Plu Waterfall is 9.7 km from Sea Flower Resort, while International Clinic, Ko Chang is 12.9 km away.Lonely Beach is a great choice for travelers interested in friendly locals, sunsets and food."
        tour.location = "Koh Chang Thailand"
        tour.averageRating = 3.0
        tour.scoresAndReviews = arrayListOf(
            ScoresAndReviewsVO("Booking", 8.0, 10, 140),
            ScoresAndReviewsVO( "Hotel Out", 3.5, 9, 100)
        )
        tour.photos = arrayListOf(
            "https://r-cf.bstatic.com/images/hotel/max1280x900/175/175821872.jpg",
            "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195253.jpg",
            "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195253.jpg",
            "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195280.jpg",
            "https://r-cf.bstatic.com/images/hotel/max1280x900/999/99977869.jpg"
        )

        mPresenter.onTapTourItem(tour.name)

        verify {
            mView.navigateToTourDetails(tour.name)
        }
    }

    @Test
    fun onTapCountryItem_navigateToCountryDetail(){

        val country = CountryVO()
        country.name = "Sea Flower Resort"
        country.description = "Located in Ko Chang, within 17.7 km of Koh Chang National Park and 19.3 km of Wat Klong Son, Sea Flower Resort provides accommodations with a garden and free WiFi as well as free private parking for guests who drive. The property is around 20.9 km from Ao Sapparot Pier, 4.7 km from Bang Bao Pier and 4.7 km from Bang Bao Fisherman Village. The property has valet parking, a tour desk and ticket service for guests.The resort has a terrace.Klong Plu Waterfall is 9.7 km from Sea Flower Resort, while International Clinic, Ko Chang is 12.9 km away.Lonely Beach is a great choice for travelers interested in friendly locals, sunsets and food."
        country.location = "Koh Chang Thailand"
        country.averageRating = 3.0
        country.scoresAndReviews = arrayListOf(
            ScoresAndReviewsVO("Booking", 8.0, 10, 140),
            ScoresAndReviewsVO( "Hotel Out", 3.5, 9, 100)
        )
        country.photos = arrayListOf(
            "https://r-cf.bstatic.com/images/hotel/max1280x900/175/175821872.jpg",
            "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195253.jpg",
            "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195253.jpg",
            "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195280.jpg",
            "https://r-cf.bstatic.com/images/hotel/max1280x900/999/99977869.jpg"
        )

        mPresenter.onTapCountryItem(country.name)

        verify {
            mView.navigateToCountryDetails(country.name)
        }
    }

    @Test
    fun onUIReady_callCountryListAndTourList(){
        val lifecycleOwner = mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)

        `when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)

        mPresenter.onToursUIReady(lifecycleOwner)

        verify {
            mView.displayCountriesList(getDummyCountries())
//            mView.displayToursList(getDummyTours())
        }
    }
}