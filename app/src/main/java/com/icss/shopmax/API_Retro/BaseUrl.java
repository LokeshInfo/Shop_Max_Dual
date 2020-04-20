package com.icss.shopmax.API_Retro;

public interface BaseUrl {

    //    String BaseUrl = "https://www.lotusenterprises.net/shopmax/api/";
    String BaseUrl = "https://www.lotusenterprises.net/shopmax_store/api/";
    String BaseImg = "https://www.lotusenterprises.net/shopmax_store/";


    //BookingIT
    String itBooking=BaseUrl+"add_booking/it_services";

    //BookingTechnicalSupport
    String technicalBooking=BaseUrl+"add_booking/technical_support";

    //Restaurant

    String getRestaurant = BaseUrl + "get_restaurants";
    String getRestaurantImg = BaseImg + "uploads/restaurant_image/";

    //Writers
    String getWriter = BaseUrl + "get_sub_services/professional_cv_writers";
    String getWriterImg = BaseImg + "uploads/sub_service_image/";

    //Classified
    String getClassified = BaseUrl + "get_sub_services/classified";
    String getClassifiedImg = BaseImg + "uploads/sub_service_image/";

    //foodDishes
    String getFoodDishes = BaseUrl + "get_food_dishes";
    String getFoodDishesImg = BaseImg + "uploads/food_dish_image/";

    //chef
    String getChef = BaseUrl + "get_sub_services/chef_at_home";
    String chefBanner = BaseImg + "uploads/sub_service_image/";

    //Technical
    String getTechnical = BaseUrl + "get_sub_services/technical_support";
    String technicalBanner = BaseImg + "uploads/sub_service_image/";

    //ITSupport
    String getIT = BaseUrl + "get_sub_services/it_services";
    String getITBanner = BaseImg + "uploads/sub_service_image/";
    // Service
    String get_Services = "get_services";
    String image_Services = "https://www.lotusenterprises.net/shopmax_store/uploads/service_image/";

    // Hospitals
    String get_hospitals = "get_hospitals";
    String image_hospitals = BaseImg + "uploads/hospital_image/";

    // Doctors
    String get_doctors = "get_doctors/hospital";
    String book_doctor_appointment = "add_booking/patient_appointment";
    String image_doctor = BaseImg + "uploads/doctor_image/";

    // Grocery Items
    String get_grocery_cat = "get_grocery_cat";
    String get_grocery_item = "get_grocery_item";
    String image_grocery = BaseImg + "uploads/grocery_cat_image/";
    String image_grocery_products = BaseImg + "uploads/grocery_item_image/";

    // All Common Api's

    String get_services = "get_services";
    String image_services = BaseImg + "uploads/service_image/";
    String login = "login/do_login";
    String registration = "registration/add_info";
    String update_profile = "update_profile";
    String sale_category = "sale_category";
    String food_category = "food_category";
    String doctor_category = "doctor_category";
    String grocery_cat = "grocery_cat";
    String cake_homely_cat_cat = "cake_homely_cat_cat";
    String car_cat = "car_cat";
    String sale_subcategory = "sale_subcategory";
    String food_subcategory = "food_subcategory";
    String doctor_subcategory = "doctor_subcategory";
    String grocery_subcategory = "grocery_subcategory";

}
