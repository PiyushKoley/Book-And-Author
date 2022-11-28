package com.example.Mock.Books.and.Authors.Repository;

import com.example.Mock.Books.and.Authors.Entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
}
