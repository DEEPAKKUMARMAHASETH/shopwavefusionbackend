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

