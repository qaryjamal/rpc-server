package com.rpc.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;

import com.rpc.utils.RequestMethodName;
import com.rpc.wrapper.ToDoWrapper;
import com.rpc.service.*;

public class RPCServer {

	private final ServerSocket serverSocket;
	@Autowired
	private ToDoService toDoService;
	private Socket socketPipe;

	public RPCServer(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		String localIP = InetAddress.getLocalHost().getHostAddress();
		System.out.println("Server is running on " + localIP + ":" + port);

		while (true) {

			socketPipe = serverSocket.accept();
			String clientIPAddress = socketPipe.getRemoteSocketAddress().toString();

			System.out.println("New client connected : " + clientIPAddress);

			new Thread(() -> {
				try {
					addHook(socketPipe);
				} catch (IOException ex) {
					System.err.println("Client disconnected " + clientIPAddress);
				}
			}).start();

		}
	}

	private void addHook(Socket socketPipe) throws IOException {

		ToDoWrapper wrapper = null;
		ObjectInputStream objectInputStream = new ObjectInputStream(socketPipe.getInputStream());
		try {
			wrapper = (ToDoWrapper) objectInputStream.readObject();

			if (wrapper != null) {
				if (wrapper.getRequest().contentEquals(RequestMethodName.POST.toString())) {
					this.toDoService.createToDo(wrapper);
				} else if (wrapper.getRequest().contentEquals(RequestMethodName.GET.toString())) {
					/* ToDoWrapper wraper = */this.toDoService.getToDo(wrapper.getId());
				} else if (wrapper.getRequest().contentEquals(RequestMethodName.UPDATE.toString())) {
					this.toDoService.updateToDo(wrapper);
				} else if (wrapper.getRequest().contentEquals(RequestMethodName.DELETE.toString())) {
					this.toDoService.deleteToDo(wrapper.getId());
				} else if (wrapper.getRequest().contentEquals(RequestMethodName.ALL.toString())) {
					this.toDoService.getToDoWrappers();
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
