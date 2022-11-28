package com.example.Mock.Books.and.Authors.Convertor;

import com.example.Mock.Books.and.Authors.Dto.AuthorEntryDto;

import com.example.Mock.Books.and.Authors.Dto.AuthorResponseDtoWithId;
import com.example.Mock.Books.and.Authors.Entity.AuthorEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AuthorConvertor {

    public static AuthorEntity convertDtoToEntity(AuthorEntryDto authorEntryDto) {
        return AuthorEntity.builder()
                .name(authorEntryDto.getName())
                .build();
    }

    public static AuthorResponseDtoWithId convertEntityToDto(AuthorEntity authorEntity) {
        return AuthorResponseDtoWithId.builder()
                .id(authorEntity.getId())
                .name(authorEntity.getName())
                .build();
    }
}
