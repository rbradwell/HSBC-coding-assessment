package com.hsbc.devassessment.repo;

import com.hsbc.devassessment.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
    List<UserEntity> findByFirstname(String firstname);
    List<UserEntity> findBySurname(String lastname);
    Optional<UserEntity> findById(Long id);
}
