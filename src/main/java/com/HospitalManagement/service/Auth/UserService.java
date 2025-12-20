package com.HospitalManagement.service.Auth;

import com.HospitalManagement.dto.SignUpDto;
import com.HospitalManagement.dto.UserDto;
import com.HospitalManagement.entity.Users;
import com.HospitalManagement.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Loading user from DB: " + username);
        return usersRepository.findByUsername(username).orElseThrow(() -> new BadCredentialsException("User with email: "+username+"is not found in the db"));
    }

    public UserDto newSignUp(SignUpDto signUpDto) {
        System.out.println("user Repository proxy: "+usersRepository.getClass()+"\n ModelMapper"+modelMapper.getClass());
        String username = signUpDto.getUsername();
        boolean isPresent = usersRepository.existsByUsername(username);
        if(isPresent){
            throw new BadCredentialsException("This user already present with this username:"+username);
        }
        Users dataTobeSaved = modelMapper.map(signUpDto, Users.class);
        dataTobeSaved.setPassword(passwordEncoder.encode(dataTobeSaved.getPassword()));
        Users savedData = usersRepository.save(dataTobeSaved);
        return modelMapper.map(savedData, UserDto.class);
    }

}
