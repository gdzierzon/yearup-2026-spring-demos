# Northwind CRUD Client

Simple vanilla JavaScript client for the Northwind API.

## API Expected

The client expects the Spring Boot API to be running at:

```text
http://localhost:8080
```

You can change this in:

```text
js/config.js
```

## Pages

- Customers
- Categories
- Products

Each page supports:

- View all
- Add
- Edit
- Delete

## Notes

- There is no login.
- Products send the selected category as a nested object:

```json
{
  "productName": "Chai",
  "unitPrice": 18.00,
  "category": {
    "categoryId": 1
  }
}
```

- The client uses the same general EasyShop structure: Bootstrap, Axios, Mustache templates, services, and a small application controller file.
