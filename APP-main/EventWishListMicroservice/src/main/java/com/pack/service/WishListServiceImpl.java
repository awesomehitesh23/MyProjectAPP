package com.pack.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.exception.WishListEventAlreadyExistsException;
import com.pack.exception.WishListEventNotFoundException;
import com.pack.model.WishList;
import com.pack.repository.WishListRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WishListServiceImpl implements WishListService {
	
	Logger logger=LoggerFactory.getLogger(WishListServiceImpl.class);

	private final WishListRepository wishListRepository;

	@Autowired
	public WishListServiceImpl(WishListRepository wishListRepository) {
		this.wishListRepository = wishListRepository;

	}

	@Override
	public WishList getWishListEvent(long eventId, int userId) throws WishListEventNotFoundException {

		Optional<WishList> optional = wishListRepository.findByEventIdAndUserId(eventId, userId);
		if (optional.isPresent()) {
			//logger.info("Retrieved event from Wishlist");
			return optional.get();
		}
		//logger.error("Event not found in Wishlist");
		throw new WishListEventNotFoundException("Event not found in Wishlist");
	}

	@Override
	public WishList addWishListEvent(WishList wishList) throws WishListEventAlreadyExistsException {
		Optional<WishList> optional = wishListRepository.findByEventIdAndUserId(wishList.getEventId(),
				wishList.getUserId());
		if (optional.isPresent()) {
			//logger.error("Event already exists in wishlist");
			throw new WishListEventAlreadyExistsException("Event already exists in wishlist");
		}else {
		//logger.info("Event added to wishlist");
		return wishListRepository.save(wishList);}
	}

	@Override
	public WishList deleteWishListEvent(long eventId, int userId) throws WishListEventNotFoundException {
		Optional<WishList> optional = wishListRepository.findByEventIdAndUserId(eventId, userId);
		if (optional.isPresent()) {
			wishListRepository.delete(optional.get());
			//logger.info("Event in wishlist is deleted");
			return optional.get();
		}
		//logger.error("Event is not found in Wishlist");
		throw new WishListEventNotFoundException("Event is not found in Wishlist");
	}

	@Override
	public List<WishList> getListOfEvents(int userId) throws WishListEventNotFoundException {
		Optional<List<WishList>> byUserId = wishListRepository.findByUserId(userId);
		if (byUserId.isPresent())
			return byUserId.get();
		throw new WishListEventNotFoundException("List of event not found");
	}

}