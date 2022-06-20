package com.baza.service;

import com.baza.entity.User;

public interface ConnectionService {
    void create(Long tariffId, String address, User user);

    void changeStatus(Long id, String status);
}
