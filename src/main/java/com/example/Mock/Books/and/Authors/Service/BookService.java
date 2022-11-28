package com.example.Mock.Books.and.Authors.Service;

import com.example.Mock.Books.and.Authors.Convertor.AuthorConvertor;
import com.example.Mock.Books.and.Authors.Convertor.BookConvertor;
import com.example.Mock.Books.and.Authors.Dto.AuthorResponseDtoWithId;
import com.example.Mock.Books.and.Authors.Dto.BookEntryDtoWithAuthorId;
import com.example.Mock.Books.and.Authors.Dto.BookResponseDto;
import com.example.Mock.Books.and.Authors.Dto.BookResponseDtoWithAuthor;
import com.example.Mock.Books.and.Authors.Entity.AuthorEntity;
import com.example.Mock.Books.and.Authors.Entity.BookEntity;
import com.example.Mock.Books.and.Authors.Repository.AuthorRepository;
import com.example.Mock.Books.and.Authors.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    // author is already present in DB and then book with author id is inserted...
    public BookResponseDtoWithAuthor addBookWithAuthorId(BookEntryDtoWithAuthorId bookEntryDto){
        String bookName = bookEntryDto.getName();
        int authorId = bookEntryDto.getAuthorId();

        AuthorEntity authorEntity = authorRepository.findById(authorId).orElse(null);
        if(authorEntity ==  null) {
            return null;
        }

        // creating book...
        BookEntity bookEntity = BookEntity.builder().name(bookName).author(authorEntity).build();

        bookEntity = bookRepository.save(bookEntity);

        authorEntity = addToList(bookEntity,authorEntity);  //************

        AuthorResponseDtoWithId authorResponseDtoWithId = AuthorConvertor.convertEntityToDto(authorEntity);

        BookResponseDtoWithAuthor bookWithAuthor = BookResponseDtoWithAuthor.builder()
                .id(bookEntity.getId()).name(bookEntity.getName()).author(authorResponseDtoWithId)
                .build();
        return bookWithAuthor;

    }

    private AuthorEntity addToList(BookEntity bookEntity, AuthorEntity authorEntity) {
        List<BookEntity> listOfBooks = authorEntity.getListOfBooks();
        if(listOfBooks == null) {
            listOfBooks = new ArrayList<>();
        }
        listOfBooks.add(bookEntity);

        authorEntity.setListOfBooks(listOfBooks);

        return authorEntity;
    }

    public BookResponseDto addBookByName(String bookName) {  // we have not add author here...

        BookEntity bookEntity = BookEntity.builder().name(bookName).build();

        bookEntity = bookRepository.save(bookEntity);

        return BookConvertor.convertEntityToDto(bookEntity); // returing only id and name of book;
    }
}
