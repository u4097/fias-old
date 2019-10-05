package ru.basis.fias.ws.impl;


import org.springframework.beans.factory.annotation.Autowired;
import ru.basis.fias.domain.AddressObject;
import ru.basis.fias.service.FiasService;
import ru.basis.fias.ws.FiasEndpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ru.basis.fias.ws.FiasEndpoint", targetNamespace = "http://basis.ru/nsi/fias", serviceName = "fiasService")
public class FiasEndpointImpl implements FiasEndpoint {

	@Autowired
	private FiasService fiasService;

	public FiasService getFiasService() {
		return fiasService;
	}

	public void setFiasService(FiasService fiasService) {
		this.fiasService = fiasService;
	}

	@WebMethod
	public List<AddressObject> getAddressObjects(@WebParam(name = "parentGuid") String parentGuid) {
		return fiasService.loadAddressObjects(parentGuid);
	}

	@WebMethod
	public AddressObject getAddressObject(@WebParam(name = "guid") String guid) {
		return fiasService.loadAddressObject(guid);
	}
}
