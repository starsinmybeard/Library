import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../views/HomePage.vue';
import LibraryPage from '../views/LibraryPage.vue';
import StatsPage from '../views/StatsPage.vue';
import BookClub from "../views/BookClub.vue";
import AddBook from "../components/AddBook";
import BookPage from "../views/BookPage.vue";


const routes = [
  {path: '/', name: 'Home', component: HomePage},
  {path: '/library', name: 'Library', component: LibraryPage},
  {path: '/stats', name: 'Stats', component: StatsPage},
  {path: '/BookClub', name: 'BookClub', component: BookClub},
  {path: '/AddBook', name: 'AddBook', component:AddBook},
  {path: '/Book/:bookId', name: 'Book', component:BookPage}
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
