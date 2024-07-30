package com.dassault.graphql.models;

import java.util.List;

public record Movie(Integer id, String title, int year, List<String> genres, String director) {}
