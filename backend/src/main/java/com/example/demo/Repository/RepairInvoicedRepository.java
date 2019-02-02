package com.example.demo.Repository;

import com.example.demo.Entity.RepairInvoiced;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairInvoicedRepository extends JpaRepository<RepairInvoiced , Long> {
}
