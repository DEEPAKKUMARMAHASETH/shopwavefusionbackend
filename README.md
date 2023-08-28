### ShopWave Fusion E-Commerce Application Backend
<hr/>
<p>Welcome to the ShopWave Fusion E-Commerce Application Backend. This project is built using Spring Boot and incorporates Spring Security with JWT Token-based authorization for secure access. The backend serves as the core foundation for the ShopWave Fusion E-Commerce Application, providing the necessary functionality to manage products, orders, user authentication, and more.</p>

## Introduction
<p>This backend application can be integrated with any frontend UI application. You just need to follow few Steps.</p>

## Installation
<p>Clone this repository..</p>

## For Login

<p>Here is the sample Javascript code..</p>

```
async function fetchUserDetails() {
    const username = 'admin@gmail.com';
    const password = 'admin';
    
     const authHeader = 'Basic ' + btoa(username + ':' + password);
    
    
      try {
       const response = await fetch('http://localhost:8080/auth/signin', {
        method: 'GET',
        headers: {
          'Authorization': authHeader
          }
       });
        if (response.ok) {
         console.log(response.headers.get("Authorization"));
         const user = await response.json();
         console.log(user);
       } else {
          throw new Error('Failed to fetch user details');
        }
      } catch (error) {
        console.error('Error:', error);
       throw error;
     }
    }
```
<p>For other API request send the "Authorization Token" along with header</p>

## here is the sample code

```
to get product
async function getproduct() {
  let token = Stored Token from session Strorage or Local Storage
  
  const myHeaders = new Headers();
  myHeaders.append("Authorization", token);

  const requestOptions = {
    method: 'GET',
    headers: myHeaders,
    redirect: 'follow'
  };

  try {
    const response = await fetch("http://localhost:8080/all", requestOptions);
    
    if (response.ok) {
      const data = await response.json();
      console.log(data);
    } else {
      console.log("Response not OK:", response);
    }
  } catch (error) {
    console.error('Error:', error);
  }
}
```
## For Admin Login 
<p>
    There is a predefined admin credentials (email: "admin@example.com", password: "admin") in the config package with the class name AdminInitializer If you want you can use this admin as super admin also you can avoid this admin.
    Or you can change accordingly. if you don't want this then you can also delete this.
</p>

## API endpoint.

<p>To add product into cart</p>

`http://localhost:8080/cart/add` 

according to the domain add /cart/add "PUT MAPPING"<br/>

## Body

```
{
    "productId":2,
    "size":"M"
}
```

<p>Cart</p>

`http://localhost:8080/cart/` 

according to the domain add /cart/ "GET MAPPING"<br/>

<p>To add Product</p>

`http://localhost:8080/admin/products/`

## Body

```
{
  "title": "Sample Product",
  "description": "This is a sample product description.",
  "price": 2999,
  "discountedPrice": 2499,
  "discountPersent": 20,
  "quantity": 45,
  "brand": "Example Brand",
  "color": "Blue",
  "size": [
    {
      "name": "S",
      "quantity": 10
    },
    {
      "name": "M",
      "quantity": 20
    },
    {
      "name": "L",
      "quantity": 15
    }
  ],
  "imageUrl": "https://example.com/image.jpg",
  "topLavelCategory": "Clothing",
  "secondLavelCategory": "T-Shirts",
  "thirdLavelCategory": "Men's T-Shirts"
}

```

<p>To add multiple Product</p>

`http://localhost:8080/admin/products/creates`

```
[
  {
    "title": "Sample Product 1",
    "description": "This is a sample product description.",
    "price": 2999,
    "discountedPrice": 2499,
    "discountPersent": 20,
    "quantity": 100,
    "brand": "Example Brand",
    "color": "Blue",
    "size": [
      {
        "name": "S",
        "quantity": 10
      },
      {
        "name": "M",
        "quantity": 20
      }
    ],
    "imageUrl": "https://example.com/image1.jpg",
    "topLavelCategory": "Clothing",
    "secondLavelCategory": "T-Shirts",
    "thirdLavelCategory": "Men's T-Shirts"
  },
  {
    "title": "Sample Product 2",
    "description": "Another sample product description.",
    "price": 1999,
    "discountedPrice": 1799,
    "discountPersent": 10,
    "quantity": 50,
    "brand": "Another Brand",
    "color": "Red",
    "size": [
      {
        "name": "M",
        "quantity": 15
      },
      {
        "name": "L",
        "quantity": 10
      }
    ],
    "imageUrl": "https://example.com/image2.jpg",
    "topLavelCategory": "Clothing",
    "secondLavelCategory": "Shirts",
    "thirdLavelCategory": "Men's Shirts"
  }
]
```


<p>To get Product</p>

`http://localhost:8080/products/{product_id}`


