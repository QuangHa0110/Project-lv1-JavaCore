package bksoftware.server;

import bksoftware.model.Customer;

public interface SystemService {
    String genID();
    Customer enterCustomer();
    Customer writeCustomer();
}
