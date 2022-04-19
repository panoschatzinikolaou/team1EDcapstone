package com.edteam1.smdb.service;

import com.edteam1.smdb.domain.Production;
import com.edteam1.smdb.domain.ProductionType;
import com.edteam1.smdb.repository.ProductionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductionServiceImpl extends BaseServiceImpl<Production> implements ProductionService {

    private final ProductionRepository productionRepository;

    @Override
    public JpaRepository<Production, Long> getRepository() {
        return productionRepository;
    }

    @Override
    public List<Production> findByTitle(String title) {
        return null;
    }

    @Override
    public List<Production> findByReleasedDate(Date releasedDate) {
        return null;
    }

    @Override
    public List<Production> findByTitleAndType(String title, ProductionType type) {
        return null;
    }

    @Override
    public List<Production> findByReleasedDateAndType(Date releasedDate, ProductionType type) {
        return null;
    }
}
