package com.luv2code.springdemo;

import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

  // create an array of Strings
  private String[] data = {"Beaware", "Dilitagence", "The journey"};

  private Random random = new Random();

  @Override
  public String getFortune() {
    // pick a random fortune from the array
    int index = random.nextInt(data.length);

    return data[index];
  }
}
