package com.preproject.authentication.service;

import com.preproject.authentication.model.User;

import java.util.Map;

public interface UserSecurityTokenGenerator {

    Map<String,String> tokenGenerator(User user);
}
