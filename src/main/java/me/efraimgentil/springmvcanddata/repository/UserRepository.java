package me.efraimgentil.springmvcanddata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import me.efraimgentil.springmvcanddata.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>  {

}
