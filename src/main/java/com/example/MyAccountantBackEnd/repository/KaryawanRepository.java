package com.example.MyAccountantBackEnd.repository;

import com.example.MyAccountantBackEnd.entity.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanRepository extends JpaRepository<Karyawan,Long> {
}
