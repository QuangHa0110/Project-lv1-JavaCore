package bksoftware.server.impl;

import bksoftware.model.Customer;
import bksoftware.model.Employee;
import bksoftware.server.ValidatorService;

public class ValidatorServiceImpl implements ValidatorService {
    /**
     * check xem customer có hợp lệ hay không
     *
     * @param customer
     * @return true - customer hợp lệ
     * false - customer không hợp lệ
     */
    @Override
    public boolean customer(Customer customer) {
        return checkEmail(customer) && checkPhoneNumber(customer);
    }

    private boolean checkEmail(Customer customer) {
        boolean rs= false;
        try{
            String EMAIL_PATTERN = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
            rs=customer.getEmail().matches(EMAIL_PATTERN);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs ;
    }

    private boolean checkPhoneNumber(Customer customer) {
        boolean rs= false;
        try{
            String PHONENUMBER_PATTERN = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
            rs=customer.getPhoneNumber().matches(PHONENUMBER_PATTERN);
        }catch (Exception e){
            e.printStackTrace();
        }

        return rs;
    }
}
