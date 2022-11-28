package com.example.Mock.Books.and.Authors.Service;

import com.example.Mock.Books.and.Authors.Convertor.AuthorConvertor;
import com.example.Mock.Books.and.Authors.Dto.AuthorEntryDto;
import com.example.Mock.Books.and.Authors.Dto.AuthorResponseDtoWithId;
import com.example.Mock.Books.and.Authors.Entity.AuthorEntity;
import com.example.Mock.Books.and.Authors.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public AuthorResponseDtoWithId addAuthorByName(AuthorEntryDto authorEntryDto) {
        AuthorEntity authorEntity = AuthorConvertor.convertDtoToEntity(authorEntryDto);

        authorEntity = authorRepository.save(authorEntity);

        return AuthorResponseDtoWithId.builder().name(authorEntity.getName()).id(authorEntity.getId()).build();
    }

    public AuthorResponseDtoWithId addAuthor(String authorName){
        AuthorEntity authorEntity = AuthorEntity.builder().name(authorName).build();

        authorEntity = authorRepository.save(authorEntity);

        AuthorResponseDtoWithId authorResponseDtoWithId = AuthorConvertor.convertEntityToDto(authorEntity);

        return authorResponseDtoWithId;
    }
}
