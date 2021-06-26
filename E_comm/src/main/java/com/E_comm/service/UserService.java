package com.E_comm.service;

import java.util.Set;

import com.E_comm.domain.User;
import com.E_comm.domain.UserBilling;
import com.E_comm.domain.UserPayment;
import com.E_comm.domain.UserShipping;
import com.E_comm.domain.security.PasswordResetToken;
import com.E_comm.domain.security.UserRole;

public interface UserService {

	PasswordResetToken getPasswordResetToken(final String token);

	void createPasswordResetTokenForUser(final User user, final String token);

	User findByUsername(String username);

	User findByEmail(String email);
	
	User findById(Long id);

	User createUser(User user, Set<UserRole> userRoles) throws Exception;

	User save(User user);

	void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);
	
	void updateUserShipping(UserShipping userShipping, User user);

	void setUserDefaultPayment(Long userPaymentId, User user);
	
	void setUserDefaultShipping(Long userShippingId, User user);

}
