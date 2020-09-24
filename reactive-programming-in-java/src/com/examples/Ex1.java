package com.examples;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class User {
	String username;
	String password;

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

}
//-------------------------------------------
// data layer
//-------------------------------------------

interface UserRepository {

//	User findUser(String username);

	// JDK 1.5
//	Future<User> findUser(String username);

	// JDK 1.8

	CompletableFuture<User> findUser(String username);

}

class JpaUserRepository implements UserRepository {

//	@Override
//	public User findUser(String username) {
//		System.out.println("UR - "+Thread.currentThread());
//		// io.... 5s
//		TimeUnit.SECONDS.sleep(5);
//		return new User(username, "shhh...");
//	}

//	@Override
//	public Future<User> findUser(String username) {
//		ExecutorService executorService = Executors.newFixedThreadPool(4);
//		Callable<User> callable = () -> {
//			System.out.println("UR - " + Thread.currentThread());
//			// io.... 5s
//			TimeUnit.SECONDS.sleep(5);
//			return new User(username, "shhh..."); // push
//		};
//		Future<User> future = executorService.submit(callable);
//		return future;
//	}

	@Override
	public CompletableFuture<User> findUser(String username) {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		CompletableFuture<User> completableFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("UR - " + Thread.currentThread());
//			// io.... 5s
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return new User(username, "shhh..."); // push
		}, executorService);
		return completableFuture;
	}

}

//-------------------------------------------
//service layer
//-------------------------------------------

class AuthService {
	UserRepository userRepository;

	public AuthService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public void authenticate(String username, String password) {

//		User user = userRepository.findUser(username); // pull / sync / blocking - call
//		System.out.println("AS - "+Thread.currentThread()+" - "+user);

//		Future<User> future = userRepository.findUser(username);
//		// ..
//		// ..
//		try {
//			User user = future.get(); /// ..
//			System.out.println("AS - "+Thread.currentThread()+" - "+user);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		} //

		ExecutorService executorService = Executors.newFixedThreadPool(4);
		CompletableFuture<User> completableFuture = userRepository.findUser(username);
		completableFuture.thenAcceptAsync(user -> {
			System.out.println("AS - " + Thread.currentThread() + " - " + user);
		}, executorService);

	}
}

public class Ex1 {

	public static void main(String[] args) {

		AuthService authService = new AuthService(new JpaUserRepository());
		authService.authenticate("user", "shhh....");
		
		System.out.println(Thread.currentThread()+" can take next auth request as well");
		
		

	}

}
