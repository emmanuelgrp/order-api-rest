package com.codemainlabs.order;

import com.codemainlabs.order.model.Order;
import com.codemainlabs.order.repository.OrderRepository;
import com.codemainlabs.order.util.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(OrderRepository orderRepository) {
        return args -> {
            orderRepository.save(
                    Order.builder()
                            .description("Samsung Galaxy S21")
                            .status(Status.COMPLETED)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Dell XPS 15")
                            .status(Status.IN_PROGRESS)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("PlayStation 5 Bundle")
                            .status(Status.CANCELLED)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Apple Watch Series 7")
                            .status(Status.COMPLETED)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Microsoft Surface Laptop 4")
                            .status(Status.IN_PROGRESS)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Sony WH-1000XM4 Wireless Headphones")
                            .status(Status.COMPLETED)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("LG OLED C1 Series TV")
                            .status(Status.IN_PROGRESS)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Nintendo Switch OLED Model")
                            .status(Status.CANCELLED)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Canon EOS R5 Mirrorless Camera")
                            .status(Status.COMPLETED)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Bose QuietComfort 45 Wireless Headphones")
                            .status(Status.IN_PROGRESS)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Amazon Echo Show 10")
                            .status(Status.COMPLETED)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("iPad Air (4th generation)")
                            .status(Status.IN_PROGRESS)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Samsung Odyssey G7 Gaming Monitor")
                            .status(Status.CANCELLED)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("GoPro Hero 9 Black")
                            .status(Status.COMPLETED)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Garmin Forerunner 945 GPS Smartwatch")
                            .status(Status.IN_PROGRESS)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("LG Gram 17 Ultra-Lightweight Laptop")
                            .status(Status.CANCELLED)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Sony A7 III Mirrorless Camera")
                            .status(Status.COMPLETED)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Bose SoundLink Color Bluetooth Speaker II")
                            .status(Status.IN_PROGRESS)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Fitbit Charge 4 Fitness and Activity Tracker")
                            .status(Status.COMPLETED)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Microsoft Xbox Series X")
                            .status(Status.IN_PROGRESS)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Apple MacBook Pro 13-inch")
                            .status(Status.COMPLETED)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Samsung QN90A Neo QLED 4K Smart TV")
                            .status(Status.IN_PROGRESS)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Sony WH-CH710N Wireless Noise-Canceling Headphones")
                            .status(Status.CANCELLED)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Canon EOS R6 Mirrorless Camera")
                            .status(Status.COMPLETED)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Bose Noise Cancelling Headphones 700")
                            .status(Status.IN_PROGRESS)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Amazon Kindle Paperwhite")
                            .status(Status.COMPLETED)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Nintendo Switch Pro Controller")
                            .status(Status.IN_PROGRESS)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Fitbit Versa 3 Health & Fitness Smartwatch")
                            .status(Status.CANCELLED)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("DJI Mavic Air 2 Fly More Combo")
                            .status(Status.COMPLETED)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("JBL Flip 5 Waterproof Portable Bluetooth Speaker")
                            .status(Status.IN_PROGRESS)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Apple iPad Mini (6th generation)")
                            .status(Status.CANCELLED)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Samsung Galaxy Tab S7+")
                            .status(Status.COMPLETED)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Logitech MX Master 3 Advanced Wireless Mouse")
                            .status(Status.IN_PROGRESS)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Apple AirPods Pro")
                            .status(Status.CANCELLED)
                            .build()
            );

            orderRepository.save(
                    Order.builder()
                            .description("Sony PlayStation 5 DualSense Wireless Controller")
                            .status(Status.COMPLETED)
                            .build()
            );

            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });
        };
    }

}