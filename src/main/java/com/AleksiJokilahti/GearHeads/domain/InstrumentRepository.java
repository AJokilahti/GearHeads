package com.AleksiJokilahti.GearHeads.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface InstrumentRepository extends CrudRepository<Instrument, Long>{

	List<Instrument> findByModel(String model);
	
	List<Instrument> findByOwner(User user);
}
