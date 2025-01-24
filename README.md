
# E-Commerce API

A RESTful API designed to manage products, orders, and users for an e-commerce platform.


## Installation

Below is an example on how to run this API.

1. Clone this repository:

```bash
git clone https://github.com/jsong2958/E-Commerce-API
```

2. Navigate into the project directory:

```bash
cd "E-Commerce-API"
```

3. Build the project with Maven or Gradle:

```bash
mvn install
```

4. Run the application:

```bash
mvn spring-boot:run
```

(Optional) If using Docker:

```bash
docker build -t e-commerce-api .
docker run -p 8080:8080 e-commerce-api
```

## API Reference

#### Get All Customers

```http
GET /customers
```

#### Create Customer

```http
POST /customers

```

Request Body:

```json
{
  "name": "John Doe",
  "email": "johndoe@example.com",
  "phone_number": "+1234567890",
  "shipping_address": "1234 Elm Street, Springfield, IL, 62701"
}

```

#### Update Customer

```http
PUT /customer/{id}
```

Request Body:

```json
{
  "name": "Joseph Doe",
  "email": "josephdoe@example.com",
  "phone_number": "+1234567890",
  "shipping_address": "1234 Elm Street, Springfield, IL, 62701"
}
```

#### Create Item


```http
POST /items
```

Request Body:

```json
{
  "id": 1,
  "product": "Grilled Chicken",
  "quantity": 2,
  "price": 50.00,
  "cart_id": 101
}

```

#### Create Cart


```http
POST /cart
```

#### Add Item To Cart


```http
POST /cart/items/{cartId}
```

Request Body:

```json
{
  "id": 1,
  "product": "Grilled Chicken",
  "quantity": 2,
  "price": 50.00,
  "cart_id": 101
}

```

#### Add Customer To Cart


```http
POST /cart/customer/{cartId}
```

Request Body:

```json
{
  "name": "John Doe",
  "email": "johndoe@example.com",
  "phone_number": "+1234567890",
  "shipping_address": "1234 Elm Street, Springfield, IL, 62701"
}

```

#### Get Cart


```http
GET /cart/{cartId}
```

#### Delete Item From Cart


```http
DELETE /cart/{cartId}
```

Request Body:

```json
Grilled Chicken

```
