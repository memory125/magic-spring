package com.wing.proxy01;

/**
 * @author memory125
 */
// 租户
public class Tenant {
    public static void main(String[] args) {
        LandLord landLord = new LandLord();

        AgentProxy agentProxy = new AgentProxy(landLord);

        agentProxy.rentHouse();
    }
}
