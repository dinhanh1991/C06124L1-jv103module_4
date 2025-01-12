package com.example.to_khai_y_te.repository;
import com.example.to_khai_y_te.entity.ToKhaiYTe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IToKhaiRepository extends JpaRepository<ToKhaiYTe, Long> {

}
