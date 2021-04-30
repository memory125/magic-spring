package com.wing.provider.service.impl;

import com.wing.provider.service.TicketService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service
@Component
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "SpringBoot + Dubbo + ZooKeeper测试！";
    }
}
