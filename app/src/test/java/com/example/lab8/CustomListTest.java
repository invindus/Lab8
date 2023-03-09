package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


//import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;




public class CustomListTest {

    private CustomList list;

    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null, new ArrayList<>());
        return list;
    }
    @Test
    public void countCityTest(){
        list = MockCityList();

        list.addCity(new City("Asdf", "ghj"));
        int listSize = list.getCities().size();
        assertEquals(list.getCount(), listSize);
    }

    @Test
    public void addCityTest(){
        countCityTest();
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize +1);
    }

    @Test
    public void hasCityTest(){
        countCityTest();
        addCityTest();
        City city = new City("Edmonton", "AB");
        Assertions.assertFalse(list.hasCity(city));
        list.addCity(city);
        Assertions.assertTrue(list.hasCity(city));
    }

    @Test
    public void deleteCityTest(){
        countCityTest();
        addCityTest();
        hasCityTest();
        City city = new City("Edmonton", "AB");
        list.addCity(city);
        assertEquals(3, list.getCount());
        Assertions.assertTrue(list.hasCity(city));

        list.deleteCity(city);
        assertEquals(2, list.getCount());
        Assertions.assertFalse(list.hasCity(city));
    }
//
//    @Test
//    void testDeleteException(){
//        list = MockCityList();
//        City city = new City("Yellowknife", "NW Territory");
//        //cityList.delete(city);
//        //doesn't have yet exception
//        assertThrows( IllegalArgumentException.class, () ->{
//            list.deleteCity(city); });
//    }


}
