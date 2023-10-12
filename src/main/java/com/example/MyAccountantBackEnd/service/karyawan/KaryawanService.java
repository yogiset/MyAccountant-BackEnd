package com.example.MyAccountantBackEnd.service.karyawan;

import com.example.MyAccountantBackEnd.entity.Karyawan;
import com.example.MyAccountantBackEnd.exception.AllException;

import java.util.List;

public interface KaryawanService {
    Karyawan addKaryawan(Karyawan karyawan) throws AllException;

    List<Karyawan> showAllKaryawan();

    Karyawan fetchKaryawanById(Long id) throws AllException;

    void deleteKaryawanById(Long id) throws AllException;

    Karyawan updateKaryawan(Long id, Karyawan karyawan) throws AllException;

    void deleteKaryawanByKodeKaryawan(String kodekaryawan) throws AllException;

    Karyawan updateKaryawanByKodeKaryawan(String kodekaryawan, Karyawan karyawan) throws AllException;
}
