package com.web.www.repository;

import com.web.www.domain.rental.RentalLiftVO;

public interface RentalDAO {

	int liftReserve(RentalLiftVO rlivo);

	void rental(long memberNum);

}
