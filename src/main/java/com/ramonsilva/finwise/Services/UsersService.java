package com.ramonsilva.finwise.Services;

import com.ramonsilva.finwise.Dto.UserDTO;
import com.ramonsilva.finwise.Entity.Users;
import com.ramonsilva.finwise.Mapper.UserMapper;
import com.ramonsilva.finwise.Repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<UserDTO> getAllUsers() {
        return usersRepository.findAll().stream()
                .map(UserMapper::toDTO)// convert entity to dto
                .collect(Collectors.toList());
    }

    public Optional<UserDTO> getUserById(Long id) {
        return usersRepository.findById(id)
                .map(UserMapper::toDTO);
    }

    public UserDTO createUser(UserDTO userDTO) {
        Users user = UserMapper.toEntity(userDTO);
        Users savedUser = usersRepository.save(user);
        return UserMapper.toDTO(savedUser);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        return usersRepository.findById(id)
                .map(user -> {
                    user.setName(userDTO.getName());
                    user.setEmail(userDTO.getEmail());
                    user.setPassword(userDTO.getPassword());
                    Users updatedUser = usersRepository.save(user);
                    return UserMapper.toDTO(updatedUser);
                }).orElseThrow(() -> new RuntimeException("User not found by id" + id));
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }



}
