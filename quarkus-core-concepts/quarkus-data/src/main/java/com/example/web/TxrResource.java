package com.example.web;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.service.TxrService;

@Path("/api/txr")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TxrResource {

	@Inject
	private TxrService txrService;

	@POST
	public TxrResponse doTxr(TxrRequest request) {
		boolean b = txrService.txr(request.getAmount(), request.getFromAccNumber(), request.getToAccNumber());
		String message = b ? "success" : "failed";
		TxrResponse response = new TxrResponse();
		response.setMessage(message);
		return response;
	}

}
