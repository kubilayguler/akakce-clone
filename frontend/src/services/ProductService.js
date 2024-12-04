import axios from 'axios';

const API_URL = 'http://localhost:8080/api';

class ProductService {
  getProducts() {
    return axios.get(`${API_URL}/products`);
  }
  getAllProducts() {
    return axios.get(`${API_URL}/products/all`);
  }
  getProductsByModelNo(modelNo) {
    const url = `${API_URL}/products/model/${modelNo}`;
    return axios.get(url);
  }
  addProduct(product) {
    return axios.post(`${API_URL}/products/all`, product);
  }
  deleteProductById(productId) {
    return axios.delete(`${API_URL}/products/${productId}`);
  }
}

export default new ProductService();
