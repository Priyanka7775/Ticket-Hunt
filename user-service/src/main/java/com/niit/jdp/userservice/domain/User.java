/*
 * Author Name: Mohini
 * Date: 12/27/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Getter
    @Setter
    private String name;
    @Id
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String city;
    @Getter
    @Setter
    private String role;
    @Getter
    @Setter
    private List<String> interest;
    @Getter
    @Setter
    private long phone;


}
