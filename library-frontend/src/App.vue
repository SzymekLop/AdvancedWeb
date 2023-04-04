<template>
  <div id="app">
    <div id="page-header" class="content-box shadow-box">
      <!-- //<h1 class="page-header-item"><a class="page-button" href="/">Book Service</a></h1> -->
      <a class="page-button button shadow-box" href="books">Books</a>
      <a class="page-button button shadow-box" href="authors">Authors</a>
    </div>
    <div id="page-content" class="content-box shadow-box">
      <h1> Welcome to the Book Service! </h1>
    </div>
  </div>
</template>

<script>

export default {
  name: 'App',
}
</script>

<style>
/* body {
  height: 100%;
} */

/* .bg-image { 
  position: fixed;
  left: -15px;
  top: -15px;
  z-index: -1;
  display: block;
  background-position: center; 
  background-repeat: no-repeat; 
  background-size: cover;
  width: 105%;
  height: 105%;
  -webkit-filter: blur(4px);
  -moz-filter: blur(4px);
  -o-filter: blur(4px);
  -ms-filter: blur(4px);
  filter: blur(4px);
} */

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;

  text-align: center;
  color: #2c3e50;
}

#page-header {
  display: flex;
  align-items: center;
  margin-bottom: 30px;
  margin-top: 30px;
  height: 120px;
  padding: 0 25px;
}

#page-header .page-header-item {
  font-size: 45px;
  color: rgb(0, 0, 0);
  margin-right: 25%;
}

#page-content {
  padding: 25px 25px;
}

/* .content-box {
  margin: 0 auto;
  border-radius: 10px;
  width: 65%;
  opacity: .99;
  color: rgb(0, 0, 0);
  box-shadow:  3px 3px 5px 3px rgba(0,0,0,.2);
} */


.shadow-box { 

  box-shadow:  3px 3px 5px 3px rgba(0,0,0,.2);
}

.page-button {
  color: rgb(0, 0, 0);
  text-decoration: none;
}

.button {

  border-radius: 10px;
  padding: 15px;
  font-size: 22px;
  min-width: 150px;
  margin: 15px;
  cursor: pointer;
  box-shadow:  3px 3px 5px 3px rgba(0,0,0,.2);
}

.button:hover {
  background-color: #000000;
  color: white;
}

.button-small {
  background-color: #ffffff;

  border-radius: 10px;
  padding: 5px;
  font-size: 17px;
  min-width: 90px;
  margin: 5px;
  cursor: pointer;
  box-shadow:  3px 3px 5px 3px rgba(0,0,0,.2);
}

.button-small:hover {
  background-color: #000000;
  color: white;

}

.btn-active {
  background-color: #e8c7ae;
}

/* FORMS */

.form-field{
    display: flex;
    align-items: flex-start;
    margin-bottom: 10px;
}

.form-field input {
    width: 150px;
    font-size: 16px;  
}

.form-field select {
    width: 158px;
    font-size: 16px; 
}

.form-field label {
    font-size: 20px;
    margin-right: 20px;
    min-width: 110px;
    text-align: left;
}

.adding-book-form-container .form-field label {
    min-width: 75px;
}

[class*='-message']{
    font-weight: 500;
}

.error-message{
    color: rgb(255, 38, 0);
}

.success-message {
    color: rgb(6, 216, 41)
}

</style>
