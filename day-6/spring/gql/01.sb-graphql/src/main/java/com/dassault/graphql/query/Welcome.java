package com.dassault.graphql.query;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class Welcome {
	@QueryMapping
	public String welcomeQuery() {
		return "Welcome to GraphQL";
	}
}
