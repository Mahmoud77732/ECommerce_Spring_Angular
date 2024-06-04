import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { Product } from '../../common/product';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent implements OnInit {

  products: Product[] = [];
  currentCategoryId: number = 1; // 1 by default
  searchMode : boolean = false;

  constructor(private productService : ProductService,
    private route: ActivatedRoute){
  }

  ngOnInit(): void {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    this.route.paramMap.subscribe(
      () => {
        this.listProducts();
      }
    );
  }

  listProducts(){
    this.searchMode = this.route.snapshot.paramMap.has('keyword');
    if(this.searchMode){
      this.handleSearchProducts();
    }
    else{
      this.handleListProducts();
    }
    
  }

  handleSearchProducts(){
    const thekeyword : string = this.route.snapshot.paramMap.get('keyword')!;
    
    // now search for the products using keyword
    this.productService.searchProducts(thekeyword).subscribe(
      data => {
        this.products = data;
      }
    );
  }

  handleListProducts(){
    // check id 'id' parameter is available
    const hascategoryId : boolean = this.route.snapshot.paramMap.has('id');
    if(hascategoryId){
      // get the 'id' param string, convert to a number using the '+' symbol
      this.currentCategoryId = +this.route.snapshot.paramMap.get('id')!; // '!' non null, '+' convert string to number
    }
    else{
      // not category id available ... default to category id = 1
      this.currentCategoryId = 1;
    }
    // now get the products for the given category id
    this.productService.getProductList(this.currentCategoryId).subscribe(
      data => {
        this.products = data;
      }
    )
  }

}
