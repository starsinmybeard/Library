import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../views/HomePage.vue';
import LibraryPage from '../views/LibraryPage.vue';
import ProfilePage from '../views/ProfilePage.vue';
import BookClub from "../views/BookClub.vue";
import AddBook from "../components/AddBook";

const routes = [
  {path: '/', name: 'Home', component: HomePage},
  {path: '/library', name: 'Library', component: LibraryPage},
  {path: '/profile', name: 'Profile', component: ProfilePage},
  {path: '/BookClub', name: 'BookClub', component: BookClub},
  {path: '/AddBook', name: 'AddBook', component:AddBook}
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
