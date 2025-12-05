//package com.cn.hotel.controller;
//
//import com.cn.hotel.dto.HotelRequest;
//import com.cn.hotel.model.Hotel;
//import com.cn.hotel.service.HotelService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import java.util.List;
//
//@RestController
//@RequestMapping("/hotel")
//public class HotelController {
//
//	@Autowired
//	HotelService hotelService;
//
//	@GetMapping("/userDetail")
//	public String getDetails(@AuthenticationPrincipal OidcUser oidcUser) {
//		return "User name: %s, email: %s".formatted(oidcUser.getFullName(),
//				oidcUser.getEmail());
//	}
//		
//	@PostMapping("/create")
//	@PreAuthorize("hasRole('ADMIN') or hasAuthority('admin')")
//	public void createHotel(@RequestBody HotelRequest hotelRequest)
//	{
//		hotelService.createHotel(hotelRequest);
//	} 
//	
//	@GetMapping("/id/{id}")
//	@PreAuthorize("hasRole('NORMAL') or hasAuthority('normal')")
//	public Hotel getHotelById(@PathVariable Long id)
//	{
//		return hotelService.getHotelById(id);
//	}
//	
//	@GetMapping("/getAll")
//	@PreAuthorize("hasRole('ADMIN') or hasAuthority('admin')")
//	public List<Hotel> getAllHotels()
//	{
//		return hotelService.getAllHotels();
//	}
//	
//	@DeleteMapping("/remove/id/{id}")
//	@PreAuthorize("hasRole('ADMIN') or hasAuthority('admin')")
//	public void deleteHotelById(@PathVariable Long id)
//	{
//		hotelService.deleteHotelById(id);
//	}
//}
