<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login & Registration</title>
    <link rel="stylesheet" href="login.css" type="text/css">
  </head>
  
  <body>
    <header>
      <h2 class ="logo">Logo</h2>
      <nav class="nav">
        <a href="#">Home</a>

        <a href="#">About</a>
        <a href="#">Contact</a>
        <button class="btnLogin-popup">Login</button>
      </nav>
    </header>

    <% boolean isUser = (boolean) request.getAttribute("isUser"); %>

    <div class="wrapper">
      
      <div class="form-box login">
        <h2>Login</h2>
        <form action = "/Appliweb1/ControleurLogin" method ="post">
          <div class="input-box">
            <span class="icon"><ion-icon name="person"></ion-icon></span>
            <input type="text" name="login" required>
            <label>Username</label>
          </div>
          <div class="input-box">
            <span class="icon"><ion-icon name="lock-closed"></ion-icon></span>
            <input type="password" name="password" required>
            <label>Password</label>
          </div>
          <button type="submit" name = "op" value = "Login" class="btnLogin">Login</button>
          <div class="login-register">
            <p> Don't have an account? <a href="#" class = "register-link">Register</a></p>
          </div>
        </form>
      </div>

      <div class="form-box register">
        <h2>Registration</h2>
        <form action = "/Appliweb1/ControleurLogin" method ="post">
          <div class="input-box">
            <span class="icon"><ion-icon name="person"></ion-icon></span>
            <input type="text" name="login" required>
            <label>Username</label>
          </div>
          <div class="input-box">
            <span class="icon"><ion-icon name="lock-closed"></ion-icon></span>
            <input type="password" name="password" required>
            <label>Password</label>
          </div>
          <div class="agree-condition">
            <label><input type="checkbox" required> I agree to the terms and conditions</label>
          </div>
          <button type="submit" name = "op" value = "Register" class="btnLogin">Register</button>
          <div class="login-register">
            <p> Already have an account? <a href="#" class = "login-link">Login</a></p>
          </div>
        </form> 
      </div>
    
    </div>
    <script>var isUser ='<%= isUser %>';</script>
    <script src="login.js"></script>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script> 
  </body>
</html>