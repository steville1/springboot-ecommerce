package com.tastefultreasure.ecommerce.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tastefultreasure.ecommerce.entity.Order;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long> {
	Page<Order> findByCustomerEmailOrderByDateCreatedDesc(@Param("email") String email, Pageable pageable);
	/**Behind the scene query
	 
	 Select * from orders
	 LEFT OUTER JOIN customer
	 ON orders.customer_id = customer.id
	 WHERE customer.email = :email
	 ORDER BY orders.date_created DESC
	 * 
	 */

}
