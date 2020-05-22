import {ProductCategory} from './product-category';

export class ProductCatalogue {
  id: number;
  productName: string;
  productPrice: number;
  productImageUrl: string;
  productAddDate: Date;
  productDescription: string;
  productRating: number;
  categoryId: number;
  category: ProductCategory[];
}
