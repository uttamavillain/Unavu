/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.uttamavillain.unavu.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.uttamavillain.unavu.backend.Model.FoodItem;

import java.util.ArrayList;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "unavuApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.unavu.uttamavillain.com",
                ownerName = "backend.unavu.uttamavillain.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    public static ArrayList<FoodItem> foods = new ArrayList<FoodItem>();

    static {
        FoodItem foodItem1 = new FoodItem();
        foodItem1.setName("Dosa");
        foodItem1.setDescription("Dosa is a fermented crepe made from rice batter and black lentils. It is a staple dish in South Indian states of Tamil nadu, Andhra Pradesh, Karnataka, Kerala and Telangana");
        foodItem1.setImageUrl("http://dosaboston.com/img/slides/dosa-1.jpg");
        foodItem1.setDescription("South India");

        FoodItem foodItem2 = new FoodItem();
        foodItem2.setName("Idly");
        foodItem2.setDescription("Idly is a traditional breakfast in South Indian households. Idli is a savoury cake that is popular throughout India and neighbouring countries like Sri Lanka");
        foodItem2.setImageUrl("http://thumbs.dreamstime.com/z/idly-served-sambar-iddli-traditional-breakfast-south-indian-households-its-very-popular-savory-dish-south-indian-41419441.jpg");
        foodItem2.setDescription("South India");

        FoodItem foodItem3 = new FoodItem();
        foodItem3.setName("Piza");
        foodItem3.setDescription("Pizza is a flatbread generally topped with tomato sauce and cheese and baked in an oven. It is commonly topped with a selection of meats, vegetables and condiments.");

        foodItem3.setImageUrl("http://www.priceguidelady.co.uk/wp-content/uploads/2015/11/Pizza-PriceGuideLady.co_.uk_.jpg");
        foodItem3.setCusine("Italian");

        FoodItem foodItem4 = new FoodItem();
        foodItem4.setName("Pasta");
        foodItem4.setDescription("Pasta is a staple food of traditional Italian cuisine, with the first reference dating to 1154 in Sicily. It is also commonly used to refer to the variety of pasta dishes.");
        foodItem4.setImageUrl("https://lifeconfusions.files.wordpress.com/2013/11/three-tomato-pasta1.jpg");
        foodItem4.setCusine("Italian");

        foods.add(foodItem1);
        foods.add(foodItem2);
        foods.add(foodItem3);
        foods.add(foodItem4);
    }

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "getFoods")
    public ArrayList<FoodItem> getFoods() {
        return foods;
    }

}
