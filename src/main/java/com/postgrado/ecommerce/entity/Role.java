package com.postgrado.ecommerce.entity;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;
import org.hibernate.annotations.Type;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

  @Id
  @GeneratedValue
  @Type(type = "uuid-char")
  private UUID id;
  private String name;
  private String description;

  public Role(String name) {
    this.name = name;
  }
}
