package com.baza.service.impl;

import com.baza.entity.Connection;
import com.baza.entity.Status;
import com.baza.entity.User;
import com.baza.repository.ConnectionRepository;
import com.baza.service.ConnectionService;
import com.baza.service.TariffService;
import com.baza.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConnectionServiceImpl implements ConnectionService {

    private final UserService userService;
    private final TariffService tariffService;
    private final ConnectionRepository repository;

    @Override
    public void create(Long tariffId, String address, User principal) {
        Connection connection = new Connection();
        connection.setTariff(tariffService.getReferenceById(tariffId));
        connection.setAddress(address);
        connection.setStatus(Status.PENDING);
        repository.save(connection);
        User user = userService.findById(principal.getId()).orElseThrow();
        Connection oldConnection = user.getConnection();
        user.setConnection(connection);
        userService.save(user);
        Optional.ofNullable(oldConnection).ifPresent(repository::delete);
        userService.save(user);
    }

    @Override
    public void changeStatus(Long id, String status) {
        repository.findById(id).ifPresent(connection -> {
            connection.setStatus(Status.valueOf(status));
            repository.save(connection);
        });
    }

}
