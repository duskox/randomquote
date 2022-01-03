package com.playground.randomquote.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomnessService {

    private final Random random;

    public RandomnessService() {
        random = new Random();
    }

    public int getRandom(int range) {
        return random.nextInt(range);
    }
}