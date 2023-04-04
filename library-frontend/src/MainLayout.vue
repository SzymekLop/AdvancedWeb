<template>
  <div id="outer-page">
    <!-- <nav>

      <ul>
        <li>
          <router-link to="/"
            ><div class="button">Strona główna</div></router-link
          >
        </li>
        <li>
          <router-link to="/authors"
            ><div class="button">Autorzy</div></router-link
          >
        </li>
        <li>
          <router-link to="/books"
            ><div class="button">Książki</div></router-link
          >
        </li>
      </ul>
    </nav> -->
    <div id="main-content">
<router-view />
    </div>
    
  </div>
</template>
  
  <script>
export default {
  name: "MainLayout",
};
</script>

  <style scoped>
  #main-content {
    width: 70%;
  }

  .outer-page {
    display: flex;
    flex-direction: row;
    width: 90vw;

  }

  nav {
    width: 20%;;
  }
.button {
  border-radius: 10px;
  padding: 15px;
  font-size: 22px;
  min-width: 150px;
  margin: 15px;
  cursor: pointer;
  box-shadow: 3px 3px 5px 3px rgba(0, 0, 0, 0.2);
}

.button:hover {
  background-color: #000000;
  color: white;
}
</style>