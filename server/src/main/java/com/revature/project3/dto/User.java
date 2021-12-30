package com.revature.project3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long userId;
    private String userEmail;
    private String username;
}
