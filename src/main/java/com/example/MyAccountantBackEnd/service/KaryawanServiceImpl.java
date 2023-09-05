package com.example.MyAccountantBackEnd.service;

import com.example.MyAccountantBackEnd.entity.Karyawan;
import com.example.MyAccountantBackEnd.exception.AllException;
import com.example.MyAccountantBackEnd.repository.KaryawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class KaryawanServiceImpl implements KaryawanService {
    @Autowired
    private KaryawanRepository karyawanRepository;

    @Override
    public Karyawan addKaryawan(Karyawan karyawan) throws AllException {
        karyawan.setKodekaryawan(UUIDGeneratorService.generateKaryawan());

        if (karyawan.getNama() == null || karyawan.getNama().isEmpty()) {
            throw new AllException("Nama harus di isi !!!");
        }
        if (karyawan.getEmail() == null || karyawan.getEmail().isEmpty()) {
            throw new AllException("Email harus di isi !!!");
        }
        if (karyawan.getJabatan() == null || karyawan.getJabatan().isEmpty()) {
            throw new AllException("Jabatan harus di isi !!!");
        }
        if (karyawan.getPhone() == null || karyawan.getPhone().isEmpty()) {
            throw new AllException("No HP harus di isi !!!");
        }

        Optional<LocalDate> tgllahir = Optional.ofNullable(karyawan.getTgl_lahir());
        if (tgllahir.isPresent()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String tanggalLahir = karyawan.getTgl_lahir().format(formatter);
            if (tanggalLahir.isEmpty()) {
                throw new AllException("Tanggal lahir harus di isi !!!");
            }
        } else {
            throw new AllException("Tanggal lahir harus di isi !!!");
        }


        return karyawanRepository.save(karyawan);
    }

    @Override
    public List<Karyawan> showAllKaryawan() {


        return karyawanRepository.findAll();
    }

    @Override
    public Karyawan fetchKaryawanById(Long id) throws AllException {
        Optional<Karyawan> karyawan = karyawanRepository.findById(id);

        if(!karyawan.isPresent()){
            throw new AllException("Karyawan tidak ditemukan");
        }
        return karyawan.get();
    }

    @Override
    public void deleteKaryawanById(Long id) throws AllException {
        boolean exist = karyawanRepository.existsById(id);
        if(!exist){
            throw new AllException("karyawan dengan Id" + id + "tidak ada");
        }
        karyawanRepository.deleteById(id);


    }

    @Override
    public Karyawan updateKaryawan(Long id, Karyawan karyawan) throws AllException {
        if (karyawan.getNama() == null || karyawan.getNama().isEmpty()) {
            throw new AllException("Nama harus di isi !!!");
        }
        if (karyawan.getEmail() == null || karyawan.getEmail().isEmpty()) {
            throw new AllException("Email harus di isi !!!");
        }
        if (karyawan.getJabatan() == null || karyawan.getJabatan().isEmpty()) {
            throw new AllException("Jabatan harus di isi !!!");
        }
        if (karyawan.getPhone() == null || karyawan.getPhone().isEmpty()) {
            throw new AllException("No HP harus di isi !!!");
        }

        Optional<LocalDate> tgllahir = Optional.ofNullable(karyawan.getTgl_lahir());
        if (tgllahir.isPresent()) {
            String tanggalLahir = tgllahir.get().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            if (tanggalLahir.isEmpty()) {
                throw new AllException("Tanggal lahir harus di isi !!!");
            }
        } else {
            throw new AllException("Tanggal lahir harus di isi !!!");
        }

        Karyawan updatedKaryawan = karyawanRepository.findById(id)
                .orElseThrow(() -> new AllException("karyawan dengan Id" + id + "tidak ada"));

        updatedKaryawan.setNama(karyawan.getNama());
        updatedKaryawan.setEmail(karyawan.getEmail());
        updatedKaryawan.setJabatan(karyawan.getJabatan());
        updatedKaryawan.setPhone(karyawan.getPhone());
        updatedKaryawan.setImageurl(karyawan.getImageurl());
        updatedKaryawan.setTgl_lahir(karyawan.getTgl_lahir());
        karyawanRepository.save(updatedKaryawan);

        return updatedKaryawan;
    }
}
