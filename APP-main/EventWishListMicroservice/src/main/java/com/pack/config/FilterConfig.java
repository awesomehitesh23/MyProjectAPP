package com.pack.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pack.filter.WishListFilter;

/**
 * Indicates this as a configuration class
 */
@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean jwtUserFilter() {

		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new WishListFilter());

		filter.addUrlPatterns("/wishlist/*");

		return filter;

	}
}
