package com.postgrado.ecommerce.repository;

import com.postgrado.ecommerce.entity.Role;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

  // Esta es Query metods
  Role findByName(String name);

 /* // esta es con Query nativas
  @Query(value = "SELECT * FROM roles WHERE name = ?1", nativeQuery = true)
  Role findRolePorName(String name);

  // Este es copn JPQL
  @Query("SELECT r FROM Role r WHERE r.name = ?1")
  Role getRoleByName(String name);*/
}
