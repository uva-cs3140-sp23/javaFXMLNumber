package edu.virginia.cs.javaFXNumberApp;

import java.util.*;

public class NumberModel {
    protected int currentIndex;
    protected List<Integer> numbers;

    public NumberModel() {
        numbers = new ArrayList<>();
    }

    public void addNumber(int x) {
        numbers.add(x);
        currentIndex = numbers.size()-1;
    }

    public int getCurrentNumber() {
        return numbers.get(currentIndex);
    }

    public boolean currentNumberIsOdd() {
        return numbers.get(currentIndex) % 2 == 1;
    }

    public boolean currentNumberIsEven() {
        return numbers.get(currentIndex) % 2 == 0;
    }

    public boolean currentNumberIsSquare() {
        double r = Math.sqrt(numbers.get(currentIndex));
        return Math.floor(r) == r;
    }

    public boolean currentNumberIsPrime() {
        int value = numbers.get(currentIndex);
        if (value < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void previous() {
        if (numbers.isEmpty()) {
            throw new RuntimeException("Error: can't use back on empty list");
        }
        if (currentIndex == 0) {
            throw new RuntimeException("Error: Can't go back before index 0");
        }
        currentIndex--;
    }

    public void next() {
        if (numbers.isEmpty()) {
            throw new RuntimeException("Error: can't use forward on empty list");
        }
        if (currentIndex == numbers.size() - 1) {
            throw new RuntimeException("Error: Can't go forward after last element");
        }
        currentIndex++;
    }
}
