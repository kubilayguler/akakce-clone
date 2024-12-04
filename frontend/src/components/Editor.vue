<template>
  <form @submit.prevent="addEmployee">
    <table>
      <tr>
        <td><label>Marka:</label></td>
        <td><input v-model="employee.marka" type="text" required></td>
      </tr>
      <tr>
        <td><label>Model Adı:</label></td>
        <td><input v-model="employee.modelAdi" type="text" required></td>
      </tr>
      <tr>
        <td><label>Model No:</label></td>
        <td><input v-model="employee.modelNo" type="text" required></td>
      </tr>
      <tr>
        <td><label>İşletim Sistemi:</label></td>
        <td><input v-model="employee.isletimSistemi" type="text"></td>
      </tr>
      <tr>
        <td><label>İşlemci Tipi:</label></td>
        <td><input v-model="employee.islemciTipi" type="text"></td>
      </tr>
      <tr>
        <td><label>İşlemci Nesli:</label></td>
        <td><input v-model="employee.islemciNesili" type="text"></td>
      </tr>
      <tr>
        <td><label>RAM:</label></td>
        <td><input v-model="employee.ram" type="number" min="0" required></td>
      </tr>
      <tr>
        <td><label>Disk Boyutu:</label></td>
        <td><input v-model="employee.diskBoyutu" type="text"></td>
      </tr>
      <tr>
        <td><label>Disk Tipi:</label></td>
        <td><input v-model="employee.diskTipi" type="text"></td>
      </tr>
      <tr>
        <td><label>Ekran Boyutu:</label></td>
        <td><input v-model="employee.ekranBoyutu" type="number" min="0"></td>
      </tr>
      <tr>
        <td><label>Puan:</label></td>
        <td><input v-model="employee.puan" type="number" min="0" max="10" step="0.1"></td>
      </tr>
      <tr>
        <td><label>Fiyat:</label></td>
        <td><input v-model="employee.fiyat" type="number" min="0" required></td>
      </tr>
      <tr>
        <td><label>Site Adı:</label></td>
        <td><input v-model="employee.siteAdi" type="text"></td>
      </tr>
      <tr>
        <td><label>Ürün Resim Linki:</label></td>
        <td><input v-model="employee.urunResimLinki" type="text"></td>
      </tr>
      <tr>
        <td><label>Site Logo Linki:</label></td>
        <td><input v-model="employee.siteLogoLinki" type="text"></td>
      </tr>
      <tr>
        <td colspan="2" style="text-align: center;">
          <button type="submit">Employee Ekle</button>
        </td>
      </tr>
    </table>
  </form>
</template>

  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        employee: {
          marka: '',
          modelAdi: '',
          modelNo: '',
          isletimSistemi: '',
          islemciTipi: '',
          islemciNesili: '',
          ram: 0,
          diskBoyutu: '',
          diskTipi: '',
          ekranBoyutu: 0,
          puan: 0.0,
          fiyat: 0.0,
          siteAdi: '',
          urunResimLinki: '',
          siteLogoLinki: ''
        }
      };
    },
    methods: {
      addEmployee() {
        axios.post('http://localhost:8080/api/products', this.employee)
          .then(response => {
            alert('Yeni Employee eklendi:', response.data);
            // Başarı durumunu işleyin, örneğin bir başarı mesajı gösterin
          })
          .catch(error => {
            alert('Employee eklenirken hata oluştu:', error);
            // Hata durumunu işleyin, örneğin bir hata mesajı gösterin
          });
      }
    }
  };
  </script>
  