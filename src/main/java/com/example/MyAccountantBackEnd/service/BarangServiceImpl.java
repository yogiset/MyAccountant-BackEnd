package com.example.MyAccountantBackEnd.service;

import com.example.MyAccountantBackEnd.entity.Barang;
import com.example.MyAccountantBackEnd.exception.AllException;
import com.example.MyAccountantBackEnd.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarangServiceImpl implements BarangService {
    @Autowired
    private BarangRepository barangRepository;


    @Override
    public Barang addBarang(Barang barang) {
        barang.setKodebarang(UUIDGeneratorService.generateBarang());
        return barangRepository.save(barang);
    }

    @Override
    public List<Barang> listBarang() {

        return barangRepository.findAll();
    }

    @Override
    public Barang listBarangById(Long id) throws AllException {

        Optional<Barang> barang = barangRepository.findById(id);

        if(!barang.isPresent()){
            throw new AllException("Barang tidak ditemukan");
        }
        return barang.get();
    }

    @Override
    public void deleteBarangById(Long id) throws AllException {
        boolean exist = barangRepository.existsById(id);
        if(!exist){
            throw new AllException("Barang dengan Id" + id + "tidak ada");
        }
        barangRepository.deleteById(id);

    }

    @Override
    public Barang updateBarangById(Long id, Barang barang) throws AllException {
        Barang updatedBarang = barangRepository.findById(id)
                .orElseThrow(() -> new AllException("Barang dengan Id" + id + "tidak ada"));

        updatedBarang.setNamabarang(barang.getNamabarang());
        updatedBarang.setJenisbarang(barang.getJenisbarang());
        updatedBarang.setJumlahbarang(barang.getJumlahbarang());
        updatedBarang.setHargabarang(barang.getHargabarang());
        updatedBarang.setTglmasuk(barang.getTglmasuk());
        barangRepository.save(updatedBarang);

        return updatedBarang;
    }
}
