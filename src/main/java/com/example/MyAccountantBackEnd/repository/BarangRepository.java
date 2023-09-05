package com.example.MyAccountantBackEnd.repository;

import com.example.MyAccountantBackEnd.entity.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarangRepository extends JpaRepository<Barang,Long> {
}
