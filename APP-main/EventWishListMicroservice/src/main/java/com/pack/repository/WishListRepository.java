package com.pack.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.model.WishList;


@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer>
{
    
	Optional<WishList> findByEventIdAndUserId(long eventId,int userId);
	Optional<List<WishList>> findByUserId(long userId);
}