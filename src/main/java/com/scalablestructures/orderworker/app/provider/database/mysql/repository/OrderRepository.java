package com.scalablestructures.orderworker.app.provider.database.mysql.repository;

import com.scalablestructures.orderworker.app.provider.database.mysql.table.OrdersTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrdersTable, String> {
}
