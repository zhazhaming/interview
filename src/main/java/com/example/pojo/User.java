package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {

    private Integer userId;

    private String username;

    private String password;

    private String phone;
}
