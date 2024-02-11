package com.pack.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.pack.exception.WishListEventAlreadyExistsException;
import com.pack.exception.WishListEventNotFoundException;
import com.pack.model.WishList;
import com.pack.repository.WishListRepository;

@ExtendWith(MockitoExtension.class)
class WishListServiceTest {

	@Mock
	private WishListRepository wishListRepository;

	@InjectMocks
	private WishListServiceImpl wishListService;

	@Test
    void givenEventAndUserIdThenShouldReturnRespectiveWishListEvent() throws WishListEventNotFoundException{
		
        when(wishListRepository.findByEventIdAndUserId(1l,1)).thenReturn(Optional.of(new WishList()));
        WishList wishList = wishListService.getWishListEvent(1l,1);
        assertNotNull(wishList);
    }

	@Test
	void givenNonExistEventAndUserIdThenShouldThrowWishListEventNotFoundException() {
		
		 when(wishListRepository.findByEventIdAndUserId(1l,1)).thenReturn(Optional.empty());
	      assertThrows(WishListEventNotFoundException.class,()->wishListService.getWishListEvent(1l,1));
		verify(wishListRepository,times(1)).findByEventIdAndUserId(1l,1);
	}

	@Test
	void givenWishlistEventToSaveThenShouldReturnSavedWishlistEvent()
			throws WishListEventNotFoundException, WishListEventAlreadyExistsException {
		WishList wishList = new WishList(1, 1l, 1, "football", "2023-12-04T08:30:00", "football park", "1000",
				"Ronald");
		when(wishListRepository.findByEventIdAndUserId(1l, 1)).thenReturn(Optional.empty());
		wishListService.addWishListEvent(wishList);
		verify(wishListRepository, times(1)).findByEventIdAndUserId(1l, 1);
	}

	@Test
	void givenExistEventAndUserIdThenShouldThrowWishListEventAlreadyExistsException() {

		WishList wishList = new WishList(1, 1l, 1, "football", "2023-12-04T08:30:00", "football park", "1000",
				"Ronald");
		wishListRepository.save(wishList);
		when(wishListRepository.findByEventIdAndUserId(1l, 1)).thenReturn(Optional.of(wishList));
		assertThrows(WishListEventAlreadyExistsException.class, () -> wishListService.addWishListEvent(wishList));
		verify(wishListRepository, times(1)).findByEventIdAndUserId(1l, 1);
	}

	@Test
	void givenEventAndUserIdThenShouldDeleteRespectiveWishListEvent() throws WishListEventNotFoundException {
		WishList wishList = new WishList(1, 1l, 1, "football", "2023-12-04T08:30:00", "football park", "1000",
				"Ronald");
		wishListRepository.save(wishList);
		when(wishListRepository.findByEventIdAndUserId(1l, 1)).thenReturn(Optional.of(wishList));
		wishListService.deleteWishListEvent(1l, 1);
		verify(wishListRepository, times(1)).findByEventIdAndUserId(1l, 1);
	}

	@Test
	void givenNonExistEventAndUserIdThenShouldThrowsWishListEventNotFoundException() {

		

		when(wishListRepository.findByEventIdAndUserId(1l, 1)).thenReturn(Optional.empty());

		assertThrows(WishListEventNotFoundException.class, () -> wishListService.deleteWishListEvent(1l, 1));
		verify(wishListRepository, times(1)).findByEventIdAndUserId(1l, 1);
	}

}
