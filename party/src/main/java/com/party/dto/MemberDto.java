package com.party.dto;

import com.party.constant.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class MemberDto {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private String category;
    private Role role;


    public MemberDto(Long id, String name, String email, String address, String phone, String category, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.category = category;
        this.role = role;
    }
}