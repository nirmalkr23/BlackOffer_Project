package com.spring.batchConfig;


import org.springframework.batch.item.ItemProcessor;

import com.spring.entity.BlackOffer;


public class BlackOfferProcessor implements ItemProcessor<BlackOffer, BlackOffer> {

	@Override
	public BlackOffer process(BlackOffer item) throws Exception {
		// TODO Auto-generated method stub
		return item;
	}

    
}
