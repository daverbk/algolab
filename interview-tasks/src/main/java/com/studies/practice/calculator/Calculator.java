package com.studies.practice.calculator;

public interface Calculator<T> {
    T add(T a, T b);
    T subtract(T a, T b);
    T multiply(T a, T b);
    T divide(T a, T b);
}
