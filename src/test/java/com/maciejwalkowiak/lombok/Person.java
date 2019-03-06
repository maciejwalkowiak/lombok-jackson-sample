package com.maciejwalkowiak.lombok;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Person {
    String firstName;
    String lastName;
    Integer age;
}
