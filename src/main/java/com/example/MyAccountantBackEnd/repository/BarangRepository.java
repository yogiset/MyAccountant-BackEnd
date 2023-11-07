package com.example.MyAccountantBackEnd.repository;

import com.example.MyAccountantBackEnd.entity.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Repository
public interface BarangRepository extends JpaRepository<Barang,Long> {
    @Query("select u from Barang u where u.kodebarang=:kodebarang")
    Optional <Barang> findBykodebarang(@Param("kodebarang") String kodebarang);

    @Transactional
    @Modifying
    @Query("DELETE FROM Barang b WHERE b.kodebarang = :kodebarang")
    void deleteBykodebarang(String kodebarang);

}
