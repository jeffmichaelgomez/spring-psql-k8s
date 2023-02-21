package com.mis.studentdata.outbound;

import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(name="myPubSubGateway", defaultRequestChannel = "outboundMsgChannel")
public interface OutboundChannel {	
	void sendMsgToPubSub(String msg);
}
