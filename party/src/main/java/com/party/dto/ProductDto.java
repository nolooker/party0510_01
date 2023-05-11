package com.party.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter @ToString
public class ProductDto {
    private Long id;
    private String name;
    private String fit;
    private String description;
    private String notStad;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
}
