# API Order Spring

Welcome to the **API Order Spring** repository! This is a RESTful API for managing orders, built with Spring. The API supports hypermedia, providing links for navigation between related resources. Additionally, the API includes pagination for retrieving large sets of data and supports three states for orders: `IN_PROGRESS`, `COMPLETED`, and `CANCELLED`.
## Table of Contents
- [Getting Started](#getting-started)
- [Endpoints](#endpoints)
- [Hypermedia](#hypermedia)
- [Examples](#examples)
- [Diagram example](#diagram-example)
- [Contributing](#contributing)

## Getting Started

To get started with the API Order Spring project, follow these steps:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/emmanuelgrp/order-api-rest.git
   ```

2. **Navigate to the project directory:**
   ```bash
   cd order-api-rest
   ```

3. **Build the project using Maven:**
   ```bash
   mvn clean install
   ```

4. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

The API will be available at `http://localhost:8080`.

## Endpoints

The following endpoints are available in the API:

### Get All Orders
- **URL:** `/orders?page=0&size=10`
- **Method:** `GET`
- **Description:** Retrieves a list of all orders.

### Get Order by ID
- **URL:** `/orders/{id}`
- **Method:** `GET`
- **Description:** Retrieves a specific order by its ID.

### Create Order
- **URL:** `/orders`
- **Method:** `POST`
- **Description:** Creates a new order.
- **Request Body:** 
  ```json
  {
    "description": "Order description",
    "status": "IN_PROGRESS"
  }
  ```
### Cancel Order
- **URL:** `/orders/{id}/cancel`
- **Method:** `DELETE`
- **Description:** Cancels an order.
  ```json
  {
      "id": 33,
      "description": "Logitech MX Master 3 Advanced Wireless Mouse",
      "status": "CANCELLED",
      "_links": {
          "self": {
              "href": "http://localhost:8080/orders/33"
          },
          "orders": {
              "href": "http://localhost:8080/orders"
          }
      }
  }
  ```
### Complete Order
- **URL:** `/orders/{id}/complete`
- **Method:** `PUT`
- **Description:** Marks an order as completed.
  ```json
  {
      "id": 36,
      "description": "New Order",
      "status": "COMPLETED",
      "_links": {
          "self": {
              "href": "http://localhost:8080/orders/36"
          },
          "orders": {
              "href": "http://localhost:8080/orders"
          }
      }
  }
  ```

## Hypermedia

This API uses HATEOAS (Hypermedia as the Engine of Application State) principles, providing links in the responses to guide clients on available actions. Here is an example of an order resource with hypermedia links:

```json
{
    "id": 36,
    "description": "Test Order",
    "status": "IN_PROGRESS",
    "_links": {
        "self": {
            "href": "http://localhost:8080/orders/36"
        },
        "orders": {
            "href": "http://localhost:8080/orders"
        },
        "cancel": {
            "href": "http://localhost:8080/orders/36/cancel",
            "title": "Cancel Order",
            "type": "DELETE"
        },
        "complete": {
            "href": "http://localhost:8080/orders/36/complete",
            "title": "Complete Order",
            "type": "PUT"
        }
    }
}
```

### Link Definitions

- **Self:** Link to the current order resource.
- **Orders:** Link to the collection of all orders.
- **Cancel:** Link to cancel the current order (available when the order is in progress).
- **Complete:** Link to mark the current order as completed (available when the order is in progress).

## Examples

### Example Request to Get All Orders

**Request:**
```bash
curl -X GET http://localhost:8080/orders
```

**Response:**
```json
{
    "_embedded": {
        "orderList": [
            {
                "id": 35,
                "description": "Sony PlayStation 5 DualSense Wireless Controller",
                "status": "COMPLETED",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/orders/35"
                    },
                    "orders": {
                        "href": "http://localhost:8080/orders"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/orders"
        }
    }
}
```

### Example Request to Create a New Order

**Request:**
```bash
curl -X POST http://localhost:8080/orders \
-H "Content-Type: application/json" \
-d "{\"description\": \"New Order\", \"status\": \"IN_PROGRESS\"}"
```

**Response:**
```json
{
    "id": 37,
    "description": "New Order",
    "status": "IN_PROGRESS",
    "_links": {
        "self": {
            "href": "http://localhost:8080/orders/37"
        },
        "orders": {
            "href": "http://localhost:8080/orders"
        },
        "cancel": {
            "href": "http://localhost:8080/orders/37/cancel",
            "title": "Cancel Order",
            "type": "DELETE"
        },
        "complete": {
            "href": "http://localhost:8080/orders/37/complete",
            "title": "Complete Order",
            "type": "PUT"
        }
    }
}
```

## Diagram example
![Diagrama de la API](https://github.com/emmanuelgrp/order-api-rest/blob/main/DIAGRAM.png)

## Contributing

Contributions are welcome! Please submit a pull request or open an issue to discuss any changes.
