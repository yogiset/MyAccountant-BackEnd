package com.example.MyAccountantBackEnd.service.barang;

import com.example.MyAccountantBackEnd.entity.Barang;
import com.example.MyAccountantBackEnd.exception.AllException;
import java.util.List;

public interface BarangService {
    Barang addBarang(Barang barang) throws AllException;

    List<Barang> listBarang();

    Barang listBarangById(Long id) throws AllException;

    void deleteBarangById(Long id) throws AllException;

    Barang updateBarangById(Long id, Barang barang) throws AllException;

    void deleteBarangByKodeBarang(String kodebarang) throws AllException;

    Barang updateBarangByKodeBarang(String kodebarang, Barang barang) throws AllException;
}
