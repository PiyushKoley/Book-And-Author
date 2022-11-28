package com.example.Mock.Books.and.Authors.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorResponseDtoWithId {

    private int id;
    private String name;
}
