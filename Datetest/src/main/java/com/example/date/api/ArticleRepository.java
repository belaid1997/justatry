package com.example.date.api;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository 
extends JpaRepository<Article, Integer> {

  List<Article> findAllByPublicationDate(Date publicationDate);

  List<Article> findAllByPublicationTimeBetween(
    Date publicationTimeStart,
    Date publicationTimeEnd);

  @Query("select a from Article a where a.creationDateTime <= :creationDateTime")
  List<Article> findAllWithCreationDateTimeBefore(
    @Param("creationDateTime") Date creationDateTime);

Optional<Article> findById(Long id);

}