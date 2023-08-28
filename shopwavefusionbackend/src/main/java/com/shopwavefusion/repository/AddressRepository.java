package com.shopwavefusion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopwavefusion.modal.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
