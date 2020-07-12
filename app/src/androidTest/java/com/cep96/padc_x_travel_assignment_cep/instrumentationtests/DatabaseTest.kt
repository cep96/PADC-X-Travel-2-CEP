package com.cep96.padc_x_travel_assignment_cep.instrumentationtests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.cep96.padc_x_travel_assignment_cep.persistence.daos.CountryDao
import com.cep96.padc_x_travel_assignment_cep.persistence.daos.TourDao
import com.cep96.padc_x_travel_assignment_cep.persistence.db.TravelDB
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ScoresAndReviewsVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ToursVO
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTest {

    /*
    private lateinit var toursDao: TourDao
    private lateinit var countryDao: CountryDao
    private lateinit var db: TravelDB

    @Before
    fun createDB(){
        val context = ApplicationProvider.getApplicationContext<Context>()

        db = Room.inMemoryDatabaseBuilder(
            context, TravelDB::class.java
        ).build()

        toursDao = db.tourDao()
        countryDao = db.countryDao()
    }

    @After
    fun closeDb(){
        db.close()
    }

    @Test
    fun insertIntoDatabaseTest(){

        insertTours()
        insertCountries()
    }

    private fun insertCountries() {
        val countryOne = CountryVO()

        countryOne.name = "Sea Flower Resort"
        countryOne.description = "Located in Ko Chang, within 17.7 km of Koh Chang National Park and 19.3 km of Wat Klong Son, Sea Flower Resort provides accommodations with a garden and free WiFi as well as free private parking for guests who drive. The property is around 20.9 km from Ao Sapparot Pier, 4.7 km from Bang Bao Pier and 4.7 km from Bang Bao Fisherman Village. The property has valet parking, a tour desk and ticket service for guests.The resort has a terrace.Klong Plu Waterfall is 9.7 km from Sea Flower Resort, while International Clinic, Ko Chang is 12.9 km away.Lonely Beach is a great choice for travelers interested in friendly locals, sunsets and food."
        countryOne.location = "Koh Chang Thailand"
        countryOne.averageRating = 3.0
        countryOne.scoresAndReviews = arrayListOf(
            ScoresAndReviewsVO("Booking", 8.0, 10, 140),
            ScoresAndReviewsVO( "Hotel Out", 3.5, 9, 100)
        )
        countryOne.photos = arrayListOf(
            "https://r-cf.bstatic.com/images/hotel/max1280x900/175/175821872.jpg",
            "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195253.jpg",
            "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195253.jpg",
            "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195280.jpg",
            "https://r-cf.bstatic.com/images/hotel/max1280x900/999/99977869.jpg"
        )

        countryDao.insertAllCountries(arrayListOf(countryOne, countryOne))
        assert(countryDao.getCountryByName(countryOne.name).value?.name == countryOne.name)
    }

    private fun insertTours() {
        val tourOne = ToursVO()

        tourOne.name = "Sea Flower Resort"
        tourOne.description = "Located in Ko Chang, within 17.7 km of Koh Chang National Park and 19.3 km of Wat Klong Son, Sea Flower Resort provides accommodations with a garden and free WiFi as well as free private parking for guests who drive. The property is around 20.9 km from Ao Sapparot Pier, 4.7 km from Bang Bao Pier and 4.7 km from Bang Bao Fisherman Village. The property has valet parking, a tour desk and ticket service for guests.The resort has a terrace.Klong Plu Waterfall is 9.7 km from Sea Flower Resort, while International Clinic, Ko Chang is 12.9 km away.Lonely Beach is a great choice for travelers interested in friendly locals, sunsets and food."
        tourOne.location = "Koh Chang Thailand"
        tourOne.averageRating = 3.0
        tourOne.scoresAndReviews = arrayListOf(
            ScoresAndReviewsVO("Booking", 8.0, 10, 140),
            ScoresAndReviewsVO( "Hotel Out", 3.5, 9, 100)
        )
        tourOne.photos = arrayListOf(
            "https://r-cf.bstatic.com/images/hotel/max1280x900/175/175821872.jpg",
            "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195253.jpg",
            "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195253.jpg",
            "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195280.jpg",
            "https://r-cf.bstatic.com/images/hotel/max1280x900/999/99977869.jpg"
        )

        toursDao.insertAllTours(arrayListOf(tourOne, tourOne))
        assert(toursDao.getTourByName(tourOne.name).value?.name == tourOne.name)


    }
*/
}