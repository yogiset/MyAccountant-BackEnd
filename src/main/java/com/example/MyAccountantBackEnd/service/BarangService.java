package com.example.MyAccountantBackEnd.service;

import com.example.MyAccountantBackEnd.entity.Barang;
import com.example.MyAccountantBackEnd.exception.AllException;

import java.util.List;

public interface BarangService {
    Barang addBarang(Barang barang);

    List<Barang> listBarang();

    Barang listBarangById(Long id) throws AllException;

    void deleteBarangById(Long id) throws AllException;

    Barang updateBarangById(Long id, Barang barang) throws AllException;
}
