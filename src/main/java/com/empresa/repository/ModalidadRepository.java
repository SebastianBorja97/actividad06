package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.FiltroModalidad;
import com.empresa.entity.Modalidad;

public interface ModalidadRepository extends JpaRepository<Modalidad, Integer>  {

	@Query("select m from Modalidad m where "
			+ "( :#{#moda.idModalidad} is 0 or m.idModalidad = :#{#moda.idModalidad} ) and "
			+ "( :#{#moda.sede} is '' or m.sede like :#{#moda.sede} ) and "
			+ "( :#{#moda.idDeporte} is 0  or m.deporte.idDeporte = :#{#moda.idDeporte} ) ")
	public abstract List<Modalidad> listaPorFiltroModalidad(@Param("moda")FiltroModalidad moda);
}
