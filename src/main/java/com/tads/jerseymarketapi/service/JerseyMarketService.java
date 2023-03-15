package com.tads.jerseymarketapi.service;

import com.tads.jerseymarketapi.models.JerseyMarketUserModel;
import com.tads.jerseymarketapi.repository.JerseyMarketRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class JerseyMarketService {

    final JerseyMarketRepository jerseyMarketRepository;

    public JerseyMarketService(JerseyMarketRepository jerseyMarketRepository) {
        this.jerseyMarketRepository = jerseyMarketRepository;
    }

    @Transactional
    public JerseyMarketUserModel save(JerseyMarketUserModel jerseyMarketUserModel) {
        return jerseyMarketRepository.save(jerseyMarketUserModel);
    }

}
