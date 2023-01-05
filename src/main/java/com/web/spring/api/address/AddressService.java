package com.web.spring.api.address;

import com.web.spring.api.product.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    @Transactional
    public Long registerAddress(AddressEntity address) {
        addressRepository.save(address);
        return address.getId();
    }
}
