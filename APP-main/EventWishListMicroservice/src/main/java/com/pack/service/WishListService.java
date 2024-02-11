package com.pack.service;

import com.pack.exception.WishListEventAlreadyExistsException;
import com.pack.exception.WishListEventNotFoundException;
import com.pack.model.WishList;

import java.util.List;

public interface WishListService {

	public WishList getWishListEvent(long eventId,int userId) throws WishListEventNotFoundException;

	public WishList addWishListEvent(WishList wishList) throws WishListEventAlreadyExistsException;

	public WishList deleteWishListEvent(long eventId,int userId) throws WishListEventNotFoundException;

	List<WishList> getListOfEvents(int userId) throws WishListEventNotFoundException;
}
