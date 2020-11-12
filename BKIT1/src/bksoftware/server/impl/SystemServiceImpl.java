package bksoftware.server.impl;

import bksoftware.model.Customer;
import bksoftware.server.SystemService;

import java.util.Calendar;
import java.util.Scanner;
import java.util.UUID;

public class SystemServiceImpl implements SystemService {
    @Override
    public String genID() {

        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        new SystemServiceImpl().enterCustomer();
    }

    @Override
    public Customer enterCustomer() {
        Customer customer =null;
        try{
            customer= new Customer();
            customer.setId(genID());
            customer.setName(input("tên"));

            customer.setAge(Integer.valueOf(input("tuổi")));
            customer.setPhoneNumber((input("số điện thoại")));
            String birthday= input("ngày sinh");
            // dd/MM/yyyy
            String time[] = birthday.split("/");

            Calendar calendar = Calendar.getInstance();
            calendar.set(Integer.valueOf(time[2]), Integer.valueOf(time[1]), Integer.valueOf(time[0]));

            customer.setBirthday(calendar.getTime());
            customer.setEmail(input("email"));
        }catch (Exception e){
            //enterCustomer();
            System.out.println(e.getMessage());
        }

        return customer;
    }

    /*
    *
    * */
    private String input(String mess){
        try{
            System.out.println("Nhập vào " + mess+": ");
            return  new Scanner(System.in).nextLine();
        }
        catch (Exception e){
            return  null;
        }

    }

    @Override
    public Customer writeCustomer() {
        return null;
    }
}
