package com.example.cafeteria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cafeteria.Exception.AddressNotFoundException;
import com.example.cafeteria.model.Address;
import com.example.cafeteria.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	AddressRepository addressrepository;

	public Address cretaeaddress(Address address) {
		Address addres=addressrepository.save(address);
		
		return addres;
	}

	public Address getAddressbyid(int id) throws AddressNotFoundException {
		Optional<Address> adres=addressrepository.findById(id);
		if(adres.isPresent()) {
			Address ads=adres.get();
			return ads;
		}else {
			throw new AddressNotFoundException("Given data is not found");
		}
	}

	public Address updateAddress(Address address, int id) throws AddressNotFoundException {
		Optional<Address> adres=addressrepository.findById(address.getId());
		if(adres.isPresent()) {
			Address adre=adres.get();
			if(address.getCity()!=null) {
				adre.setCity(address.getCity());
			}
			if(address.getStreetName()!=null) {
				adre.setStreetName(address.getStreetName());
			}
			if(address.getPincode()!=null)
			{
				adre.setPincode(address.getPincode());
			}
//			if(address.getDeliveryman()!=null) {
//				adre.setDeliveryman(address.getDeliveryman());
//			}
			return addressrepository.save(adre);
		}
		else {
			throw new AddressNotFoundException("Given data is not found");

		}
	}

	public void deleteAddress(int id) throws AddressNotFoundException {
		Optional<Address> adres=addressrepository.findById(id);
		if(adres.isPresent()) {
			 addressrepository.deleteById(id);
		}else {
			throw new AddressNotFoundException("Given data is not found");

		}
	}

	public List<Address> getaddress() throws AddressNotFoundException {
		List<Address> add=addressrepository.findAll();
		if(add.size()>0) {
			return add;
		}else {
			throw new AddressNotFoundException("no data found ");
		}
		
	}

}
