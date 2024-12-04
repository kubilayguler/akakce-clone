<template>
    <div v-if="products.length > 0 && products[0]" class=" container bg-custom pt-4" style="height: 100vh; ">
        <div class="card d-flex flex-row align-items-start " style="height: 500px;">
            <img class="card-img-left" :src="products[0].urunResimLinki" alt="Ürün Resmi"
                style="width: 400px; flex: 0 0 auto; height: 500px; object-fit: contain; text-align: center">
            <div class="card-body">
                <p class="card-text text-primary" style="font-size: 1em; margin-top: 2em; margin-bottom: -3px;">
                    {{ products[0].marka }}
                </p>

                <p class="card-text" style="font-size: 1.2rem; margin-bottom: -3px;">
                    {{ products[0].marka }}
                    {{ products[0].modelAdi }}
                    {{ products[0].modelNo }}
                    {{ products[0].islemciTipi }}
                    {{ products[0].islemciNesili }}
                    {{ products[0].ram }} GB
                    {{ products[0].diskBoyutu }}
                    {{ products[0].diskTipi }}
                    {{ products[0].ekranBoyutu }}
                </p>
                <p class="card-text" style="font-size: 1.2rem; ">
                    <star-rating :rating="Number(products[0].puan)" :read-only="true" :star-size="16" :increment="0.1"
                        :show-rating="false" :half-stars="true" :active-color="'#FFD700'"></star-rating>

                </p>
                <p class="card-text" style="font-size: 2.2em;  ">
                    <span style="font-weight: 500;">{{ getFiyatTam(products[0].fiyat) }}</span>
                    <span style="font-size: large;">,{{ getFiyatKusurat(products[0].fiyat) }} TL</span>
                </p>
                <a href="/"><button class="btn btn-primary fw-bold">Satıcıya Git <font-awesome-icon
                            icon="fa-location-arrow" /></button>
                </a>
                <div class="sellers  d-flex" style="margin-top: 6rem;">
                    <div class="seller " v-for="seller in products[0].sellers" :key="seller.id">
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
        </div>
    </div>

</template>

<script>
import ProductService from '@/services/ProductService';
import StarRating from 'vue-star-rating';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

export default {
    name: 'Details',
    components: {
        StarRating,
        FontAwesomeIcon
    },
    data() {
        return {
            modelNo: this.$route.params.modelNo,
            products: [], // Ürünleri tutacak dizi
        };
    },
    watch: {
        '$route.params.modelNo': function (newModelNo) {
            this.modelNo = newModelNo;
            this.fetchProductDetails(); // Yeni model no ile veri çekme işlemi
        },
    },
    created() {
        this.fetchProductDetails();
    },
    methods: {
        fetchProductDetails() {
            ProductService.getProductsByModelNo(this.modelNo)
                .then(response => {
                    this.products = response.data;
                })
                .catch(error => {
                    console.error('Error fetching product details:', error);
                    this.products = []; 
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
};


</script>

<style scoped>
.bg-custom {
    background-color: #eeeeee;
}
</style>