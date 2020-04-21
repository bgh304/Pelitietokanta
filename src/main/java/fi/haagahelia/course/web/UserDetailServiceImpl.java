package fi.haagahelia.course.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fi.haagahelia.course.domain.User2;
import fi.haagahelia.course.domain.User2Repository;

/**
 * Spring security käyttää tätä luokkaa käyttäjän autentikoimiseen ja valtuuttamiseen
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService  {
	private final User2Repository repository;

	@Autowired
	public UserDetailServiceImpl(User2Repository userRepository) {
		this.repository = userRepository;
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {   
    	User2 curruser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), 
        		AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }   
} 