# Mini Checkout Enterprise

A checkout application in development. The first planned flow lets a shopper submit a cart and receive an order confirmation. The API will calculate the total and store the order in PostgreSQL.

## Monorepo layout

| Directory | Purpose |
| --- | --- |
| `apps/api/` | Java 21 and Spring Boot checkout API |
| `apps/web/` | Angular 21 checkout interface |
| `infra/` | Local Docker environment and future AWS deployment configuration |

## Development milestones

1. Set up the repository and document the project layout.
2. Implement order creation with unit tests for totals and integration tests for persistence.
3. Connect the checkout form to the API and test the submission flow.
4. Run builds and tests on pull requests with GitHub Actions.
5. Package the application with Docker and configure delivery to AWS.

## Run the API

With JDK 21 and Maven installed, run these commands from the repository root:

```sh
cd apps/api
mvn verify
mvn spring-boot:run
```

Open http://localhost:8080/actuator/health to check application health. The expected response is `{"status":"UP"}`.
