package com.akakce.backend;

import com.akakce.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Autowired
	private ProductRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
//		Product employee1 = Product.builder()
//				.marka("Samsung")
//				.modelAdi("Galaxy S21")
//				.modelNo("SM-G991U")
//				.isletimSistemi("Android")
//				.islemciTipi("Snapdragon 888")
//				.islemciNesili("8. Nesil")
//				.ram(12)
//				.diskBoyutu("256 GB")
//				.diskTipi("SSD")
//				.ekranBoyutu(6.2)
//				.puan(4.5)
//				.fiyat(999.99f)
//				.siteAdi("Amazon")
//				.siteLogoLinki("https://upload.wikimedia.org/wikipedia/commons/a/a9/Amazon_logo.svg")
//				.urunResimLinki("https://m.media-amazon.com/images/I/515YICjEg7L._AC_UF1000,1000_QL80_.jpg")
//				.build();
//
//		Product employee2 = Product.builder()
//				.marka("Apple")
//				.modelAdi("iPhone 13 Pro")
//				.modelNo("MLL63TU/A")
//				.isletimSistemi("iOS")
//				.islemciTipi("Apple A15 Bionic")
//				.islemciNesili("N/A")
//				.ram(6)
//				.diskBoyutu("512 GB")
//				.diskTipi("SSD")
//				.ekranBoyutu(6.1)
//				.puan(4.8)
//				.fiyat(1099.99f)
//				.siteAdi("Apple Store")
//				.siteLogoLinki("https://upload.wikimedia.org/wikipedia/commons/f/fa/Apple_logo_black.svg")
//				.urunResimLinki("https://www.apple.com/newsroom/images/product/iphone/standard/Apple_iPhone-13-Pro_Colors_09142021_big.jpg.large.jpg")
//				.build();
//
//		Product employee3 = Product.builder()
//				.marka("Lenovo")
//				.modelAdi("ThinkPad X1 Carbon")
//				.modelNo("20U9001NUS")
//				.isletimSistemi("Windows 10 Pro")
//				.islemciTipi("Intel Core i7")
//				.islemciNesili("10. Nesil")
//				.ram(16)
//				.diskBoyutu("1 TB")
//				.diskTipi("SSD")
//				.ekranBoyutu(14.0)
//				.puan(4.7)
//				.fiyat(1699.99f)
//				.siteAdi("Newegg")
//				.siteLogoLinki("https://c1.neweggimages.com/WebResource/Themes/Nest/logos/Newegg_full_color_logo_RGB.SVG")
//				.urunResimLinki("https://www.notebookcheck-tr.com/uploads/tx_nbc2/x1_carbon_g11.jpg")
//				.build();
//
//		Product employee4 = Product.builder()
//				.marka("Dell")
//				.modelAdi("XPS 15")
//				.modelNo("XPS7590-7572SLV-PUS")
//				.isletimSistemi("Windows 10 Home")
//				.islemciTipi("Intel Core i7")
//				.islemciNesili("9. Nesil")
//				.ram(32)
//				.diskBoyutu("1 TB")
//				.diskTipi("SSD")
//				.ekranBoyutu(15.6)
//				.puan(4.6)
//				.fiyat(2199.99f)
//				.siteAdi("Best Buy")
//				.siteLogoLinki("https://www.bestbuy.com/~assets/bby/_com/header-footer/images/bby_logo-a7e90594729ed2e119331378def6c97e.png")
//				.urunResimLinki("https://m.media-amazon.com/images/I/51oj7-YIfAL._AC_UF1000,1000_QL80_.jpg")
//				.build();
//
//		Product employee5 = Product.builder()
//				.marka("HP")
//				.modelAdi("Spectre x360")
//				.modelNo("13-aw0023dx")
//				.isletimSistemi("Windows 11 Home")
//				.islemciTipi("Intel Core i7")
//				.islemciNesili("11. Nesil")
//				.ram(16)
//				.diskBoyutu("512 GB")
//				.diskTipi("SSD")
//				.ekranBoyutu(13.3)
//				.puan(4.9)
//				.fiyat(1399.99f)
//				.siteAdi("HP Store")
//				.siteLogoLinki("https://www.hpstore.com.tr/Data/EditorFiles/tasarim/hp-logo-black.svg")
//				.urunResimLinki("https://www.hpstore.com.tr/hp-spectre-x360-laptop-14-ef2004nt-i7-1355u-16gb-ram-1tb-ssd-intel-iris-xe-graphics-135-inc-wuxga-dokunmatik-windows-11-home-siyah-7p697ea-14140-18-B.jpg")
//				.build();
//
//		Product[] employees = new Product[] {employee1, employee2, employee3, employee4, employee5};
//		for (Product employee : employees) {
//				employeeRepository.save(employee);
//		}
	}
}
