package org.acme;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/api/todos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoResource {

	private static List<Todo> todos = new ArrayList<>();
	private static AtomicInteger atomicInteger = new AtomicInteger();
	
	static {
		todos.add(new Todo(1, "item-1", true));
		todos.add(new Todo(2, "item-2", true));
		todos.add(new Todo(3, "item-3", false));
		todos.add(new Todo(4, "item-4", false));
	}

	@POST
	public Response addTodo(Todo todo) {
		int nextId = atomicInteger.incrementAndGet();
		todo.setId(nextId);
		todos.add(nextId, todo);
		URI location=
				UriBuilder
				.fromResource(TodoResource.class)
				.path(Integer.toString(nextId))
				.build();
		return Response.created(location).entity(todo).build();
	}

	@PUT
	public void updateTodo() {
		System.out.println("PUT");
	}

	@GET
	@Path("/{id}")
	public Response getTodo(@PathParam("id") int id) {
		
		Optional<Todo> optional=
		 todos
		.stream()
		.filter(todo->todo.getId()==id)
		.findFirst();
		
		if(optional.isPresent()) {
			return Response.ok().entity(optional.get()).build();
		}
		else {
			return Response.status(404).build();
		}
		
		
	}
	
	@GET
	public List<Todo> getTodos() {
			return todos;
	}

	@DELETE
	public void deleteTodo() {
		System.out.println("DELETE");
	}

}
