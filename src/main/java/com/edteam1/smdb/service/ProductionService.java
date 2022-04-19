package com.edteam1.smdb.service;

import com.edteam1.smdb.domain.Production;
import com.edteam1.smdb.domain.ProductionType;

import java.util.Date;
import java.util.List;

public interface ProductionService extends BaseService<Production,Long>{

    List<Production> findByTitle(String title);

    List<Production> findByReleasedDate(Date releasedDate);

    Production findByTitleAndType(String title, ProductionType type);

    List<Production> findByReleasedDateAndType(Date releasedDate, ProductionType type);

}
