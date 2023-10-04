package com.example.MyAccountantBackEnd.service.barang;

import com.example.MyAccountantBackEnd.entity.Barang;
import com.example.MyAccountantBackEnd.exception.AllException;
import com.example.MyAccountantBackEnd.repository.BarangRepository;
import com.example.MyAccountantBackEnd.service.UUIDGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class BarangServiceImpl implements BarangService {
    @Autowired
    private BarangRepository barangRepository;


    @Override
    public Barang addBarang(Barang barang) throws AllException {
        barang.setKodebarang(UUIDGeneratorService.generateBarang());

        if (barang.getNamabarang() == null || barang.getNamabarang().isEmpty()) {
            throw new AllException("Nama barang harus di isi !!!");
        }
        if (barang.getJenisbarang() == null || barang.getJenisbarang().isEmpty()) {
            throw new AllException("Jenis barang harus di isi !!!");
        }
        if (barang.getJumlahbarang() == null || barang.getJumlahbarang().describeConstable().isEmpty()) {
            throw new AllException("Jumlah barang harus di isi !!!");
        }
        if (barang.getHargabarang() == null || barang.getHargabarang().describeConstable().isEmpty()) {
            throw new AllException("No HP harus di isi !!!");
        }

        Optional<LocalDate> tglmasuk = Optional.ofNullable(barang.getTglmasuk());
        if (tglmasuk.isPresent()) {
            String tanggalMasuk = tglmasuk.get().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            if (tanggalMasuk.isEmpty()) {
                throw new AllException("Tanggal masuk harus di isi !!!");
            }
        } else {
            throw new AllException("Tanggal masuk harus di isi !!!");
        }

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
        if (barang.getNamabarang() == null || barang.getNamabarang().isEmpty()) {
            throw new AllException("Nama barang harus di isi !!!");
        }
        if (barang.getJenisbarang() == null || barang.getJenisbarang().isEmpty()) {
            throw new AllException("Jenis barang harus di isi !!!");
        }
        if (barang.getJumlahbarang() == null || barang.getJumlahbarang().describeConstable().isEmpty()) {
            throw new AllException("Jumlah barang harus di isi !!!");
        }
        if (barang.getHargabarang() == null || barang.getHargabarang().describeConstable().isEmpty()) {
            throw new AllException("No HP harus di isi !!!");
        }

        Optional<LocalDate> tglmasuk = Optional.ofNullable(barang.getTglmasuk());
        if (tglmasuk.isPresent()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String tanggalMasuk = barang.getTglmasuk().format(formatter);
            if (tanggalMasuk.isEmpty()) {
                throw new AllException("Tanggal masuk harus di isi !!!");
            }
        } else {
            throw new AllException("Tanggal masuk harus di isi !!!");
        }

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
