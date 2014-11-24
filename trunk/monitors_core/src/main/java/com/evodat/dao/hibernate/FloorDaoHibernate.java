package com.evodat.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.evodat.dao.FloorDao;
import com.evodat.model.Floor;
import com.evodat.model.FloorState;

@Repository("floorDao")
public class FloorDaoHibernate extends GenericDaoHibernate<Floor, Long>
		implements FloorDao {

	public FloorDaoHibernate() {
		super(Floor.class);
	}

	public void resetTemporarilyOccupiedFloors() {
		List<Floor> floors = getHibernateTemplate().find(
				"from Floor where floorState=?", FloorState.TEMPORARY);
		for (Floor floor : floors) {
			floor.setFloorState(FloorState.SYSTEM);
			getHibernateTemplate().update(floor);
			log.info(floor + " reset to System Managed");

		}
	}
}
