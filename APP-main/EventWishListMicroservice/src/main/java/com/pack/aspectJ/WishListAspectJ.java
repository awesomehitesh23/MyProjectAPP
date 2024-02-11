package com.pack.aspectJ;

import java.util.HashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.pack.model.WishList;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class WishListAspectJ {

	@AfterReturning(value = "execution(*  com.pack.controller.WishListController.addFavouriteEvent(..))", returning = "obj")
	public void afterAddFavouriteEventReturningData(JoinPoint joinPoint, ResponseEntity<Object> obj) {
		
		ResponseEntity<Object> responseEntity = (ResponseEntity<Object>) obj;
		HashMap<String, Object> map = (HashMap<String, Object>) responseEntity.getBody();
		WishList wishList = (WishList) map.get("responseObj");
		//log.info("Event added to wishlist of user with UserId: "+wishList.getUserId()+" successfully!");
	}

	@AfterThrowing(value="execution(*  com.pack.controller.WishListController.addFavouriteEvent(..))",throwing="e")
	public void afterAddFavouriteEventThrowingException(JoinPoint joinPoint,Exception e)
	{
		//log.error("Exception raised while adding the favourite event: "+e.getMessage());
	}
	
	@AfterReturning(value = "execution(*  com.pack.controller.WishListController.deleteFavouriteEvent(..))", returning = "obj")
	public void afterDeleteFavouriteEventReturningData(JoinPoint joinPoint, ResponseEntity<Object> obj) {
		
		ResponseEntity<Object> responseEntity = (ResponseEntity<Object>) obj;
		HashMap<String, Object> map = (HashMap<String, Object>) responseEntity.getBody();
		WishList wishList = (WishList) map.get("responseObj");
		//log.info("Event deleted from the  wishlist of user with UserId: "+wishList.getUserId()+" successfully!");
	}

	@AfterThrowing(value="execution(*  com.pack.controller.WishListController.deleteFavouriteEvent(..))",throwing="e")
	public void afterDeleteFavouriteEventThrowingException(JoinPoint joinPoint,Exception e)
	{
		//log.error("Exception raised while deleting the favourite event: "+e.getMessage());
	}
	
	@AfterReturning(value = "execution(*  com.pack.controller.WishListController.viewFavouriteEvent(..))", returning = "obj")
	public void afterViewFavouriteEventReturningData(JoinPoint joinPoint, ResponseEntity<Object> obj) {
		
		ResponseEntity<Object> responseEntity = (ResponseEntity<Object>) obj;
		HashMap<String, Object> map = (HashMap<String, Object>) responseEntity.getBody();
		WishList wishList = (WishList) map.get("responseObj");
		//log.info("Event data retrieved for user with UserId: "+wishList.getUserId()+" successfully!");
	}

	@AfterThrowing(value="execution(*  com.pack.controller.WishListController.viewFavouriteEvent(..))",throwing="e")
	public void afterViewFavouriteEventThrowingException(JoinPoint joinPoint,Exception e)
	{
		//log.error("Exception raised while trying to view event: "+e.getMessage());
	}

}
