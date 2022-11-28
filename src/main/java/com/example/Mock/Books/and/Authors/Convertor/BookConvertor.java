package com.example.Mock.Books.and.Authors.Convertor;

import com.example.Mock.Books.and.Authors.Dto.BookResponseDto;

import com.example.Mock.Books.and.Authors.Entity.BookEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BookConvertor {

    public static BookResponseDto convertEntityToDto(BookEntity bookEntity) {

        return BookResponseDto.builder().name(bookEntity.getName()).id(bookEntity.getId()).build();
    }


}
