package com.rpc;

import java.io.IOException;

//import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rpc.server.RPCServer;
import com.rpc.utils.StaticRPC;

@SpringBootApplication
public class RpcProjectAsDataStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpcProjectAsDataStoreApplication.class, args);
		try {
			RPCServer server = new RPCServer(StaticRPC.PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
