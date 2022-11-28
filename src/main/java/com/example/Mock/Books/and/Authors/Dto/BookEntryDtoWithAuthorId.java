package com.example.Mock.Books.and.Authors.Dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class BookEntryDtoWithAuthorId {

    private String name;
    private int authorId;
}
