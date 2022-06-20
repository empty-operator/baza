package com.baza.configuration;

import com.baza.entity.User;
import com.baza.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.Optional;

@Configuration
@EnableScheduling
@AllArgsConstructor
public class ApplicationConfiguration {

    private final UserService service;

    @Scheduled(cron = "0 0 0 1 * ?")
    public void monthlyTariffPayment() {
        List<User> users = service.findAllUsers();
        users.forEach(user -> Optional.ofNullable(user.getConnection())
                                      .ifPresent(connection -> {
                                          user.setBalance(user.getBalance() - connection.getTariff().getPrice());
                                          service.save(user);
                                      }));
    }

}
