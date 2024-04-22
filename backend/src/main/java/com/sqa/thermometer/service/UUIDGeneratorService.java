package com.sqa.thermometer.service;

import java.util.UUID;
public class UUIDGeneratorService {
    public String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
