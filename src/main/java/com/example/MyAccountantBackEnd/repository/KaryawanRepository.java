package com.example.MyAccountantBackEnd.repository;


import com.example.MyAccountantBackEnd.entity.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Repository
public interface KaryawanRepository extends JpaRepository<Karyawan,Long> {

    @Query("select u from Karyawan u where u.kodekaryawan=:kodekaryawan")
    Optional<Karyawan> findBykodekaryawan(@Param("kodekaryawan") String kodekaryawan);

    @Transactional
    @Modifying
    @Query("DELETE FROM Karyawan b WHERE b.kodekaryawan = :kodekaryawan")
    void deleteBykodekaryawan(String kodekaryawan);

}
