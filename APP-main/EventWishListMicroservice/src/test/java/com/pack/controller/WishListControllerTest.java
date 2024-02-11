package com.pack.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pack.model.WishList;
import com.pack.service.WishListServiceImpl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

 
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class WishListControllerTest {
 

    private MockMvc mockMvc;
    
    @Mock
    private WishListServiceImpl wishListService;
    
    @InjectMocks
    private WishListController wishListController;
    
    private WishList event;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(wishListController).build();
        event = new WishList(1, 1l, 1, "football", "2023-12-04T08:30:00", "football park", "1000",
				"Ronald");
       
    }

    @AfterEach
    public void tearDown() {
        event = null;
    }

    @Test
    void givenEventToSaveThenShouldReturnSavedEvent() throws Exception {
        when(wishListService.addWishListEvent(event)).thenReturn(event);
        mockMvc.perform(post("/wishlist/addFavourite").header("Authorization","token")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(event)))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }
 

    
    @Test
    void givenEventAndUserIdThenShouldReturnWishListEvent() throws Exception {
    	when(wishListService.getWishListEvent(1l,1)).thenReturn(event);
        mockMvc.perform(get("/wishlist/viewFavourite/{eventId}/{userId}",1l,1)
        		.header("Authorization","token")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(event)))
                .andDo(MockMvcResultHandlers.print());
    
    }
    
    @Test 
    void givenEventAndUserIdThenShouldDeleteWishListEvent() throws Exception {
    	when(wishListService.deleteWishListEvent(1l,1)).thenReturn(event);
        mockMvc.perform(delete("/wishlist/deleteFavourite/{eventId}/{userId}",1l,1)
        		.header("Authorization","token")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(event)))
                .andDo(MockMvcResultHandlers.print());
 
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}