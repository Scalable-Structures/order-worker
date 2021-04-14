package com.scalablestructures.orderworker.app.provider.database.mysql.repository;

import com.scalablestructures.orderworker.app.provider.database.mysql.table.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderTable, UUID> {
}
