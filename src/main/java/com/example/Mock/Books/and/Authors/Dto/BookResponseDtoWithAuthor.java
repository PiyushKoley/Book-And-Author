package com.example.Mock.Books.and.Authors.Dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BookResponseDtoWithAuthor {
    private int id;
    private String name;

    private AuthorResponseDtoWithId author;
}
