package com.example.sell_clothing_api.Service.Iplm;

import com.example.sell_clothing_api.Model.SanPham;
import com.example.sell_clothing_api.Repository.ISanPhamrepository;
import com.example.sell_clothing_api.Service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class SanPhamServiceIplm implements ISanPhamService {

    @Autowired
    private ISanPhamrepository sanPhamrepository;

    @Override
    public Page<SanPham> getAll(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        return sanPhamrepository.findAll(pageable);
    }

    @Override
    public Boolean add(SanPham sanPham) {
        try {
            sanPhamrepository.save(sanPham);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(SanPham sanPham, BigInteger idSanPham) {

        try {
            sanPham.setMaSanPham(idSanPham);
            sanPhamrepository.save(sanPham);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }

    }

    @Override
    public Boolean delete(BigInteger idSanPham) {
        try {
            sanPhamrepository.deleteById(idSanPham);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }

    }

//    @Override
//    public List<SanPham> list_Found(String keyword) {
//        return sanPhamrepository.findAllByChatLieuAndAndLoaiSanPhamAndMauSacAndNhaSanXuat(keyword);
//    }

    @Override
    public List<SanPham> list_check_Exists(String tenSanPham) {
        return sanPhamrepository.findByTenSanPham(tenSanPham);
    }

    @Override
    public Optional<SanPham> findbyId(BigInteger idSanPham) {
        return sanPhamrepository.findById(idSanPham);
    }
}
