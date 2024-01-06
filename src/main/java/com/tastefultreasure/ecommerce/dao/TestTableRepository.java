package com.tastefultreasure.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.tastefultreasure.ecommerce.entity.TestTable;

@Repository
@RepositoryRestResource(collectionResourceRel ="testtable", path="test-table")
public interface TestTableRepository extends JpaRepository<TestTable, Long> {

}
