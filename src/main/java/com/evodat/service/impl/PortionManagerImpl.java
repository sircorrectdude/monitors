package com.evodat.service.impl;

import com.evodat.dao.PortionDao;
import com.evodat.model.Portion;
import com.evodat.service.PortionManager;
import com.evodat.service.PortionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("portionManager")
@WebService(serviceName = "PortionService", endpointInterface = "com.evodat.service.PortionService")
public class PortionManagerImpl extends GenericManagerImpl<Portion, Long> implements PortionManager, PortionService {

    private PortionDao portionDao;

    @Autowired
    public void setPortionDao(PortionDao portionDao) {
        this.dao = portionDao;
        this.portionDao = portionDao;
    }

}
