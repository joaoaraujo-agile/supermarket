package com.agile.supermarket.config;

import java.time.LocalDateTime;
import java.util.Arrays;

import com.agile.supermarket.entities.*;
import com.agile.supermarket.entities.enums.PaymentMethod;
import com.agile.supermarket.repositories.*;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.agile.supermarket.entities.enums.Role;

import javax.transaction.Transactional;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InventoryHandlingRepository inventoryHandlingRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private ProductInventoryHandlingRepository productInventoryHandlingRepository;

    @Override
    public void run(String... args) throws Exception {
//		TODO encode password
        User usr1 = new User("admin user", "admin", "admin123");
        usr1.getRoles().add(Role.ADMIN);
        User usr2 = new User("cashier user", "cashier", "cashier123");
        usr2.getRoles().add(Role.CASHIER);

        userRepository.saveAll(Arrays.asList(usr1, usr2));

        Product p1 = new Product(null, "Pen", "987654321", 1.00);
        Product p2 = new Product(null, "Notebook", "456789123", 4.00);

        productRepository.saveAll(Arrays.asList(p1, p2));

        InventoryHandling invH1 = new InventoryHandling(null, LocalDateTime.now());

        inventoryHandlingRepository.save(invH1);

        ProductInventoryHandling pih1 = new ProductInventoryHandling(p1, invH1, 10.0);
        ProductInventoryHandling pih2 = new ProductInventoryHandling(p2, invH1, 5.0);

        productInventoryHandlingRepository.saveAll(Arrays.asList(pih1, pih2));

        Order ord1 = new Order(null, LocalDateTime.now(), null);

        orderRepository.save(ord1);

        OrderProduct op1 = new OrderProduct(ord1, p1, 4.0, p1.getSalePrice());
        OrderProduct op2 = new OrderProduct(ord1, p2, 1.0, p2.getSalePrice());

        orderProductRepository.saveAll(Arrays.asList(op1, op2));

        ord1.setPayment(new Payment(null, PaymentMethod.CASH, ord1));

        orderRepository.save(ord1);
    }

}
