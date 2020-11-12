package bksoftware.controller;

import bksoftware.model.Customer;
import bksoftware.server.SystemService;
import bksoftware.server.impl.SystemServiceImpl;

public class SystemController {
    private  final SystemService systemService;

    public SystemController() {
        this.systemService = new SystemServiceImpl();
    }

    public SystemController(SystemService systemService) {
        this.systemService = systemService;
    }

    public Customer enterCustomer() {
        System.out.println("=========================");
        System.out.println("Nhập thông tin khách hàng");

        return systemService.enterCustomer();
    }
}
