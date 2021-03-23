package com.wing.proxy03;

import com.wing.proxy03.Rent;

/**
 * @author memory125
 */
// 房主
public class LandLord implements Rent {
    public void rentHouse() {
        System.out.println("Landlord has house for renting!!!!!!");
    }
}
