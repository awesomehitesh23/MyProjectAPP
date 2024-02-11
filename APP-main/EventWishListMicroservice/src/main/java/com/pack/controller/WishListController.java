package com.pack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pack.exception.WishListEventAlreadyExistsException;
import com.pack.exception.WishListEventNotFoundException;
import com.pack.model.WishList;
import com.pack.response.ResponseHandler;
import com.pack.service.WishListService;
import com.pack.service.WishListServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/wishlist")
@CrossOrigin("*")
public class WishListController {

	Logger logger=LoggerFactory.getLogger(WishListController.class);

	private final WishListService wishListService;

	@Autowired
	public WishListController(WishListService wishListService) {
		this.wishListService = wishListService; 
	}


	/*
	 * @GetMapping("/viewFavourite/{eventId}/{userId}") public
	 * ResponseEntity<Object> viewFavouriteEvent(@RequestHeader(name =
	 * "Authorization", required = true) String token,@PathVariable long
	 * eventId,@PathVariable int userId) throws WishListEventNotFoundException {
	 * logger.info("requesting list of events {} {}",userId,eventId); WishList
	 * wishList =wishListService.getWishListEvent(eventId,userId);
	 * logger.info("Event data retrieved successfully!"); return
	 * ResponseHandler.generateResponse("Event data retrieved successfully!",
	 * HttpStatus.OK, wishList);
	 * 
	 * }
	 */

	@PostMapping("/addFavourite")
	public ResponseEntity<Object> addFavouriteEvent(@RequestHeader(name = "Authorization", required = true) String token,@RequestBody WishList wishList) throws WishListEventAlreadyExistsException {
		
		//logger.info("Event added to wishlist successfully!");
		return ResponseHandler.generateResponse("Event added to wishlist successfully!", HttpStatus.CREATED,
				wishListService.addWishListEvent(wishList));

	}
	
	

	@DeleteMapping("/deleteFavourite/{eventId}/{userId}")
	public ResponseEntity<Object> deleteFavouriteEvent(@RequestHeader(name = "Authorization", required = true) String token,@PathVariable long eventId,@PathVariable int userId) throws WishListEventNotFoundException {

		//logger.info("Event deleted from wishlist successfully!");
		return ResponseHandler.generateResponse("Event deleted from wishlist successfully!", HttpStatus.CREATED,
				wishListService.deleteWishListEvent(eventId,userId));
	}

	@GetMapping("/viewFavourite/{userId}")
	public ResponseEntity<List<WishList>> viewListOfEvents(@RequestHeader(name = "Authorization", required = true) String token,@PathVariable int userId) throws WishListEventNotFoundException {
		logger.info("requesting list of events {}",userId);
		List<WishList> wishList =wishListService.getListOfEvents(userId);
		logger.info("Event data retrieved successfully!");
		return ResponseEntity.ok(wishList);

	}

}