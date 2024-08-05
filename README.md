
# Product Service API

## Descrição

Esta é a documentação da API para o serviço de produtos. A API fornece operações CRUD para gerenciar produtos. A documentação é gerada e visualizada usando o Springdoc OpenAPI.

## Tecnologias Utilizadas

- Spring Boot 3.3.2
- Spring Data JPA
- H2 Database
- Springdoc OpenAPI
- Maven

## Requisitos

- Java 17 ou superior
- Maven 3.6.0 ou superior

## Configuração do Projeto

### Dependências

As dependências do projeto são gerenciadas pelo Maven. Certifique-se de que as seguintes dependências estão incluídas no seu arquivo `pom.xml`:

```xml
<dependencies>
    <!-- Spring Boot dependencies -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    
    <!-- Springdoc OpenAPI dependencies -->
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.1.0</version>
    </dependency>
</dependencies>
```

### Configuração do Swagger

Crie uma classe de configuração para o Swagger em `src/main/java/com/example/productservice/config/SwaggerConfig.java`:

```java
package com.example.productservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Value("${springdoc.api-docs.path:/v3/api-docs}")
    private String apiDocsPath;

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("product-service")
                .pathsToMatch("/produtos/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Product Service API")
                .description("API documentation for Product Service")
                .version("v1.0")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
```

### Arquivo YAML para Documentação da API

Crie um arquivo `api-docs.yaml` na pasta `src/main/resources` com o seguinte conteúdo:

```yaml
openapi: "3.1.0"
info:
  title: "product_api API"
  description: "product_api API"
  version: "1.0.0"
servers:
  - url: "https://product_api"
paths:
  /produtos:
    post:
      summary: "POST produtos"
      operationId: "criarProduto"
      requestBody:
        content:
          application/json:
            schema:
              $ref: "#/components/schemas/ProdutoDTO"
        required: true
      responses:
        "200":
          description: "OK"
          content:
            '*/*':
              schema:
                $ref: "#/components/schemas/ProdutoDTO"
    get:
      summary: "GET produtos"
      operationId: "listarTodos"
      parameters:
        - name: "page"
          in: "query"
          required: false
          schema:
            type: "integer"
            format: "int32"
            default: "0"
        - name: "size"
          in: "query"
          required: false
          schema:
            type: "integer"
            format: "int32"
            default: "10"
      responses:
        "200":
          description: "OK"
          content:
            '*/*':
              schema:
                $ref: "#/components/schemas/ProdutoDTO"
  /produtos/{id}:
    put:
      summary: "PUT produtos/{id}"
      operationId: "atualizarProduto"
      parameters:
        - name: "id"
          in: "path"
          required: true
          schema:
            type: "integer"
            format: "int64"
      requestBody:
        content:
          application/json:
            schema:
              $ref: "#/components/schemas/ProdutoDTO"
        required: true
      responses:
        "200":
          description: "OK"
          content:
            '*/*':
              schema:
                $ref: "#/components/schemas/ProdutoDTO"
    delete:
      summary: "DELETE produtos/{id}"
      operationId: "removerProduto"
      parameters:
        - name: "id"
          in: "path"
          required: true
          schema:
            type: "integer"
            format: "int64"
      responses:
        "200":
          description: "OK"
          content:
            '*/*':
              schema:
                $ref: "#/components/schemas/Void"
    get:
      summary: "GET produtos/{id}"
      operationId: "obterPorId"
      parameters:
        - name: "id"
          in: "path"
          required: true
          schema:
            type: "integer"
            format: "int64"
      responses:
        "200":
          description: "OK"
          content:
            '*/*':
              schema:
                $ref: "#/components/schemas/ProdutoDTO"
components:
  schemas:
    ProdutoDTO:
      type: "object"
      properties:
        id:
          type: "integer"
          format: "int64"
        nome:
          type: "string"
        descricao:
          type: "string"
        preco:
          type: "number"
          format: "double"
        quantidade:
          type: "integer"
          format: "int32"
    Void:
      type: "object"
      properties: { }
```

### Configuração do `application.properties`

Configure o caminho do arquivo YAML no arquivo `application.properties`:

```properties
springdoc.api-docs.path=/v3/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.url=/v3/api-docs.yaml
```

## Estrutura do Projeto

Certifique-se de que a estrutura do seu projeto está organizada da seguinte forma:

```plaintext
product-service
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── br.com.grupomateus
│   │   │           └── product.api
│   │   │               ├── ProductServiceApplication.java
│   │   │               ├── configuration
│   │   │               │   ├── BeanConfig.java
│   │   │               │   ├── DatabaseLoader.java
│   │   │               │   ├── MessageSourceConfig.java        
│   │   │               │   └── SwaggerConfig.java
│   │   │               ├── adapter
│   │   │               │   ├── controller
│   │   │               │   │   └── ProdutoController.java
│   │   │               │   └── repository
│   │   │               │       ├── JpaProdutoRepository.java
│   │   │               │       └── ProdutoRepositoryImpl.java
│   │   │               ├── application
│   │   │               │   ├── dto
│   │   │               │   │   └── ProdutoDTO.java
│   │   │               │   ├── mapper
│   │   │               │   │   └── ProdutoMapper.java
│   │   │               │   ├── usecase
│   │   │               │   │   ├── create
│   │   │               │   │   │   ├── CreateProdutoUseCase.java
│   │   │               │   │   │   └── CreateProdutoUseCaseImpl.java
│   │   │               │   │   ├── update
│   │   │               │   │   │   ├── UpdateProdutoUseCase.java
│   │   │               │   │   │   └── UpdateProdutoUseCaseImpl.java
│   │   │               │   │   ├── delete
│   │   │               │   │   │   ├── DeleteProdutoUseCase.java
│   │   │               │   │   │   └── DeleteProdutoUseCaseImpl.java
│   │   │               │   │   ├── get
│   │   │               │   │   │   ├── GetProdutoUseCase.java
│   │   │               │   │   │   └── GetProdutoUseCaseImpl.java
│   │   │               │   │   └── list
│   │   │               │   │       ├── ListProdutoUseCase.java
│   │   │               │   │       └── ListProdutoUseCaseImpl.java
│   │   │               ├── domain
│   │   │               │   ├── model
│   │   │               │   │   └── Produto.java
│   │   │               │   ├── repository
│   │   │               │   │   └── ProdutoRepository.java
│   │   │               ├── factory
│   │   │               │   └── DAOFactory.java
│   │   │               └── exception
│   │   │                   ├── ProdutoNotFoundException.java
│   │   │                   └── GlobalExceptionHandler.java
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── productservice
│                       └── ProdutoServiceTest.java
├── pom.xml
├── src
│   ├── main
│   │   ├── resources
│   │   │   └── api-docs.yaml
└── README.md
```

## Executar a Aplicação

Para executar a aplicação, use o comando Maven:

```sh
mvn spring-boot:run
```

## Acessar a Documentação OpenAPI

Depois de iniciar a aplicação Spring Boot, você pode acessar a documentação OpenAPI nos seguintes URLs:

- JSON: `http://localhost:8080/v3/api-docs`
- UI: `http://localhost:8080/swagger-ui.html`

## Endpoints da API

### Produtos

- `POST /produtos` - Criar um novo produto
- `PUT /produtos/{id}` - Atualizar um produto existente
- `DELETE /produtos/{id}` - Remover um produto existente
- `GET /produtos` - Listar todos os produtos
- `GET /produtos/{id}` - Obter um produto por ID

## Contato

Para mais informações, entre em contato com [Charles Paiva](mailto:paiva.charles@gmail.com).

