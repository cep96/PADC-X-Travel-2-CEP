package com.cep96.padc_x_travel_assignment_cep.dummy

import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ScoresAndReviewsVO

fun getDummyCountries(): List<CountryVO>{

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

    val countryTwo = CountryVO()

    countryTwo.name = "Sea Flower Resort"
    countryTwo.description = "Located in Ko Chang, within 17.7 km of Koh Chang National Park and 19.3 km of Wat Klong Son, Sea Flower Resort provides accommodations with a garden and free WiFi as well as free private parking for guests who drive. The property is around 20.9 km from Ao Sapparot Pier, 4.7 km from Bang Bao Pier and 4.7 km from Bang Bao Fisherman Village. The property has valet parking, a tour desk and ticket service for guests.The resort has a terrace.Klong Plu Waterfall is 9.7 km from Sea Flower Resort, while International Clinic, Ko Chang is 12.9 km away.Lonely Beach is a great choice for travelers interested in friendly locals, sunsets and food."
    countryTwo.location = "Koh Chang Thailand"
    countryTwo.averageRating = 3.0
    countryTwo.scoresAndReviews = arrayListOf(
        ScoresAndReviewsVO("Booking", 8.0, 10, 140),
        ScoresAndReviewsVO( "Hotel Out", 3.5, 9, 100)
    )
    countryTwo.photos = arrayListOf(
        "https://r-cf.bstatic.com/images/hotel/max1280x900/175/175821872.jpg",
        "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195253.jpg",
        "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195253.jpg",
        "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195280.jpg",
        "https://r-cf.bstatic.com/images/hotel/max1280x900/999/99977869.jpg"
    )

    val countryThree = CountryVO()

    countryThree.name = "Sea Flower Resort"
    countryThree.description = "Located in Ko Chang, within 17.7 km of Koh Chang National Park and 19.3 km of Wat Klong Son, Sea Flower Resort provides accommodations with a garden and free WiFi as well as free private parking for guests who drive. The property is around 20.9 km from Ao Sapparot Pier, 4.7 km from Bang Bao Pier and 4.7 km from Bang Bao Fisherman Village. The property has valet parking, a tour desk and ticket service for guests.The resort has a terrace.Klong Plu Waterfall is 9.7 km from Sea Flower Resort, while International Clinic, Ko Chang is 12.9 km away.Lonely Beach is a great choice for travelers interested in friendly locals, sunsets and food."
    countryThree.location = "Koh Chang Thailand"
    countryThree.averageRating = 3.0
    countryThree.scoresAndReviews = arrayListOf(
        ScoresAndReviewsVO("Booking", 8.0, 10, 140),
        ScoresAndReviewsVO( "Hotel Out", 3.5, 9, 100)
    )
    countryThree.photos = arrayListOf(
        "https://r-cf.bstatic.com/images/hotel/max1280x900/175/175821872.jpg",
        "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195253.jpg",
        "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195253.jpg",
        "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195280.jpg",
        "https://r-cf.bstatic.com/images/hotel/max1280x900/999/99977869.jpg"
    )

    return arrayListOf(countryOne, countryTwo, countryThree)

}