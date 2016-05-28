package ru.sandarkin.so.q37232377.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User implements Serializable {

  // UID

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonIgnore
  private Long id;

  @Column(unique = true)
  @NotNull
  private String username;

  @Column(name = "password_hash")
  @JsonIgnore
  @NotNull
  private String passwordHash;

  @NotNull
  private Boolean enabled;

/*  // No Repository
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
  @NotEmpty
  private Set<UserRole> roles = new HashSet<>();*/

  // The SDR Managed Entity
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(name = "user_place",
      joinColumns = { @JoinColumn(name = "users_id") },
      inverseJoinColumns = { @JoinColumn(name = "place_id")})
  private Set<Place> places = new HashSet<Place>();


}
