package com.example.demo.graphql;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * * @description:GraphQl服务
 * * @author: Tonghuan
 * * @create: 2019/4/1
 **/
@Component
public class GraphQLProvider {

    private GraphQL graphQL;

    @Autowired
    private List<MyDataFetcher> myDataFetchers;

    @PostConstruct
    public void init() throws IOException {
        File file = ResourceUtils.getFile("classpath:user.graphql");
        GraphQLSchema graphQLSchema = buildSchema(file);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(File file) {

        // TODO: we will create the schema here later
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(file);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry,runtimeWiring);
    }

    private RuntimeWiring buildWiring(){

        return RuntimeWiring.newRuntimeWiring().type("UserQuery",
                builder ->{
                    for(MyDataFetcher myDataFetcher:myDataFetchers){
                        builder.dataFetcher(myDataFetcher.filedName(),environment->
                                myDataFetcher.dataFetcher(environment)
                        );
                    }
                    return builder;
                }).build();
    }

    @Bean
    public GraphQL getGraphQL() {
        return graphQL;
    }
}
