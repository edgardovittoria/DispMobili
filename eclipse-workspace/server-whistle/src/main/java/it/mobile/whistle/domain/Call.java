package it.mobile.whistle.domain;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;



@Entity
@DiscriminatorValue("call")
public class Call extends Whistle {

	@Enumerated(EnumType.STRING)
	private CallsType callsType;

	public CallsType getCallsType() {
		return callsType;
	}

	public void setCallsType(CallsType callsType) {
		this.callsType = callsType;
	}

	
	
	
}
