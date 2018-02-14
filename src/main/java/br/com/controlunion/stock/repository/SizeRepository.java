package br.com.controlunion.stock.repository;

import java.util.List;

import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controlunion.stock.model.Size;

@Named
public interface SizeRepository extends JpaRepository<Size, Integer> {

    List<Size> findByEnable(Boolean enable);
}
