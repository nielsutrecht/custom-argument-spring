package com.nibado.example.customargumentspring.component;

import lombok.Value;

import java.util.UUID;

@Value
public class UserContext {
    private UUID id;
    private String ip;
}
