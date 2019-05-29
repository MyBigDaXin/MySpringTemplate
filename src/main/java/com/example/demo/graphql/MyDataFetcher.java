package com.example.demo.graphql;

import graphql.schema.DataFetchingEnvironment;

public interface MyDataFetcher {
    String filedName();

    Object dataFetcher(DataFetchingEnvironment environment);
}
