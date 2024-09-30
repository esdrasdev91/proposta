# proposta

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```


![Arquitetura-projeto-Microsserviços](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjp0kc7mCs6pgnh4hPUSd4MHyCzJYBUTYLDw1Mz3oN2ENdWMc6a_RcSlRK94ar_r9jigsJ7jN2IcvKFT8oeEF7ngf-Atauz_tok_5ogwSjt4wTVLUlQbUmyxOStpnH0NZ6VPkw0BFmx5CQS_IzIi4Z6nxf7R5uvfGehN6qVrqFLLjbjGA/s1600/ArquiteturaCurso.jpg)

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/proposta-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- REST Jackson ([guide](https://quarkus.io/guides/rest#json-serialisation)): Jackson serialization support for Quarkus REST. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it
- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
- JDBC Driver - PostgreSQL ([guide](https://quarkus.io/guides/datasource)): Connect to the PostgreSQL database via JDBC


## Execução OpenTelemetry tracing com Jaeger:

Execução do Jaeger:
Certifique-se de que o Jaeger está em execução. Se você não o tiver configurado ainda, pode usar o Docker para isso:

bash
Copiar código
docker run -d --name jaeger \
-e COLLECTOR_ZIPKIN_HTTP_PORT=9411 \
-p 5775:5775/udp \
-p 6831:6831/udp \
-p 6832:6832/udp \
-p 5778:5778 \
-p 16686:16686 \
-p 14268:14268 \
-p 14250:14250 \
-p 9411:9411 \
jaegertracing/all-in-one:1.31

### O Jaeger estará disponível em http://localhost:16686, onde você poderá visualizar os traces gerados pelo seu serviço.

## Verificação no Jaeger:
   Após iniciar o Jaeger e rodar a aplicação Quarkus, você pode acessar http://localhost:16686, pesquisar pelo serviço proposta e visualizar os traces das requisições.

Com isso, o Jaeger estará configurado para monitorar a aplicação Quarkus utilizando OpenTelemetry.
