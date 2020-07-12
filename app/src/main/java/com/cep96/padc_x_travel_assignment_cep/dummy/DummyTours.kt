package com.cep96.padc_x_travel_assignment_cep.dummy

import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ScoresAndReviewsVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ToursVO

fun getDummyTours(): List<ToursVO>{

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
    val tourTwo = ToursVO()

    tourTwo.name = "Sea Flower Resort"
    tourTwo.description = "Located in Ko Chang, within 17.7 km of Koh Chang National Park and 19.3 km of Wat Klong Son, Sea Flower Resort provides accommodations with a garden and free WiFi as well as free private parking for guests who drive. The property is around 20.9 km from Ao Sapparot Pier, 4.7 km from Bang Bao Pier and 4.7 km from Bang Bao Fisherman Village. The property has valet parking, a tour desk and ticket service for guests.The resort has a terrace.Klong Plu Waterfall is 9.7 km from Sea Flower Resort, while International Clinic, Ko Chang is 12.9 km away.Lonely Beach is a great choice for travelers interested in friendly locals, sunsets and food."
    tourTwo.location = "Koh Chang Thailand"
    tourTwo.averageRating = 3.0
    tourTwo.scoresAndReviews = arrayListOf(
        ScoresAndReviewsVO("Booking", 8.0, 10, 140),
        ScoresAndReviewsVO( "Hotel Out", 3.5, 9, 100)
    )
    tourTwo.photos = arrayListOf(
        "https://r-cf.bstatic.com/images/hotel/max1280x900/175/175821872.jpg",
        "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195253.jpg",
        "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195253.jpg",
        "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195280.jpg",
        "https://r-cf.bstatic.com/images/hotel/max1280x900/999/99977869.jpg"
    )

    val tourThree = ToursVO()

    tourThree.name = "Sea Flower Resort"
    tourThree.description = "Located in Ko Chang, within 17.7 km of Koh Chang National Park and 19.3 km of Wat Klong Son, Sea Flower Resort provides accommodations with a garden and free WiFi as well as free private parking for guests who drive. The property is around 20.9 km from Ao Sapparot Pier, 4.7 km from Bang Bao Pier and 4.7 km from Bang Bao Fisherman Village. The property has valet parking, a tour desk and ticket service for guests.The resort has a terrace.Klong Plu Waterfall is 9.7 km from Sea Flower Resort, while International Clinic, Ko Chang is 12.9 km away.Lonely Beach is a great choice for travelers interested in friendly locals, sunsets and food."
    tourThree.location = "Koh Chang Thailand"
    tourThree.averageRating = 3.0
    tourThree.scoresAndReviews = arrayListOf(
        ScoresAndReviewsVO("Booking", 8.0, 10, 140),
        ScoresAndReviewsVO( "Hotel Out", 3.5, 9, 100)
    )
    tourThree.photos = arrayListOf(
        "https://r-cf.bstatic.com/images/hotel/max1280x900/175/175821872.jpg",
        "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195253.jpg",
        "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195253.jpg",
        "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195280.jpg",
        "https://r-cf.bstatic.com/images/hotel/max1280x900/999/99977869.jpg"
    )


    return arrayListOf(tourOne, tourTwo, tourThree)

}