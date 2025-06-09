package com.example;

import java.util.List;

public interface FelineInterface {
    int getKittens();
    int getKittens(int kittensCount);
    List<String> getFood(String animalKind) throws Exception;
}
