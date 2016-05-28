package ru.sandarkin.so.q37232377;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.sandarkin.so.q37232377.domain.User;

@RepositoryRestResource(exported = false)
interface UserRepository extends PagingAndSortingRepository<User, Long> {

  User getByUsername(String username);

}
