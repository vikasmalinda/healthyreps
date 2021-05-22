/**
 * @author Aniket
 */
package com.sapient.healthyreps.interfaces;

import com.sapient.healthyreps.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserDAO extends CrudRepository<User, Integer> {}
