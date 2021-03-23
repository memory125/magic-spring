package com.wing.proxy01;

/**
 * @author memory125
 */
// 房产中介
public class AgentProxy implements Rent{
    private LandLord landLord;

    public AgentProxy() {
    }

    public AgentProxy(LandLord landLord) {
        this.landLord = landLord;
    }

    public void rentHouse() {
        checkHouse();
        landLord.rentHouse();
        signContract();
        chargeRent();
    }

    public void checkHouse() {
        System.out.println("Agent takes tenant to watch the house! ");
    }

    public void signContract() {
        System.out.println("Agent signed the contract with tenant! ");
    }

    public void chargeRent() {
        System.out.println("Agent collects the rent from tenant! ");
    }
}
