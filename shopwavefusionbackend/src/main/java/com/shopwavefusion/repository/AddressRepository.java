package com.shopwavefusion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopwavefusion.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
