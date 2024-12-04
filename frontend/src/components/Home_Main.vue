<template>
    <div style="min-height: 2000px;">


        <div class="container  border border-dark" style="min-height: 1000px;">
            <a v-for="product in products" :key="product.id"
                :href="`http://localhost:5173/model/${product.modelNo}`" class="card d-flex flex-row align-items-start"
                style="width: 100%;">
                <img class="card-img-left" :src="product.urunResimLinki" alt="Ürün Resmi"
                    style="width: 288px; flex: 0 0 auto; height: 305px; object-fit: contain; text-align: center">
                <div class="card-body">
                    <p class="card-text">{{ product.marka }} {{ product.modelAdi }} {{ product.modelNo }} {{
                        product.islemciNesili }} {{ product.islemciTipi }}
                        {{ product.ram }} {{ product.diskBoyutu }} {{ product.diskTipi }} {{ product.ekranBoyutu }}
                    </p>
                    <div class="sellers  d-flex" style="margin-top: 6rem;">
                        <div class="seller " v-for="seller in product.sellers" :key="seller.id">
                            <div class="card-body">
                                <h5 class="card-title smaller-text bold">{{ seller.puan }} Puan</h5>
                                <h4 class="card-text">{{ getFiyatTam(seller.fiyat) }}<small style="font-size: medium;">,
                                        {{ getFiyatKusurat(seller.fiyat) }}TL</small></h4>
                                <h5 class="card-title green small-text">Ücretsiz kargo</h5>
                                <button class="shadow-sm border btn-custom">
                                    <img :src="seller.siteLogoLinki" alt="Logo Resmi">
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </a>
        </div>

    </div>


</template>


<script>
import ProductService from '../services/ProductService'

export default {
    name: 'products',
    data() {
        return {
            products: [],
        }
    },
    methods: {
        getProducts() {
            // Fetch all products
            ProductService.getProducts()
                .then(response => {
                    this.products = response.data;
                    // For each product, fetch sellers by model number
                    this.products.forEach(product => {
                        this.getProductsByModelNo(product.modelNo)
                            .then(sellers => {
                                // Assign fetched sellers to the product
                                product.sellers = sellers;
                            })
                            .catch(error => {
                                console.error('Error fetching sellers:', error);
                            });

                    });
                })
                .catch(error => {
                    console.error('Error fetching products:', error);
                });
        },
        // Fetch sellers by model number
        getProductsByModelNo(modelNo) {
            return ProductService.getProductsByModelNo(modelNo)
                .then(response => {
                    return response.data; // Assuming response.data is an array of sellers
                })
                .catch(error => {
                    console.error('Error fetching sellers:', error);
                    return []; // Return an empty array or handle error as needed
                });
        },
        getFiyatTam(fiyat) {
            return fiyat.toString().split('.')[0];
        },
        getFiyatKusurat(fiyat) {
            const parts = fiyat.toString().split('.');
            if (parts[1] == null || parts[1] == undefined) {
                parts[1] = '00';
            }
            return parts[1];
        }
    },
    created() {
        // Tüm çalışanları yükler
        this.getProducts();
    }

}
</script>

<style>
a {
    text-decoration: none;
    color: inherit;
}

.btn-custom {
    width: 150px;
    height: 40px;
    display: flex;
    justify-content: center;
    align-items: center;
    position: relative;
    border-radius: 100px;
    background-color: #cfebfc;
    /* Örnek bir arka plan rengi */
}


.btn-custom img {
    max-width: 100%;
    max-height: 100%;
    object-fit: contain;
    /* Görseli buton boyutlarına sığdır */
}


.seller {
    max-width: 200px;
    max-height: 200px;
}

.smaller-text {
    font-size: 10px;
}

.small-text {
    font-size: 12px;
}

.bold {
    font-weight: bold;
}

.green {
    color: #3CA886;
    font-weight: 500;
}

.btn-gray {
    background-color: rgb(243, 243, 243);

}
</style>
