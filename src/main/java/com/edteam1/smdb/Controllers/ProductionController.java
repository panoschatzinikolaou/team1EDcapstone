package com.edteam1.smdb.Controllers;

import com.edteam1.smdb.domain.Production;
import com.edteam1.smdb.service.BaseService;
import com.edteam1.smdb.service.ProductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/productions")
public class ProductionController extends AbstractController<Production> {

    private final ProductionService productionService;
    @Override
    protected BaseService<Production, Long> getBaseService() {
        return productionService;
    }
}
