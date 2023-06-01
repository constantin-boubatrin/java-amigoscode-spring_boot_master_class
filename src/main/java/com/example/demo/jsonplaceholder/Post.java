package com.example.demo.jsonplaceholder;

/**  private final, getter, public constructor, equals, hashCode, toString */
public record Post(Integer userId,
                   Integer id,
                   String title,
                   String body) {
}
