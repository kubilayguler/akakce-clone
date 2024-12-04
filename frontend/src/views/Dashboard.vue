<template>
  <div>
    <LoginPanel v-if="!isAuthenticated" @authenticated="handleAuthentication"></LoginPanel>
    <div v-else>
      <div class="container text-success text-center border" style="height: 100vh; overflow: auto;">
        <h3>Dashboard</h3>
        <p>Welcome to the admin dashboard!</p>
        <table class="table table-striped text-white">
          <thead>
            <tr>
              <th>Id</th>
              <th>Foto</th>
              <th>Marka</th>
              <th>Model Adı</th>
              <th>Model No</th>
              <th>İşletim Sistemi</th>
              <th>İşlemci Tipi</th>
              <th>İşlemci Nesli</th>
              <th>Ram</th>
              <th>Disk Boyutu</th>
              <th>Disk Türü</th>
              <th>Ekran Boyutu</th>
              <th>Puanı</th>
              <th>Fiyat</th>
              <th>Site Adı</th>
              <th>Logo</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="product in products" :key="product.id">
              <td>{{ product.id }}</td>
              <td><img :src="product.urunResimLinki" alt="" style="width: 50px; height: 50px;"></td>
              <td>{{ product.marka }}</td>
              <td>{{ product.modelAdi }}</td>
              <td>{{ product.modelNo }}</td>
              <td>{{ product.isletimSistemi }}</td>
              <td>{{ product.islemciTipi }}</td>
              <td>{{ product.islemciNesili }}</td>
              <td>{{ product.ram }}</td>
              <td>{{ product.diskBoyutu }}</td>
              <td>{{ product.diskTipi }}</td>
              <td>{{ product.ekranBoyutu }}</td>
              <td>{{ product.puan }}</td>
              <td>{{ product.fiyat }}</td>
              <td>{{ product.siteAdi }}</td>
              <td><img :src="product.siteLogoLinki" alt="" style="width: 50px; height: 30px;"></td>
              <td>
                <button style="width: 7px; " class="btn btn-primary" @click="editProduct(product)">E</button>
                <button style="width: 7px; margin: 0 2px;" class="btn btn-danger" @click="deleteProduct(product.id)">X</button>
              </td>
            </tr>
            <tr>
              <td>-</td>
              <td><input v-model="newproduct.urunResimLinki" type="text" placeholder="Ürün Foto"></td>
              <td><input v-model="newproduct.marka" type="text" placeholder="Marka"></td>
              <td><input v-model="newproduct.modelAdi" type="text" placeholder="Model Adı"></td>
              <td><input v-model="newproduct.modelNo" type="text" placeholder="Model No"></td>
              <td><input v-model="newproduct.isletimSistemi" type="text" placeholder="İşletim Sistemi"></td>
              <td><input v-model="newproduct.islemciTipi" type="text" placeholder="İşlemci Tipi"></td>
              <td><input v-model="newproduct.islemciNesili" type="text" placeholder="İşlemci Nesli"></td>
              <td><input v-model="newproduct.ram" type="number" min="0" placeholder="Ram"></td>
              <td><input v-model="newproduct.diskBoyutu" type="text" placeholder="Disk Boyutu"></td>
              <td><input v-model="newproduct.diskTipi" type="text" placeholder="Disk Türü"></td>
              <td><input v-model="newproduct.ekranBoyutu" type="number" min="0" placeholder="Ekran Boyutu"></td>
              <td><input v-model="newproduct.puan" type="number" min="0" max="10" step="0.1" placeholder="Puan"></td>
              <td><input v-model="newproduct.fiyat" type="number" min="0" placeholder="Fiyat"></td>
              <td><input v-model="newproduct.siteAdi" type="text" placeholder="Site Adı"></td>
              <td><input v-model="newproduct.siteLogoLinki" type="text" placeholder="Site Logo"></td>
              <td><button class="btn btn-primary" @click="addproduct">Ekle</button></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import ProductService from '../services/ProductService'
import LoginPanel from '@/components/LoginPanel.vue'
import Editor from '../components/Editor.vue'

export default {
  name: 'Dashboard',
  components: {
    FontAwesomeIcon,
    LoginPanel,
    Editor
  },
  data() {
    return {
      products: [],
      isAuthenticated: false,
      newproduct: {
        marka: '',
        modelAdi: '',
        modelNo: '',
        isletimSistemi: '',
        islemciTipi: '',
        islemciNesili: '',
        ram: null,
        diskBoyutu: '',
        diskTipi: '',
        ekranBoyutu: null,
        puan: null,
        fiyat: null,
        siteAdi: '',
        urunResimLinki: '',
        siteLogoLinki: ''
      }
    };
  },
  methods: {
    handleAuthentication() {
      this.isAuthenticated = true;
    },
    getProducts() {
      ProductService.getProducts()
        .then(response => {
          this.products = response.data;
        })
        .catch(error => {
          console.error('Error fetching products:', error);
        });
    },
    getNextId() {
      if (this.products.length === 0) return 1;
      const ids = this.products.map(product => product.id);
      const maxId = Math.max(...ids);
      for (let i = 1; i <= maxId; i++) {
        if (!ids.includes(i)) return i;
      }
      return maxId + 1;
    },
    addproduct() {
      this.newproduct.id = this.getNextId();
      ProductService.addProduct(this.newproduct)
        .then(() => {
          this.getProducts();
          this.resetNewproduct(); 
        })
        .catch(error => {
          console.error('Error adding product:', error);
        });
    },
    deleteProduct(productId) {
    ProductService.deleteProductById(productId)
      .then(() => {
        this.getProducts(); // Refresh the product list
      })
      .catch(error => {
        console.error('Error deleting product:', error);
      });
  },
    resetNewProduct() {
      this.newproduct = {
        marka: '',
        modelAdi: '',
        modelNo: '',
        isletimSistemi: '',
        islemciTipi: '',
        islemciNesili: '',
        ram: null,
        diskBoyutu: '',
        diskTipi: '',
        ekranBoyutu: null,
        puan: null,
        fiyat: null,
        siteAdi: '',
        urunResimLinki: '',
        siteLogoLinki: ''
      };
    }
  },
  created() {
    // Başlangıçta çalışanları yükle
    this.getProducts();
  }
}
</script>

<style scoped>
.container {
  padding: 16px;
}

table {
  width: 100%;
  table-layout: fixed;
}

table thead th,
table tbody td {
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

input {
  width: 100%;
  box-sizing: border-box;
}

button {
  width: 100%;
  box-sizing: border-box;
}
</style>
