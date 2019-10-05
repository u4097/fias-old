package ru.basis.fias.ws;

import org.springframework.transaction.annotation.Transactional;
import ru.basis.fias.domain.AddressObject;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://basis.ru/nsi/fias")
public interface FiasEndpoint {

	@WebMethod
	@Transactional
	public List<AddressObject> getAddressObjects(@WebParam(name = "parentGuid") String parentGuid);

	@WebMethod
	@Transactional
	public AddressObject getAddressObject(@WebParam(name = "guid") String guid);
}
