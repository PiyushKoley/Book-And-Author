package com.example.Mock.Books.and.Authors.Dto;

import com.example.Mock.Books.and.Authors.Entity.AuthorEntity;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BookResponseDto {

    private int id;
    private String name;

}
