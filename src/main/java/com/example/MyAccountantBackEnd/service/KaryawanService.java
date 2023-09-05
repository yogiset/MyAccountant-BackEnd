package com.example.MyAccountantBackEnd.service;

import com.example.MyAccountantBackEnd.entity.Karyawan;
import com.example.MyAccountantBackEnd.exception.AllException;

import java.util.List;

public interface KaryawanService {
    Karyawan addKaryawan(Karyawan karyawan);

    List<Karyawan> showAllKaryawan();

    Karyawan fetchKaryawanById(Long id) throws AllException;

    void deleteKaryawanById(Long id) throws AllException;

    Karyawan updateKaryawan(Long id, Karyawan karyawan) throws AllException;
}
