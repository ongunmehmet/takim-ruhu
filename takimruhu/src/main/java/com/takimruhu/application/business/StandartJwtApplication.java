package com.takimruhu.application.business;

import com.takimruhu.dto.request.jwt.JwtRequest;
import com.takimruhu.dto.response.jwt.JwtResponse;
import com.takimruhu.entities.Customer;
import com.takimruhu.repository.CustomerRepository;
import com.takimruhu.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StandartJwtApplication implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String userName =jwtRequest.getUserName();
        String userPassword =jwtRequest.getUserPassword();
        authenticate(userName,userPassword);
    final UserDetails userDetails=loadUserByUsername(userName);
    String newGeneratedToken=jwtUtil.generateToken(userDetails);
    var user =customerRepository.findByEmail(userName);
    return new JwtResponse(user,newGeneratedToken);
    }




    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      var user= customerRepository.findByEmail(email);
      if(user!=null) {
          return new User(user.getEmail(), user.getPassword(), getAuthorities(user));
      }else{
          throw  new UsernameNotFoundException("Email is not valid");

      }
    }

    private Set getAuthorities(Customer customer){
        Set authorities = new HashSet();

        customer.getRoles().forEach(role -> {authorities.add(new SimpleGrantedAuthority("ROLE_"+ role.getRoleName()));
        });
        return  authorities;
    }
    private void authenticate(String userName,String userPassword) throws Exception {

       try{
           authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,userPassword));
       }catch (DisabledException e){
           throw  new Exception("User is disabled");
       }catch (BadCredentialsException e){
           throw new Exception("Bad creadential from user");
       }

    }

}
