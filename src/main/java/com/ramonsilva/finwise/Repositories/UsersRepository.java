package com.ramonsilva.finwise.Repositories;

import com.ramonsilva.finwise.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
