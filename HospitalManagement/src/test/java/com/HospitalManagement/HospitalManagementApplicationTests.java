package com.HospitalManagement;

import com.HospitalManagement.entity.Users;
import com.HospitalManagement.service.Auth.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HospitalManagementApplicationTests {

	@Autowired
	private JwtService jwtService;
	@Test
	void contextLoads() {
		Users users = new Users(100L, "raushan.kumar@gmail.com", "raushan","asdf854");
		String token = jwtService.generateToken(users);
		System.out.print(token);


		Long id = jwtService.getUserIdFromToken(token); // This should pass successfully
		System.out.print(id);
		Long id1 = jwtService.getUserIdFromToken(token+"1236lkj"); // Fail: btoken.security.SignatureException: JWT signature does not match locally computed signature.
	}

}
