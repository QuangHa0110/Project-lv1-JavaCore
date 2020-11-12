package bksoftware.view;

import bksoftware.controller.CustomerController;
import bksoftware.controller.SystemController;
import bksoftware.model.Customer;
import bksoftware.server.impl.SystemServiceImpl;


import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    private static final boolean enable = true;
    private final SystemController systemController;
    private final CustomerController customerController;

    public Main() {
        this.systemController = new SystemController();
        this.customerController = new CustomerController();


    }

    public static void main(String[] args) {
        run(enable);
    }

    private static void run(boolean enable) {
        if (enable) {
            customerManager();
        } else {
            System.out.println("hệ thống đang tắt");
        }
    }

    private static void customerManager() {
        System.out.println("hệ thống quản lý khách hàng");
        int option = showMenu();
        switch (option) {
            case 1: {
                List<Customer> customers = new Main().customerController.findAll();
                for (int i = 0; i < customers.size(); i++) {
                    System.out.println("khách hàng thứ " + i);
                    new Main().customerController.show(customers.get(i));
                }
                customerManager();
                break;
            }
            case 2: {
                System.out.println("Nhập id: ");
                String id = new Scanner(System.in).nextLine();
                Customer customer = new Main().customerController.findByID(id);
                System.out.println("Thông tin chí tiết của khách hàng: ");
                new Main().customerController.show(customer);
                customerManager();
                break;
            }
            case 3: {
                System.out.println("Thêm mới khách hàng");
                Customer customer = new Main().systemController.enterCustomer();
                new Main().customerController.insert(customer);
                customerManager();
                break;

            }
            case 4: {
                System.out.println("Nhập id: ");
                String id = new Scanner(System.in).nextLine();
                System.out.println("===LOG===");
                Customer cus = new Main().customerController.findByID(id);
                Customer customer = new Main().systemController.enterCustomer();
                System.out.println("===LOG===");
                new Main().customerController.update(id, customer);
                System.out.println("===LOG===");
                customerManager();
                break;
            }
            case 5: {
                System.out.println("Nhập vào id: ");
                String id = new Scanner(System.in).nextLine();
                System.out.println("===LOG===");
                new Main().customerController.delete(id);
                System.out.println("===LOG===");
                customerManager();
                break;
            }
            case 6: {
                System.out.println("Nhập vào id");
                String id = new Scanner(System.in).nextLine();
                System.out.println("===LOG===");
                new Main().customerController.show(new Main().customerController.findByID(id));
                System.out.println("===LOG===");
                customerManager();
                break;
            }
            case 7: {
                exit(0);
                break;
            }
        }
    }

    private static int showMenu() {
        int rs = -1;
        System.out.println("1. Hiển thị danh sách khách hàng");
        System.out.println("2. Hiển thị thông tin chi tiết khách hàng");
        System.out.println("3. Thêm mới");
        System.out.println("4. Cập nhật");
        System.out.println("5. Xóa");
        System.out.println("6. Tìm kiếm");
        System.out.println("7. Thoát");
        System.out.println("Mời bạn chọn chức năng tương ứng với các số từ 1-6: ");
        rs = new Scanner(System.in).nextInt();
        return rs;
    }


}
